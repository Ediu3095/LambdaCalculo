package lambda.interpreter;

import lambda.logic.SymbolTable;
import org.antlr.v4.runtime.tree.TerminalNode;

import lambda.term.*;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaBasicListener extends LambdaBaseListener {

    private final Stack<Term> stack = new Stack<>();
    private final SymbolTable table = new SymbolTable();

    public SymbolTable getResult() {
        return table;
    }

    @Override
    public void enterAssignment(LambdaParser.AssignmentContext ctx) {
        if (table.isVariableInTable(ctx.VARIABLE().getText())) {
            String pos = ctx.VARIABLE().getSymbol().getLine() + ":" + ctx.VARIABLE().getSymbol().getCharPositionInLine();
            throw new RuntimeException(pos + " - Variable \"" + ctx.VARIABLE().getText() + "\" is already defined");
        }
        table.addVariable(ctx.VARIABLE().getText(), null);
    }

    @Override
    public void exitAssignment(LambdaParser.AssignmentContext ctx) {
        table.addVariable(ctx.VARIABLE().getText(), stack.pop());
    }

    @Override
    public void exitQuery(LambdaParser.QueryContext ctx) {
        table.addQuery(stack.pop());
    }

    @Override
    public void exitLambdaVariable(LambdaParser.LambdaVariableContext ctx) {
        stack.push(new Variable(table, ctx.VAR().getText()));
    }

    @Override
    public void exitAssignmentVariable(LambdaParser.AssignmentVariableContext ctx) {

        if (!(table.isVariableInTable(ctx.VARIABLE().getText()))) {
            String pos = ctx.VARIABLE().getSymbol().getLine() + ":" + ctx.VARIABLE().getSymbol().getCharPositionInLine();
            throw new RuntimeException(pos + " - Variable \"" + ctx.VARIABLE().getText() + "\" is not defined");
        }
        stack.push(new AssignedVariable(table, ctx.VARIABLE().getText()));
    }

    @Override
    public void exitAbstraction(LambdaParser.AbstractionContext ctx) {
        List<String> parameters = ctx.VAR().stream().map(TerminalNode::getText).collect(Collectors.toList());
        for (int i = parameters.size() - 1; i >= 0; i--) {
            stack.push(new Abstraction(table, new Variable(table, parameters.get(i)), stack.pop()));
        }
    }

    @Override
    public void exitApplication(LambdaParser.ApplicationContext ctx) {
        Term right = stack.pop();
        Term left = stack.pop();
        stack.push(new Application(table, left, right));
    }
}
