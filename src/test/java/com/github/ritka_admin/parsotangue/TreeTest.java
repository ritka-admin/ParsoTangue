package com.github.ritka_admin.parsotangue;


import com.github.ritka_admin.parsotangue.nodes.declaration.FuncDeclaration;
import com.github.ritka_admin.parsotangue.nodes.declaration.ParameterDeclaration;
import com.github.ritka_admin.parsotangue.nodes.exprs.*;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.stmts.FuncExprStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.InitializerStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.Stmt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TreeTest {

    @Test
    void treeTest() {
        var a = new NumberLiteral(5);
        var b = new NumberLiteral(6);
        var boolExpr = new BooleanExpr(BinaryBooleanOp.EQ, a, b);
    }

    @Test
    void listingOneTest() {

    }

    @Test
    void listingTwoTest() {
        List<ParameterDeclaration> args = new ArrayList<>();

        var nameFst = "first";
        var nameSnd = "second";
        var stmt1 = new InitializerStmt(Type.STRING, nameFst, new StringLiteral("Hello"));
        var stmt2 = new InitializerStmt(Type.STRING, nameSnd, new StringLiteral("World"));
        var stmt3 = new FuncExprStmt(new FuncExpr("print", List.of(
                new ArithExpr(BinaryNumericOp.PLUS, new StringLiteral(nameFst), new StringLiteral(nameSnd))
        )));
        List<Stmt> stmts = new ArrayList<>();
        stmts.add(stmt1);
        stmts.add(stmt2);
        stmts.add(stmt3);

        var func = new FuncDeclaration(Type.VOID, new Identifier("main"), args, stmts);

        //    let void main()
        //    {
        //        String first := "Hello";
        //        String second := "World";
        //        print(first + second);
        //    }
    }

}