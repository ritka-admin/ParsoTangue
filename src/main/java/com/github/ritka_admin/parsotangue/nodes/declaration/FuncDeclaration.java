package com.github.ritka_admin.parsotangue.nodes.declaration;

import com.github.ritka_admin.parsotangue.nodes.AstNode;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.stmts.Stmt;

import java.util.List;

public class FuncDeclaration implements AstNode {
    public final Type returnType;
    public final String name;
    public final List<ParameterDeclaration> args;
    public final List<Stmt> stmts;

    public FuncDeclaration(Type returnType, String name, List<ParameterDeclaration> args, List<Stmt> stmts) {
        this.returnType = returnType;
        this.name = name;
        this.args = args;
        this.stmts = stmts;
    }
}
