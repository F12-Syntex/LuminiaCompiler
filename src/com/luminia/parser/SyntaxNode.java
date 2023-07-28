package com.luminia.parser;

import java.util.Optional;

import com.luminia.lexical_analysis.SyntaxType;
import com.luminia.utils.Beautify;

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

    public void printTree(){
        Beautify.prettyPrint(this);
    }
    
}
