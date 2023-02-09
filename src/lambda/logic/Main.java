package lambda.logic;

import lambda.interpreter.LambdaBasicListener;
import lambda.interpreter.LambdaLexer;
import lambda.interpreter.LambdaParser;
import lambda.term.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1 || 2 < args.length || (args.length == 2 && !args[0].equals("--verbose"))) {
            System.err.println("Uso: java -jar LC-XX.jar [--verbose] <fichero.lc>");
            System.err.println("Para mas informacion utilizar: java -jar LC-XX.jar --help");
            System.exit(1);
        }

        if (args.length == 1 && args[0].equals("--help")) {
            System.out.println("Uso: java -jar LC-XX.jar <fichero.lc>");
            System.out.println("\t<fichero.lc> es la ruta del archivo que contiene el programa a procesar");
            System.exit(0);
        }

        String fichero = args.length == 1 ? args[0] : args[1];
        LambdaLexer lexer = new LambdaLexer(CharStreams.fromFileName(fichero, StandardCharsets.UTF_8));
        LambdaParser parser = new LambdaParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.prog();
        LambdaBasicListener listener = new LambdaBasicListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);

        SymbolTable table = listener.getResult();

        Term t;
        Executor e = new Executor();
        while ((t = table.getQuery()) != null) {
            e.setTerm(t);
            System.out.println("Processing query: " + e.getTerm());
            List<Term> steps = e.normalize();
            if (args.length == 2) {
                int step = 0;
                for (Term term : steps) {
                    System.out.println(step + ": " + term);
                    step++;
                }
            }
            System.out.println("Query result: " + e.getTerm());

            System.out.println("---");
        }
    }
}
