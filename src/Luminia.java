import com.luminia.expressions.EseqExpression;
import com.luminia.expressions.IDExpression;
import com.luminia.expressions.LastExpressionList;
import com.luminia.expressions.NumberExpression;
import com.luminia.expressions.OperatorExpression;
import com.luminia.expressions.PairExpressionList;
import com.luminia.lexical_analysis.Operator;
import com.luminia.statements.AssignStatement;
import com.luminia.statements.CompoundStatement;
import com.luminia.statements.PrintStatement;
import com.luminia.statements.Statement;

public class Luminia {
    public static void main(String[] args) {
       

    Statement prog = new CompoundStatement(
        new AssignStatement("a", new OperatorExpression(new NumberExpression(5), new NumberExpression(3), Operator.ADD)),
        new CompoundStatement(
            new AssignStatement("b",
                new EseqExpression(
                    new PrintStatement(new PairExpressionList(new IDExpression("a"), new LastExpressionList(new OperatorExpression(new IDExpression("a"), new NumberExpression(1), Operator.MINUS)))),
                    new OperatorExpression(new NumberExpression(10), new IDExpression("a"), Operator.MULTIPLY))
            ),
            new PrintStatement(new LastExpressionList(new IDExpression("b")))
        )
    );


    }
}
