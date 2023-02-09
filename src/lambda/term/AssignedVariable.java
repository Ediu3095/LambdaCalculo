package lambda.term;

import lambda.logic.SymbolTable;

import java.util.Objects;

public class AssignedVariable extends Term {
    private final SymbolTable table;
    private final String name;

    public AssignedVariable(SymbolTable table, String name) {
        this.table = table;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Term substitution(Variable variable, Term term) {
        return this;
    }

    public Term getValue() {
        return table.getVariable(name);
    }

    @Override
    public Term abstractTerm() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignedVariable that = (AssignedVariable) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
