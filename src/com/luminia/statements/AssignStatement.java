package com.luminia.lexical_analysis;

public class AssignStatement extends Statement {

    private String id;
    private Expression expression;

    public AssignStatement(String id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    public String getId() {
        return id;
    }

    public Expression getExpression() {
        return expression;
    }
    
}
