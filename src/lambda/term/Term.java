package lambda.term;

public abstract class Term {
    public abstract Term substitution(Variable variable, Term term) throws SubstitutionException;
    public abstract Term abstractTerm();
}
