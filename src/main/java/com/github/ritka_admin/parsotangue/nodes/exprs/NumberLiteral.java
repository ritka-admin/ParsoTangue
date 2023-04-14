package com.github.ritka_admin.parsotangue.nodes.exprs;

public class NumberLiteral implements Expr {
    public final int value;

    public NumberLiteral(int value) {
        this.value = value;
    }
}
