import com.luminia.lexical_analysis.Lexer;
import com.luminia.lexical_analysis.SyntexToken;
import com.luminia.lexical_analysis.SyntexType;

public class Luminia {
    public static void main(String[] args) {
        
        Lexer lexer = new Lexer("3122 + 123 * 123");

        while(true){
            SyntexToken token = lexer.nextToken();
            if(token.getType() == SyntexType.EndOfFileToken){
                break;
            }
            System.out.print(token.getType() + " `" + token.getText() + "`: ");
            token.getValue().ifPresent(value -> System.out.print(" " + value));
            System.out.println();
        }

    }
}
