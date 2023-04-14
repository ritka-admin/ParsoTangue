package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.FuncExpr;

public class FuncExprStmt implements Stmt {
    public final FuncExpr expr;

    public FuncExprStmt(FuncExpr expr) {
        this.expr = expr;
    }
}
