package lambda.term;

import lambda.logic.SymbolTable;

import java.util.Objects;

public class Application extends Term {
    private final SymbolTable table;
    private final Term left;
    private final Term right;

    public Application(SymbolTable table, Term left, Term right) {
        this.table = table;
        this.left = left;
        this.right = right;
    }

    public Term getLeft() {
        return left;
    }

    public Term getRight() {
        return right;
    }

    @Override
    public Term substitution(Variable variable, Term term) throws SubstitutionException {
        return new Application(table, left.substitution(variable, term), right.substitution(variable, term));
    }

    public Term betaReduction() throws SubstitutionException, ConversionException {
        try {
            if (left instanceof Abstraction)
                return ((Abstraction)left).betaReduction(right);
            else if (left instanceof Application)
                return new Application(table, ((Application) left).betaReduction(), right);
            else
                throw new ConversionException("Cannot β-reduce " + this);
        } catch (ConversionException e) {
            if (right instanceof Abstraction)
                return new Application(table, left, ((Abstraction)right).betaReduction());
            else if (right instanceof Application)
                return new Application(table, left, ((Application)right).betaReduction());
            else
                throw new ConversionException("Cannot β-reduce " + this);
        }
    }

//    public Term etaReduction() throws ConversionException {
//        try {
//            if (left instanceof Abstraction)
//                return new Application(table, ((Abstraction) left).etaReduction(), right);
//            else if (left instanceof Application)
//                return new Application(table, ((Application) left).etaReduction(), right);
//            else
//                throw new ConversionException("Cannot η-convert " + this);
//        } catch (ConversionException e) {
//            if (right instanceof Abstraction)
//                return new Application(table, left, ((Abstraction)right).etaReduction());
//            else if (right instanceof Application)
//                return new Application(table, left, ((Application)right).etaReduction());
//            else
//                throw new ConversionException("Cannot η-convert " + this);
//        }
//    }

    public Term variableSubstitution() throws SubstitutionException {
        try {
            if (left instanceof AssignedVariable)
                return new Application(table, ((AssignedVariable)left).getValue(), right);
            else if (left instanceof Application)
                return new Application(table, ((Application) left).variableSubstitution(), right);
            else if (left instanceof Abstraction)
                return new Application(table, ((Abstraction) left).variableSubstitution(), right);
            else
                throw new SubstitutionException("Cannot substitute in " + left);
        } catch (SubstitutionException e) {
            if (right instanceof AssignedVariable)
                return new Application(table, left, ((AssignedVariable)right).getValue());
            else if (right instanceof Application)
                return new Application(table, left, ((Application)right).variableSubstitution());
            else if (right instanceof Abstraction)
                return new Application(table, left, ((Abstraction)right).variableSubstitution());
            else
                throw new SubstitutionException("Cannot substitute variables in " + this);
        }
    }

    @Override
    public Term abstractTerm() {
        String temp = table.getTerm(this);
        if (temp != null) {
            return new AssignedVariable(table, temp);
        } else {
            return new Application(table, left.abstractTerm(), right.abstractTerm());
        }
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return left.equals(that.left) && right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
