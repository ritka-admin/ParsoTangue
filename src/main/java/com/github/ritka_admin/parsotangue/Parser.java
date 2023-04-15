package com.github.ritka_admin.parsotangue;

import com.github.ritka_admin.parsotangue.antlr.ParsoTangueParser;
import com.github.ritka_admin.parsotangue.nodes.Program;
import com.github.ritka_admin.parsotangue.nodes.declaration.FuncDeclaration;
import com.github.ritka_admin.parsotangue.nodes.declaration.ParameterDeclaration;
import com.github.ritka_admin.parsotangue.nodes.exprs.Expr;
import com.github.ritka_admin.parsotangue.nodes.exprs.FuncExpr;
import com.github.ritka_admin.parsotangue.nodes.identifiers.Type;
import com.github.ritka_admin.parsotangue.nodes.stmts.AssignStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.FuncExprStmt;
import com.github.ritka_admin.parsotangue.nodes.stmts.Stmt;
import com.google.common.collect.Streams;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.stream.Collectors;

public class Parser {
    public static Program parse(String str) {
        var s = CharStreams.fromString(str);
        var lex = new com.github.ritka_admin.parsotangue.antlr.ParsoTangueLexer(s);
        var tokens = new CommonTokenStream(lex);
        var parser = new com.github.ritka_admin.parsotangue.antlr.ParsoTangueParser(tokens);
        var treeRoot = parser.program();
        return new ProgramVisitor().visitProgram(treeRoot);
    }
}

class ProgramVisitor extends com.github.ritka_admin.parsotangue.antlr.ParsoTangueParserBaseVisitor<Program> {
    private final DeclVisitor visitor = new DeclVisitor();

    @Override
    public Program visitProgram(com.github.ritka_admin.parsotangue.antlr.ParsoTangueParser.ProgramContext ctx) {
        var funcs = ctx.func();
        var transformed = funcs.stream().map(visitor::visitFunc).collect(Collectors.toList());
        return new Program(transformed);
    }
}

class DeclVisitor extends com.github.ritka_admin.parsotangue.antlr.ParsoTangueParserBaseVisitor<FuncDeclaration> {
    private final StmtVisitor visitor = new StmtVisitor();

    @Override
    public FuncDeclaration visitFunc(ParsoTangueParser.FuncContext ctx) {
        var type = ctx.type();
        var identifier = ctx.identifier();
        var body = ctx.body();
        var argsTypes = ctx.iniFuncParens().type();
        var argIdentifier = ctx.iniFuncParens().identifier();
        var zipped = Streams.zip(argsTypes.stream(), argIdentifier.stream(),
                (typ, id) -> new ParameterDeclaration(Type.fromIndex(typ.getRuleIndex()), id.getText()))
                .collect(Collectors.toList());
        return new FuncDeclaration(Type.fromIndex(type.getRuleIndex()),
                identifier.NAME().getText(), zipped,
                body.stmt().stream().map((stmt) -> visitor.visitStmt(stmt)).collect(Collectors.toList()));
    }

}

class StmtVisitor extends com.github.ritka_admin.parsotangue.antlr.ParsoTangueParserBaseVisitor<Stmt> {

    private final ExprVisitor visitor = new ExprVisitor();

    @Override
    public Stmt visitAssignmentStmt(ParsoTangueParser.AssignmentStmtContext ctx) {
        return new AssignStmt(ctx.identifier().getText(), visitor.visitExpr(ctx.expr()));
    }

    @Override
    public Stmt visitFuncExpr(ParsoTangueParser.FuncExprContext ctx) {
        return new FuncExprStmt((FuncExpr)visitor.visitFuncExpr(ctx));
    }

    // TODO: add other stmt visitors
}

class ExprVisitor extends com.github.ritka_admin.parsotangue.antlr.ParsoTangueParserBaseVisitor<Expr> {

    // TODO: add expressions visitors
}
