package com.luminia.lexical_analysis;

public class PrintStatement extends Statement {

    private ExpressionList expressions;

    public PrintStatement(ExpressionList expressions) {
        this.expressions = expressions;
    }

    public ExpressionList getExpressions() {
        return expressions;
    }

}
