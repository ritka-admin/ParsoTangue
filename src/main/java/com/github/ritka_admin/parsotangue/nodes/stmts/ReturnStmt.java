package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class ReturnStmt implements Stmt {
    public final Expr expr;

    public ReturnStmt(Expr expr) {
        this.expr = expr;
    }
}
