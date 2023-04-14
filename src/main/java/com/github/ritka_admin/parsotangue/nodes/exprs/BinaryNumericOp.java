package com.github.ritka_admin.parsotangue.nodes.exprs;


public enum BinaryNumericOp {
    PLUS("+"), MINUS("-"),
    MULT("*"), DIV("/"),
    MOD("%");

    private final String op;

    BinaryNumericOp(String op) {
        this.op = op;
    }
}

