package com.luminia.expressions;

public class IDExpression extends Expression{

    private String id;

    public IDExpression(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
}
