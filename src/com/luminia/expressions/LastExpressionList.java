package com.luminia.lexical_analysis;

public class LastExpressionList extends ExpressionList {
    
    private Expression head;

    public LastExpressionList(Expression head) {
        this.head = head;
    }

    public Expression getHead() {
        return head;
    }

}
