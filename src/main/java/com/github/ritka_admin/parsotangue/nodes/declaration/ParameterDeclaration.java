package com.github.ritka_admin.parsotangue.nodes.declaration;

import com.github.ritka_admin.parsotangue.nodes.AstNode;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;

public class ParameterDeclaration implements AstNode {

    public final String name;
    public final Type type;

    public ParameterDeclaration(Type type, String name) {
        this.name = name;
        this.type = type;
    }
}
