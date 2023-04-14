package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class PrintStmt implements Stmt {
    Expr expr;

    public PrintStmt(Expr expr) {
        this.expr = expr;
    }

}
