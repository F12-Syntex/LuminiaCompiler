import com.luminia.lexical_analysis.Lexer;
import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.lexical_analysis.SyntaxType;

public class Luminia {
    public static void main(String[] args) {
        
        Lexer lexer = new Lexer("3122 + 123 * 123");

        while(true){
            SyntaxToken token = lexer.nextToken();
            if(token.getType() == SyntaxType.EndOfFileToken){
                break;
            }
            System.out.print(token.getType() + " \"" + token.getText() + "\"");
            token.getValue().ifPresent(value -> System.out.print("(" + value + ")"));
            System.out.println();
        }

    }
}
