package com.github.ritka_admin.parsotangue;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        var s = CharStreams.fromString("let main(){}");
        var lex = new ru.itmo.test.parsoTangue.ParsoTangueLexer(s);
        var tokens = new CommonTokenStream(lex);
        var parser = new ru.itmo.test.parsoTangue.ParsoTangueParser(tokens);
        var treeRoot = parser.program();
        System.out.println("Hello world!");
    }
}
