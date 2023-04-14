package com.github.ritka_admin.parsotangue.nodes.exprs;

public class BooleanExpr implements Expr {
    public final BinaryBooleanOp operation;
    public final Expr left;
    public final Expr right;

    public BooleanExpr(BinaryBooleanOp operation, Expr left, Expr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
}
