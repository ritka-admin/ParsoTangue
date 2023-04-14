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
    : LET type identifier iniFuncParens body
    ;

stmt
    : ifStmt
    | printStmt SEMICOLON
    | assignStmt SEMICOLON
    | returnStmt SEMICOLON
    ;

// TODO: declaration?

expr
    : booleanExpr
    | arithExpr
    | funcExpr
    | primitives
    | NAME
    ;

ifStmt
    : IF ifParens body (ELSEIF ifParens body)* (ELSE body)?  // TODO: ifParens and other parens?
    ;

printStmt
    : PRINT callFuncParens
    ;

assignStmt
    : type identifier ASSIGNMENT expr  // TODO: change identifier
    ;

returnStmt
    : RETURN expr
    ;

booleanExpr
    : (arithExpr | funcExpr | primitives | NAME) (LEQ | GEQ | LE | GE | EQ | NEQ) expr
    ;

arithExpr
    : (NUMBER | NAME | STR) PLUS (NUMBER | NAME | STR | arithExpr)      // TODO: str in arith exp?
    | (NUMBER | NAME) MULT (NUMBER | NAME)
    ;

funcExpr
    : NAME callFuncParens
    ;

body
    : OPEN_CURLY stmt* CLOSE_CURLY
    ;

identifier
    : NAME
    ;

type
    : (INTEGER | BOOLEAN | STRING | VOID)
    ;

primitives
    : (NUMBER | STR | TRUE | FALSE)
    ;

callFuncParens
    : OPEN_PARENS (expr COMMA?)* CLOSE_PARENS  // TODO: delete comma only after the last argument
    ;

iniFuncParens
    : OPEN_PARENS (type identifier COMMA?)* CLOSE_PARENS     // TODO: delete comma only after the last argument
    ;

ifParens
    : OPEN_PARENS (booleanExpr | NAME callFuncParens) CLOSE_PARENS
    ;

