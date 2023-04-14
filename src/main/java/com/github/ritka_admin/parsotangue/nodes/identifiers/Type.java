package com.github.ritka_admin.parsotangue.nodes.identifiers;

public enum Type {
    INTEGER("Integer"), BOOLEAN("Boolean"),
    STRING("String"), VOID("void");

    private final String type;

    private Type(String type) {
        this.type = type;
    }
}
