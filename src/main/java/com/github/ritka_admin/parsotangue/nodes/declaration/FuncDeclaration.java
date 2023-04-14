package com.github.ritka_admin.parsotangue.nodes.declaration;

import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.stmts.Stmt;

import java.util.List;

public class FuncDeclaration extends Declaration {
    Type returnType;
    Identifier name;
    List<Identifier> args;
    List<Stmt> stmts;

    public FuncDeclaration(Type returnType, Identifier name, List<Identifier> args, List<Stmt> stmts) {
        this.returnType = returnType;
        this.name = name;
        this.args = args;
        this.stmts = stmts;
    }
}
