package com.luminia.parser.expressions;

import java.util.List;

import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.lexical_analysis.SyntaxType;
import com.luminia.parser.SyntexNode;

public class BinaryExpressionSyntax extends ExpressionSyntax{

    private ExpressionSyntax left;
    private ExpressionSyntax right;
    private SyntaxToken operatorToken;

    public BinaryExpressionSyntax(ExpressionSyntax left, SyntaxToken operatorToken, ExpressionSyntax right) {
        this.left = left;
        this.operatorToken = operatorToken;
        this.right = right;
    }


    /**
     * Get the type of the syntax node
     * @return the type of the syntax node
     */
    @Override
    public SyntaxType getType() {
        return SyntaxType.BinaryExpression;
    }
    
    /**
     * Get the left expression
     * @return the left expression
     */
    public ExpressionSyntax getLeft() {
        return left;
    }

    /**
     * Get the right expression
     * @return the right expression
     */
    public ExpressionSyntax getRight() {
        return right;
    }

    /**
     * Get the operator token
     * @return the operator token
     */
    public SyntaxToken getOperatorToken() {
        return operatorToken;
    }


    @Override
    public Iterable<SyntexNode> getChildren() {
        return List.of(this.left, this.operatorToken, this.right);
    }
}
