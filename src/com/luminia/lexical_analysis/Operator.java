package com.luminia.lexical_analysis;

public enum Operator {

    ADD(1),
    MINUS(2),
    MULTIPLY(3),
    DIVIDE(4);

    private int id;

    private Operator(int id) {
        this.id = id;
    }

    /**
     * Get the operator by id
     * @param id
     * @return the operator or null if not found
     */
    public static Operator getOperator(int id) {
        for(Operator operator : Operator.values()) {
            if(operator.id == id) {
                return operator;
            }
        }
        return null;
    }

    
}
