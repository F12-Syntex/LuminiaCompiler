package com.luminia.lexical_analysis;

public class NumberExpression extends Expression{
    
    private int num;

    public NumberExpression(int num) {
        this.num = num;
    }

    public int getId() {
        return num;
    }

}
