package com.luminia.parser;

import java.util.Optional;

import com.luminia.lexical_analysis.SyntaxType;

public abstract class SyntaxNode {

    public abstract SyntaxType getType();
    public abstract Iterable<SyntaxNode> getChildren();

    /**
     * @return the last child of the node
     */ 
    public Optional<SyntaxNode> getLastChild(){
        SyntaxNode lastChild = null;
        for(SyntaxNode child : this.getChildren()){
            lastChild = child;
        }
        return Optional.ofNullable(lastChild);
    }
    
}
