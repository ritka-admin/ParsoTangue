package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;

public class InitializerStmt implements Stmt {
    public final Type type;
    public final String name;
    public final Expr value;

    public InitializerStmt(Type type, String name, Expr value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }
}
