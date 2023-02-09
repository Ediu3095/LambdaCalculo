package lambda.logic;

import lambda.term.*;

import java.util.*;

public class Executor {
    private Term term;
    private Boolean norm = false;
    private Boolean abst = false;

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
        this.norm = false;
        this.abst = false;
    }

    public Boolean isNorm() {
        return norm;
    }

    public Boolean isAbst() {
        return abst;
    }

    public void nextStep() {
        try {
            if (term instanceof Application) {
                try {
                    term = ((Application) term).betaReduction();
                } catch (SubstitutionException | ConversionException e) {
//                    try {
//                        term = ((Application) term).etaReduction();
//                    } catch (ConversionException e1) {
                        term = ((Application) term).variableSubstitution();
//                    }
                }
            } else if (term instanceof Abstraction) {
                try {
                    term = ((Abstraction) term).betaReduction();
                } catch (SubstitutionException | ConversionException e) {
//                    try {
//                        term = ((Abstraction) term).etaReduction();
//                    } catch (ConversionException e1) {
                        term = ((Abstraction) term).variableSubstitution();
//                    }
                }
//            } else if (term instanceof AssignedVariable) {
//                term = ((AssignedVariable) term).getValue();
            } else {
                norm = true;
            }
        } catch (SubstitutionException e) {
//            System.err.println(e.getMessage());
            norm = true;
        }
    }

    public List<Term> normalize() {
        List<Term> steps = new ArrayList<>();
        while (!norm && steps.stream().noneMatch(t -> t.equals(term))) {
            steps.add(term);
            nextStep();
        }
        while (!abst) {
            steps.add(term);
            abstractStep();
        }
        return steps;
    }

    public void abstractStep() {
        Term temp = term.abstractTerm();
        if (temp.equals(term))
            abst = true;
        term = temp;
    }
}
