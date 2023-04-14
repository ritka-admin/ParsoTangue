package com.github.ritka_admin.parsotangue.nodes.ops;

public enum BinaryBooleanOp {
    LEQ("<="), GEQ(">="),
    LE("<"), GE(">"),
    EQ("=="), NEQ("!=");

    private final String op;

    private BinaryBooleanOp(String op) {
        this.op = op;
    }

    public String getOperator() {
        return op;
    }
}
