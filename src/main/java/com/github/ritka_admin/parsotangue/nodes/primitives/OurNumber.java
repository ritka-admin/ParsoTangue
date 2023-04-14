package com.github.ritka_admin.parsotangue.nodes.primitives;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class OurNumber implements Expr {
    int value;

    public OurNumber(int value) {
        this.value = value;
    }
}
