package lambda.logic;

import lambda.term.*;

import java.util.*;

public class SymbolTable {
    Map<String, Term> table = new HashMap<>();
    Queue<Term> queries = new ArrayDeque<>();

    public void addVariable(String name, Term term) {
        table.put(name, term);
    }

    public boolean isVariableInTable(String name) {
        return table.containsKey(name);
    }

    public Term getVariable(String name) {
        return table.get(name);
    }

    public String getTerm(Term term) {
        for (String key : table.keySet()) {
            Term temp = table.get(key);
            if (term.equals(temp))
                return key;
        }
        return null;
    }

    public void addQuery(Term term) {
        queries.add(term);
    }

    public Term getQuery() {
        if (queries.isEmpty())
            return null;
        else
            return queries.remove();
    }

    @Override
    public String toString() {
        StringBuilder sol = new StringBuilder("SymbolTable {\n");
        sol.append("\tVariables:\n");
        for (String key : table.keySet()) {
            sol.append("\t\t").append(key).append(" ≡ ").append(table.get(key)).append("\n");
        }
        sol.append("\tQueries:\n");
        for (Term term : queries) {
            sol.append("\t\t").append(term).append("\n");
        }
        sol.append("}");
        return sol.toString();
    }
}
