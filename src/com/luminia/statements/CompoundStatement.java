package com.luminia.lexical_analysis;

public class CompoundStatement extends Statement{

    private Statement statement1;
    private Statement statement2;

    public CompoundStatement(Statement statement1, Statement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public Statement getStatement1() {
        return statement1;
    }

    public Statement getStatement2() {
        return statement2;
    }
    
}
