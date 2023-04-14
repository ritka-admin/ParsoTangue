package com.github.ritka_admin.parsotangue.nodes.exprs;

import com.github.ritka_admin.parsotangue.nodes.ops.BinaryBooleanOp;

public class BooleanExpr implements Expr {
    BinaryBooleanOp operation;
    Expr left;      // TODO: expr?
    Expr right;

    public BooleanExpr(BinaryBooleanOp operation, Expr left, Expr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
}
