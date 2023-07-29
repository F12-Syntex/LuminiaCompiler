package com.luminia.parser;

import com.luminia.lexical_analysis.Lexer;
import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.lexical_analysis.SyntaxType;
import com.luminia.parser.expressions.BinaryExpressionSyntax;
import com.luminia.parser.expressions.ExpressionSyntax;
import com.luminia.parser.expressions.NumberExpressionSyntax;

public class Parser {
    
    private final String text;
    private Lexer lexer;
    private int position;

    private SyntaxToken[] tokens;

    public Parser(String text) {
        this.text = text;
        this.lexer = new Lexer(text);
        this.tokens = this.lexer.getTokens();
    }

    public Parser(Lexer lexer) {
        this.text = lexer.getText();
        this.lexer = new Lexer(text);
        this.tokens = this.lexer.getTokens();
    }

    /**
     * peek at the token which is at the current position plus the offset
     * @param offset
     * @return
     */
    public SyntaxToken peek(int offset){
        int index = position + offset;
        if(index >= tokens.length){
            return tokens[tokens.length - 1];
        }
        return tokens[index];
    }

    private SyntaxToken nextToken(){
        SyntaxToken current = current();
        position++;
        return current;
    }

    /**
     * peek at the token which is at the current position
     * @return
     */
    public SyntaxToken current(){
        return peek(0);
    }

    private ExpressionSyntax parsePrimaryExpression(){
        SyntaxToken numberToken = match(SyntaxType.NumberToken);
        return new NumberExpressionSyntax(numberToken);
    }

    private SyntaxToken match(SyntaxType type){
        if(this.current().getType() == type){
            return this.nextToken();
        }
        return new SyntaxToken(this.position, null, type, null);
    }

    public ExpressionSyntax parse(){

        ExpressionSyntax left = parsePrimaryExpression();

        while(this.current().getType() == SyntaxType.PlusToken || this.current().getType() == SyntaxType.MinusToken){
            SyntaxToken operatorToken = this.nextToken();
            ExpressionSyntax right = parsePrimaryExpression();
            left = new BinaryExpressionSyntax(left, operatorToken, right);
        }

        return left;
    }

    public String getText() {
        return text;
    }

    public Lexer getLexer() {
        return lexer;
    }

}
