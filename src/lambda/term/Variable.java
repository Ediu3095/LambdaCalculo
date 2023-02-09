package lambda.term;

import lambda.logic.SymbolTable;

import java.util.Objects;

public class Variable extends Term {
    private final SymbolTable table;
    private final String name;

    public Variable(SymbolTable table, String name) {
        this.table = table;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Term substitution(Variable variable, Term term) throws SubstitutionException {
        if (this.equals(variable))
            return term;
        else
            return this;
    }

    @Override
    public Term abstractTerm() {
        String temp = table.getTerm(this);
        if (temp != null) {
            return new AssignedVariable(table, temp);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return name.equals(variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
