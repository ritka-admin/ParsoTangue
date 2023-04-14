package com.github.ritka_admin.parsotangue.nodes;

import com.github.ritka_admin.parsotangue.nodes.declaration.FuncDeclaration;

import java.util.List;

public class Program implements AstNode {
    public final List<FuncDeclaration> funcs;

    public Program(List<FuncDeclaration> funcs) {
        this.funcs = funcs;
    }
}
