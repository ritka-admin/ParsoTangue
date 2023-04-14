package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.BooleanExpr;

import java.util.Collections;
import java.util.List;

public class IfStmt implements Stmt {
    public final BooleanExpr cond;
    public final List<Stmt> thenBranch;
    public final List<Stmt> elseBranch;

    public IfStmt(BooleanExpr cond, List<Stmt> thenBranch, List<Stmt> elseBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public IfStmt(BooleanExpr cond, List<Stmt> thenBranch) {
        this(cond, thenBranch, Collections.emptyList());
    }
}
