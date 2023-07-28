package com.luminia.parser;

import com.luminia.lexical_analysis.SyntaxType;

public abstract class SyntexNode {

    public abstract SyntaxType getType();
    public abstract Iterable<SyntexNode> getChildren();
    
}
