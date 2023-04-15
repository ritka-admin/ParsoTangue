package com.github.ritka_admin.parsotangue;


import com.github.ritka_admin.parsotangue.nodes.declaration.FuncDeclaration;
import com.github.ritka_admin.parsotangue.nodes.declaration.ParameterDeclaration;
import com.github.ritka_admin.parsotangue.nodes.exprs.*;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.stmts.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeTest {

    @Test
    void listingOneTest() {
        var stmt1 = new InitializerStmt(Type.INTEGER, "a", new NumberLiteral(42));
        var stmt2 = new InitializerStmt(Type.INTEGER, "b", new NumberLiteral(42));
        var stmt3 = new InitializerStmt(Type.INTEGER, "result",
                new ArithExpr(BinaryNumericOp.PLUS,
                        new FuncExpr("bad_pow", List.of(new Identifier("a"), new NumberLiteral(3))),
                        new FuncExpr("bad_pow", List.of(new Identifier("b"), new NumberLiteral(3)))));
        var stmt4 = new FuncExprStmt(new FuncExpr("print", List.of(new Identifier("result"))));
        var main = new FuncDeclaration(Type.VOID, "main", Collections.emptyList(),
                List.of(stmt1, stmt2, stmt3, stmt4));

        var badPowArgs = List.of(new ParameterDeclaration(Type.INTEGER, "x"),
                new ParameterDeclaration(Type.INTEGER, "p"));
        var stmt5 = new InitializerStmt(Type.INTEGER, "result", new NumberLiteral(1));
        var stmt6 = new InitializerStmt(Type.INTEGER, "i", new NumberLiteral(1));
        var stmt7 = new AssignStmt("result",
                new ArithExpr(BinaryNumericOp.MULT, new Identifier("result"), new Identifier("x")));
        var stmt8 = new IfStmt(new BooleanExpr(BinaryBooleanOp.LEQ, new Identifier("i"), new Identifier("p")),
                List.of(stmt7));
        var stmt9 = new ReturnStmt(new Identifier("result"));
        var badPow = new FuncDeclaration(Type.INTEGER, "bad_pow", badPowArgs,
                List.of(stmt5, stmt6, stmt8, stmt9));
//        let void main() {
//            Integer a := 42;
//            Integer b := 42;
//            Integer result := bad_pow(a, 3) + bad_pow(b, 3);
//            print(result);
//        }
//        let Integer bad_pow(Integer x, Integer p) {
//            Integer result := 1; Integer i := 1;
//            if (i <= p) {
//                result := result * x;
//            }
//            return result;
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

        var func = new FuncDeclaration(Type.VOID, "main", args, stmts);

        //    let void main()
        //    {
        //        String first := "Hello";
        //        String second := "World";
        //        print(first + second);
        //    }
    }

}