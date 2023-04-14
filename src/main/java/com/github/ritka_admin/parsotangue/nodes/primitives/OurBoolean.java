package com.github.ritka_admin.parsotangue.nodes.primitives;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class OurBoolean implements Expr {
    boolean value;

    public OurBoolean(boolean value) {
        this.value = value;
    }
}
