package com.luminia.expressions;

public class NumberExpression extends Expression{
    
    private int num;

    public NumberExpression(int num) {
        this.num = num;
    }

    public int getId() {
        return num;
    }

}
