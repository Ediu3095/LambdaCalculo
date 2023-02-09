// Generated from java-escape by ANTLR 4.11.1
package lambda.interpreter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LambdaParser}.
 */
public interface LambdaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LambdaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LambdaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LambdaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LambdaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LambdaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LambdaParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(LambdaParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LambdaParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(LambdaParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLambdaVariable(LambdaParser.LambdaVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLambdaVariable(LambdaParser.LambdaVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentVariable(LambdaParser.AssignmentVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentVariable(LambdaParser.AssignmentVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(LambdaParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(LambdaParser.ParenthesisContext ctx);
}