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
    : LET identifier iniFuncParens body
    ;

stmt
    : ifStmt
    | printStmt SEMICOLON
    | assignStmt SEMICOLON
    | returnStmt SEMICOLON
    ;

expr
    : booleanExpr
    | arithExpr
    | funcExpr
    | primitives
    | NAME
    ;

ifStmt
    : IF ifParens body (ELSEIF ifParens body)* (ELSE body)?
    ;

printStmt
    : PRINT callFuncParens
    ;

assignStmt
    : identifier ASSIGNMENT (expr | NAME | primitives)
    ;

returnStmt
    : RETURN (expr | NAME | primitives);

booleanExpr
    : (arithExpr | funcExpr | primitives | NAME) (LEQ | GEQ | LE | GE | EQ | NEQ) expr
    ;

arithExpr
    : (NUMBER | NAME | STR) PLUS (NUMBER | NAME | STR)      // TODO: str in arith exp?
    | (NUMBER | NAME) MULT (NUMBER | NAME)
    ;

funcExpr
    : NAME callFuncParens
    ;

body
    : OPEN_CURLY stmt* CLOSE_CURLY
    ;

identifier
    : type? NAME
    ;

type
    : (INTEGER | BOOLEAN | STRING | VOID)
    ;

primitives
    : (NUMBER | STR | TRUE | FALSE)
    ;

callFuncParens
    : OPEN_PARENS ((expr | NAME | primitives) COMMA?)* CLOSE_PARENS  // TODO: delete comma only after the last argument
    ;

iniFuncParens
    : OPEN_PARENS (identifier COMMA?)* CLOSE_PARENS     // TODO: delete comma only after the last argument
    ;

ifParens
    : OPEN_PARENS (booleanExpr | NAME callFuncParens) CLOSE_PARENS
    ;

