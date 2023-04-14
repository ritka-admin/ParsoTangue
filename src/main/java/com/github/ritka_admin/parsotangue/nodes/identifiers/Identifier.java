package com.github.ritka_admin.parsotangue.nodes.identifiers;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class Identifier implements Expr {

    public final String name;

    public Identifier(String name) {
        this.name = name;
    }
}
