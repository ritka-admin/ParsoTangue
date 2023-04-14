package com.github.ritka_admin.parsotangue.nodes.exprs;

public class StringLiteral implements Expr {
    public final String str;

    public StringLiteral(String str) {
        this.str = str;
    }
}
