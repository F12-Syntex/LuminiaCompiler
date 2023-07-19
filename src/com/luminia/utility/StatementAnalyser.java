package com.luminia.utility;

import com.luminia.expression_list.ExpressionList;
import com.luminia.expression_list.LastExpressionList;
import com.luminia.expression_list.PairExpressionList;
import com.luminia.expressions.EseqExpression;
import com.luminia.expressions.Expression;
import com.luminia.expressions.OperatorExpression;
import com.luminia.statements.AssignStatement;
import com.luminia.statements.CompoundStatement;
import com.luminia.statements.PrintStatement;
import com.luminia.statements.Statement;

public class StatementAnalyser {

    /**
     * @return the maximum number of arguments of any print statement in the statement.
     */
    public static int maxPrintArgs(Statement statement) {
        
        if(statement instanceof CompoundStatement) {
            CompoundStatement compoundStatement = (CompoundStatement) statement;
            return 1 + Math.max(maxPrintArgs(compoundStatement.getStatement1()), maxPrintArgs(compoundStatement.getStatement2()));
        }

        if(statement instanceof PrintStatement) {
            PrintStatement printStatement = (PrintStatement) statement;
            return 1 + maxPrintArgs(printStatement.getExpressions());
        }

        if(statement instanceof AssignStatement){
            AssignStatement assignStatement = (AssignStatement) statement;
            return 1 + maxPrintArgs(assignStatement.getExpression());
        }

        return 0;
    }

    private static int maxPrintArgs(ExpressionList expressionList) {

        if(expressionList instanceof LastExpressionList){
            LastExpressionList lastExpressionList = (LastExpressionList) expressionList;
            return 1 + maxPrintArgs(lastExpressionList.getHead());
        }

        if(expressionList instanceof PairExpressionList){
            PairExpressionList pairExpressionList = (PairExpressionList) expressionList;
            return 1 + Math.max(maxPrintArgs(pairExpressionList.getHead()), maxPrintArgs(pairExpressionList.getTail()));
        }

        return 0;
    }

    private static int maxPrintArgs(Expression expression) {
        
        if(expression instanceof EseqExpression){
            EseqExpression eseqExpression = (EseqExpression) expression;
            int maxStatement = maxPrintArgs(eseqExpression.getStatement());
            int maxExpression = maxPrintArgs(eseqExpression.getExpression());
            return 1 + Math.max(maxStatement, maxExpression);
        }

        if(expression instanceof OperatorExpression){
            OperatorExpression operatorExpression = (OperatorExpression) expression;
            int maxLeft = maxPrintArgs(operatorExpression.getLeft());
            int maxRight = maxPrintArgs(operatorExpression.getRight());
            return 1 + Math.max(maxLeft, maxRight);
        }

        return 0;
    }

    
    
}
