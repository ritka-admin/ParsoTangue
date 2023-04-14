package com.github.ritka_admin.parsotangue.nodes.exprs;

import com.github.ritka_admin.parsotangue.nodes.ops.BinaryNumericOp;

public class ArithExpr implements Expr {
    BinaryNumericOp operation;
    Expr left;
    Expr right;

    public ArithExpr(BinaryNumericOp operation, Expr left, Expr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
}
