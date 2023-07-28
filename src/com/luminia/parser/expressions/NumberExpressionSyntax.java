package com.luminia.parser.expressions;

import java.util.List;

import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.lexical_analysis.SyntaxType;
import com.luminia.parser.SyntexNode;

public class NumberExpressionSyntax extends ExpressionSyntax{

    private SyntaxToken numberToken;

    public NumberExpressionSyntax(SyntaxToken numberToken) {
        this.numberToken = numberToken;
    }

    @Override
    public SyntaxType getType() {
        return SyntaxType.NumberToken;
    }

    public SyntaxToken getNumberToken() {
        return numberToken;
    }

    @Override
    public Iterable<SyntexNode> getChildren() {
        return List.of(this.numberToken);
    }
    
}
