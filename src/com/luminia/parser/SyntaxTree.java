package com.luminia.parser;

import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.parser.expressions.ExpressionSyntax;
import com.luminia.utils.Beautify;

public class SyntaxTree {
    
    private SyntaxToken endoffileToken;
    private ExpressionSyntax root;

    public SyntaxTree(ExpressionSyntax root, SyntaxToken endoffileToken){
        this.root = root;
        this.endoffileToken = endoffileToken;
    }

    public SyntaxToken getEndoffileToken() {
        return endoffileToken;
    }

    public ExpressionSyntax getRoot() {
        return root;
    }

    public void printTree(){
        Beautify.prettyPrint(root);
    }

}
