package com.github.ritka_admin.parsotangue.nodes.identifiers;

public enum Type {
    INTEGER("Integer"), BOOLEAN("Boolean"),
    STRING("String"), VOID("void");

    public final String type;

    Type(String type) {
        this.type = type;
    }
}
