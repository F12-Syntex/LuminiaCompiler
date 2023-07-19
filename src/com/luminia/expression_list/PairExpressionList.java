package com.luminia.expression_list;

import com.luminia.expressions.Expression;

public class PairExpressionList extends ExpressionList {
    
    private Expression head;
    private ExpressionList tail;

    public PairExpressionList(Expression head, ExpressionList tail) {
        this.head = head;
        this.tail = tail;
    }

    public Expression getHead() {
        return head;
    }

    public ExpressionList getTail() {
        return tail;
    }

}
