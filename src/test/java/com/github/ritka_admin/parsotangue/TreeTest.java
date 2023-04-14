package com.github.ritka_admin.parsotangue;


import com.github.ritka_admin.parsotangue.nodes.declaration.FuncDeclaration;
import com.github.ritka_admin.parsotangue.nodes.exprs.ArithExpr;
import com.github.ritka_admin.parsotangue.nodes.exprs.BooleanExpr;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Identifier;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Name;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.ops.BinaryBooleanOp;
import com.github.ritka_admin.parsotangue.nodes.ops.BinaryNumericOp;
import com.github.ritka_admin.parsotangue.nodes.primitives.OurNumber;
import com.github.ritka_admin.parsotangue.nodes.primitives.OurString;
import com.github.ritka_admin.parsotangue.nodes.stmts.AssignStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.PrintStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.Stmt;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TreeTest {

    @Test
    void treeTest() {
        var a = new OurNumber(5);
        var b = new OurNumber(6);
        var boolExpr = new BooleanExpr(BinaryBooleanOp.EQ, a, b);
    }

    @Test
    void listingOneTest() {

    }

    @Test
    void listingTwoTest() {
        List<Identifier> args = new ArrayList<>();

        var nameFst = new Name("first");
        var nameSnd = new Name("second");
        var stmt1 = new AssignStmt(Type.STRING, nameFst, new OurString("Hello"));
        var stmt2 = new AssignStmt(Type.STRING, nameSnd, new OurString("World"));
        var stmt3 = new PrintStmt(new ArithExpr(BinaryNumericOp.MINUS, nameFst, nameSnd));
        List<Stmt> stmts = new ArrayList<>();
        stmts.add(stmt1);
        stmts.add(stmt2);
        stmts.add(stmt3);

        var func = new FuncDeclaration(Type.VOID, new Name("main"), args, stmts);

        //    let void main()
        //    {
        //        String first := "Hello";
        //        String second := "World";
        //        print(first + second);
        //    }
    }

}