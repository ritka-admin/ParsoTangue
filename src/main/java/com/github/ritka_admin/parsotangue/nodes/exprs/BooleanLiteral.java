package com.github.ritka_admin.parsotangue.nodes.exprs;

public class BooleanLiteral implements Expr {
    public final boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }
}
