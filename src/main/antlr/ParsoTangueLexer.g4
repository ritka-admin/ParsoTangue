lexer grammar ParsoTangueLexer;

@header {
    package com.github.ritka_admin.parsotangue.antlr;
}

PLUS:  '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';

TRUE: 'true';
FALSE: 'false';

LEQ: '<=';
GEQ: '>=';
LT: '<';
GE: '>';
EQ: '==';
NEQ: '!=';

IF: 'if';
ELSEIF: 'else if';
ELSE: 'else';

OPEN_PARENS: '(';
CLOSE_PARENS: ')';
OPEN_BRACE: '{';
CLOSE_BRACE: '}';

ASSIGNMENT: ':=';
SEMICOLON: ';';
COMMA: ',';

LET: 'let';
RETURN: 'return';

INTEGER: 'Integer';
BOOLEAN: 'Boolean';
STRING: 'String';
VOID: 'void';

fragment DIGIT:      [0-9];
NUMBER:     [1-9] DIGIT* | DIGIT;

fragment LETTER: [a-zA-Z];
fragment INPUT_CHARACTER: ~[\r\n\u0085\u2028\u2029];
NAME: ('_' | LETTER)+;
STR: '"' INPUT_CHARACTER* '"';

fragment NEW_LINE:    '\n';
fragment WHITE_SPACE: [ \t];
SPACE:   (WHITE_SPACE | NEW_LINE)+ -> skip;
