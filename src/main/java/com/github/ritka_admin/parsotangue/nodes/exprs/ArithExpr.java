package com.github.ritka_admin.parsotangue.nodes.exprs;

public class ArithExpr implements Expr {
    public final BinaryNumericOp operation;
    public final Expr left;
    public final Expr right;

    public ArithExpr(BinaryNumericOp operation, Expr left, Expr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
}
