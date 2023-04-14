lexer grammar ParsoTangueLexer;

@header {
package ru.itmo.test.parsoTangue;
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
LE: '<';
GE: '>';
EQ: '==';
NEQ: '!=';

IF: 'if';
ELSEIF: 'else if';
ELSE: 'else';

OPEN_PARENS: '(';
CLOSE_PARENS: ')';
OPEN_CURLY: '{';
CLOSE_CURLY: '}';

ASSIGNMENT: ':=';
SEMICOLON: ';';
COMMA: ',';

LET: 'let';
PRINT: 'print';
RETURN: 'return';

INTEGER: 'Integer';
BOOLEAN: 'Boolean';
STRING: 'String';
VOID: 'void';

fragment DIGIT:      [0-9];
NUMBER:     [1-9] DIGIT* | DIGIT;

fragment LETTER: [a-zA-Z];
fragment MARK: [!,?.)(];
NAME: ('_' | LETTER)+;
STR: '"' (LETTER | DIGIT | MARK)* '"';      // TODO: something except for question and exl marks

fragment NEW_LINE:    '\n';
fragment WHITE_SPACE: [ \t];
SPACE:   (WHITE_SPACE | NEW_LINE)+ -> skip;
