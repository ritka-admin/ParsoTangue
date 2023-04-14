package com.github.ritka_admin.parsotangue.nodes.stmts;

import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;

public class AssignStmt implements Stmt {
    Type type;
    Identifier name;
    Expr value;

    public AssignStmt(Type type, Identifier name, Expr value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }
}
