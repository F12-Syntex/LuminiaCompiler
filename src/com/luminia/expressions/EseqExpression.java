package com.luminia.expressions;

import com.luminia.statements.Statement;

public class EseqExpression extends Expression{

    private Statement statement;
    private Expression expression;

    public EseqExpression(Statement statement, Expression expression) {
        this.statement = statement;
        this.expression = expression;
    }

    public Statement getStatement() {
        return statement;
    }

    public Expression getExpression() {
        return expression;
    }
    
}
