package com.luminia.expression_list;

import com.luminia.expressions.Expression;

public class LastExpressionList extends ExpressionList {
    
    private Expression head;

    public LastExpressionList(Expression head) {
        this.head = head;
    }

    public Expression getHead() {
        return head;
    }

}
