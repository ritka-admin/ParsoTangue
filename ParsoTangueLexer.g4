lexer grammar ParsoTangueLexer;

@header {
package ru.itmo.test.parsoTangue;
}

PLUS:  '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
// TODO: priorities?

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

LET: 'let';

// TODO: types, names

NEW_LINE: '\n';
TAB: '\t';

WHITESPACE : ' ' -> skip;       // TODO: identation, new line rules

fragment DIGIT:      [0-9];
NUMBER:     [1-9] DIGIT* | DIGIT;