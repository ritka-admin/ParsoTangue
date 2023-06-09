package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;

public class AssignStmt implements Stmt {
    public final String name;
    public final Expr value;

    public AssignStmt(String name, Expr value) {
        this.name = name;
        this.value = value;
    }
}
