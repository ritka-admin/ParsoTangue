package com.github.ritka_admin.parsotangue.nodes.primitives;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class OurString implements Expr {
    String str;

    public OurString(String str) {
        this.str = str;
    }
}
