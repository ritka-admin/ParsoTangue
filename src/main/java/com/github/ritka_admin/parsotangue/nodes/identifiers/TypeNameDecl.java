package com.github.ritka_admin.parsotangue.nodes.identifiers;

public class TypeNameDecl extends Identifier {
    String name;
    Type type;

    public TypeNameDecl(Type type, String name) {
        this.name = name;
        this.type = type;
    }
}
