import com.luminia.lexical_analysis.Lexer;
import com.luminia.parser.Evaluator;
import com.luminia.parser.Parser;
import com.luminia.parser.SyntaxTree;

public class Luminia {
    public static void main(String[] args) {
        
        String text = "12-123-123+13+129999999999999999999--12+1+!asdfasdf6";

        Lexer lexer = new Lexer(text);
        Parser parser = new Parser(lexer);

        System.out.println("Analysing: " + text);
        SyntaxTree expression = parser.parse();
        expression.printTree();

        Evaluator evaluator = new Evaluator(expression.getRoot());
        int result = evaluator.evaluate();
        System.out.println("Result: " + result);
    }
}
