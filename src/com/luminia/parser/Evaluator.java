package com.luminia.parser;

import com.luminia.diagnostics.Diagnostics;
import com.luminia.diagnostics.ReportType;
import com.luminia.lexical_analysis.SyntaxType;
import com.luminia.parser.expressions.BinaryExpressionSyntax;
import com.luminia.parser.expressions.ExpressionSyntax;
import com.luminia.parser.expressions.NumberExpressionSyntax;

public class Evaluator {

    private ExpressionSyntax root;

    public Evaluator(ExpressionSyntax root) {
        this.root = root;
    }

    public int evaluate(){
        return evaluateExpression(root);
    }

    private int evaluateExpression(ExpressionSyntax node){

        //we've already confirmed that any number expression is a valid number, and therefore we can safely cast it
        if(node instanceof NumberExpressionSyntax){
            NumberExpressionSyntax numberNode = (NumberExpressionSyntax) node;
            String value = numberNode.getNumberToken().getValue().get().toString();
            return Integer.parseInt(value);
        }

        if(node instanceof BinaryExpressionSyntax){
            BinaryExpressionSyntax binaryNode = (BinaryExpressionSyntax) node;
            int evaluateLeft = evaluateExpression(binaryNode.getLeft());
            int evaluateRight = evaluateExpression(binaryNode.getRight());

            switch (binaryNode.getOperatorToken().getType()) {
                case PlusToken:
                    return evaluateLeft + evaluateRight;
                case MinusToken:
                    return evaluateLeft - evaluateRight;
                case StarToken:
                    return evaluateLeft * evaluateRight;
                case SlashToken:
                    return evaluateLeft / evaluateRight;
                default: {
                    Diagnostics.report("Unexpected binary operator", ReportType.Error, Evaluator.class);
                    throw new IllegalArgumentException("Unexpected binary operator: " + binaryNode.getOperatorToken() + " valid operators are: +, -, *, /");
                }
            }
        }

        Diagnostics.report("Unexpected node type", ReportType.Error, Evaluator.class);
        throw new IllegalArgumentException("Unexpected node type: " + node.getClass().getName());
    }
    
    
}
