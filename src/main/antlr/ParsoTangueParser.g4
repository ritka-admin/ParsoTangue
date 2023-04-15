parser grammar ParsoTangueParser;

@header {
    package com.github.ritka_admin.parsotangue;
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

iniFuncParens
    : OPEN_PARENS ((type identifier)? | type identifier (COMMA type identifier)+) CLOSE_PARENS
    ;

stmt
    : ifStmt
    | initializerStmt SEMICOLON
    | assignmentStmt SEMICOLON
    | returnStmt SEMICOLON
    | expr SEMICOLON
    ;

expr
    : expr (LEQ | GEQ | LT | GE | EQ | NEQ) expr
    | <assoc=left> expr (DIV | MULT | MOD) expr
    | <assoc=left> expr (PLUS | MINUS) expr
    | funcExpr
    | atom
    ;

ifStmt
    : IF ifParens body (ELSEIF ifParens body)* (ELSE body)?
    ;

ifParens
    : OPEN_PARENS expr CLOSE_PARENS
    ;

initializerStmt
    : type identifier ASSIGNMENT expr
    ;

assignmentStmt
    : identifier ASSIGNMENT expr
    ;

returnStmt
    : RETURN expr
    ;

funcExpr
    : NAME callFuncParens
    ;

callFuncParens
    : OPEN_PARENS ((expr)? | expr (COMMA expr)+) CLOSE_PARENS
    ;

atom
    : primitives
    | identifier
    | OPEN_PARENS expr CLOSE_PARENS
    ;

body
    : OPEN_BRACE stmt* CLOSE_BRACE
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


