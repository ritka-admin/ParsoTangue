parser grammar ParsoTangueParser;

@header {
package ru.itmo.test.parsoTangue;
}

options {
  tokenVocab=ParsoTangueLexer;
}

program
    : func* EOF
    ;

func
    : let emptyParens body
    ;

stmt
    : ifStmt
    ;

ifStmt
    : IF OPEN_PARENS booleanStmt CLOSE_PARENS body   // TODO: or function that returns boolean
    | ELSEIF booleanStmt
    | ELSE
    ;

booleanStmt
    : number comp number
    ;

arith
    : number
    | number MINUS number
    ;

comp
    : LEQ
    | GEQ
    | LE
    | GE
    | EQ
    | NEQ
    ;

body
    : OPEN_CURLY NEW_LINE (stmt NEW_LINE)* CLOSE_CURLY
    ;

let
    : LET
    ;

emptyParens
    : OPEN_PARENS CLOSE_PARENS
    ;

number
    : NUMBER
    ;