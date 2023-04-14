package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.BooleanExpr;

import java.util.List;

public class IfStmt implements Stmt {
    BooleanExpr expr;
    List<Stmt> stmts;

    // TODO: different constructors depending on else if and else
}
