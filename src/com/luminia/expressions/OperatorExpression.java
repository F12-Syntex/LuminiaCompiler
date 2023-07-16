package com.luminia.expressions;

import com.luminia.lexical_analysis.Operator;

public class OperatorExpression extends Expression{
    
    private Expression left;
    private Expression right;

    public Operator operator;

    public OperatorExpression(Expression left, Expression right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public Operator getOperator() {
        return operator;
    }

}
