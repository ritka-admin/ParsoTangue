package com.github.ritka_admin.parsotangue.nodes.identifiers;

import java.util.Arrays;
import java.util.Objects;

public enum Type {
    INTEGER("Integer"), BOOLEAN("Boolean"),
    STRING("String"), VOID("void");

    public final String type;

    Type(String type) {
        this.type = type;
    }

    public static Type fromIndex(int index) {
        return Type.values()[index];
    }
}
