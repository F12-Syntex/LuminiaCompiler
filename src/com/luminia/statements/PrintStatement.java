package com.luminia.statements;

import com.luminia.expression_list.ExpressionList;

public class PrintStatement extends Statement {

    private ExpressionList expressions;

    public PrintStatement(ExpressionList expressions) {
        this.expressions = expressions;
    }

    public ExpressionList getExpressions() {
        return expressions;
    }

}
