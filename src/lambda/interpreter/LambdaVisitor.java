// Generated from E:/Users/Eduardo Ruiz/IdeaProjects/Lambda/grammar\Lambda.g4 by ANTLR 4.10.1
package lambda.interpreter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LambdaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LambdaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LambdaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LambdaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LambdaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LambdaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LambdaParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(LambdaParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaVariable(LambdaParser.LambdaVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code application}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(LambdaParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code abstraction}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstraction(LambdaParser.AbstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentVariable}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentVariable(LambdaParser.AssignmentVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link LambdaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(LambdaParser.ParenthesisContext ctx);
}