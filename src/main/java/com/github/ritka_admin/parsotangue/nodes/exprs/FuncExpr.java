package com.github.ritka_admin.parsotangue.nodes.exprs;

import java.util.List;

public class FuncExpr implements Expr {

    public final String name;
    public final List<Expr> exprs;

    public FuncExpr(String name, List<Expr> exprs) {
        this.name = name;
        this.exprs = exprs;
    }

}
