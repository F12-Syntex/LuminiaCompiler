import com.luminia.lexical_analysis.Lexer;
import com.luminia.parser.Parser;
import com.luminia.parser.expressions.ExpressionSyntax;

public class Luminia {
    public static void main(String[] args) {
        
        String text = "1 + 3 - 1";

        Lexer lexer = new Lexer(text);
        Parser parser = new Parser(lexer);

        ExpressionSyntax expression = parser.parse();
        expression.printTree();
    }
}
