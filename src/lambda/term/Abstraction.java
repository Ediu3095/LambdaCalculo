package lambda.term;

import lambda.logic.SymbolTable;

import java.util.Objects;

public class Abstraction extends Term {
    private final SymbolTable table;
    private final Variable parameter;
    private final Term body;

    public Abstraction(SymbolTable table, Variable parameter, Term body) {
        this.table = table;
        this.parameter = parameter;
        this.body = body;
    }

    public Variable getParameter() {
        return parameter;
    }

    public Term getBody() {
        return body;
    }

    @Override
    public Term substitution(Variable variable, Term term) throws SubstitutionException {
        if (parameter.equals(variable))
            return this;
        else
            return new Abstraction(table, parameter, body.substitution(variable, term));
    }

    public Term betaReduction(Term term) throws SubstitutionException {
        return body.substitution(parameter, term);
    }

    public Term betaReduction() throws SubstitutionException, ConversionException {
        if (body instanceof Abstraction)
            return new Abstraction(table, parameter, ((Abstraction)body).betaReduction());
        else if (body instanceof Application)
            return new Abstraction(table, parameter, ((Application)body).betaReduction());
        else
            throw new SubstitutionException("Cannot β-reduce " + this);
    }

//    public Term etaReduction() throws ConversionException {
//        if (body instanceof Application && parameter.equals(((Application)body).getRight()))
//            return ((Application)body).getLeft();
//        else if (body instanceof Abstraction)
//            return new Abstraction(table, parameter, ((Abstraction)body).etaReduction());
//        else if (body instanceof Application)
//            return new Abstraction(table, parameter, ((Application)body).etaReduction());
//        else
//            throw new ConversionException("Cannot η-convert " + this);
//    }

    public Term variableSubstitution() throws SubstitutionException {
        if (body instanceof AssignedVariable)
            return new Abstraction(table, parameter, ((AssignedVariable)body).getValue());
        else if (body instanceof Application)
            return new Abstraction(table, parameter, ((Application)body).variableSubstitution());
        else if (body instanceof Abstraction)
            return new Abstraction(table, parameter, ((Abstraction)body).variableSubstitution());
        else
            throw new SubstitutionException("Cannot substitute variables in: " + this);
    }

    @Override
    public Term abstractTerm() {
        String temp = table.getTerm(this);
        if (temp != null) {
            return new AssignedVariable(table, temp);
        } else {
            return new Abstraction(table, parameter, body.abstractTerm());
        }
    }

    @Override
    public String toString() {
        StringBuilder sol = new StringBuilder("(λ" + parameter);
        Term aux = body;
        while (aux instanceof Abstraction abs) {
            sol.append(abs.parameter.toString());
            aux = abs.body;
        }
        sol.append(".").append(aux.toString()).append(")");
        return sol.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abstraction that = (Abstraction) o;
        return parameter.equals(that.parameter) && body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter, body);
    }
}
