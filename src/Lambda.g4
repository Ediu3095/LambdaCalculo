grammar Lambda;

prog
: EOL* ((assignment|query) EOL+)* (assignment|query)? EOF
;

assignment
: VARIABLE EQUIVALENCE term
;

query
: term
;

term
: VAR                  #lambdaVariable
| VARIABLE             #assignmentVariable
| LAMBDA VAR+ '.' term #abstraction
| term term            #application
| '(' term ')'         #parenthesis
;

LAMBDA
: 'λ'
| 'lambda'
;

EQUIVALENCE
: '≡'
| ':'
;

VAR
: [a-z]
;

VARIABLE
: [A-Z0-9][a-zA-Z0-9]*
;

EOL
: [\n\r]+
;

COMMENT
: ';' (~[\n\r])* -> skip
;

WHITESPACE
: [ \t] -> skip
;
