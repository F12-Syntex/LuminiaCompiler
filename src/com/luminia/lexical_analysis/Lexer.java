package com.luminia.lexical_analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lexer {

    private final String text;
    private int position;

    public Lexer(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public int getPosition(){
        return position;
    }

    public char current(){
        if(position >= text.length()){
            return '\0';
        }
        return text.charAt(position);
    }

    public void next(){
        position++;
    }

    public SyntaxToken nextToken(){
        //number
        //+ - * / ( )  
        //white space

        if(position >= text.length()){
            return new SyntaxToken(position, "\0", SyntaxType.EndOfFileToken, null);
        }

        if(Character.isDigit(this.current())){
            final int start = position;
            while(Character.isDigit(this.current())){
                this.next();
            }
            final int end = position;
            String text = this.text.substring(start, end);

            int value = Integer.parseInt(text);
            return new SyntaxToken(start, text, SyntaxType.NumberToken, value);
        }

        if(Character.isWhitespace(this.current())){
            final int start = position;
            while(Character.isWhitespace(this.current())){
                this.next();
            }
            final int end = position;
            String text = this.text.substring(start, end);

            return new SyntaxToken(start, text, SyntaxType.WhiteSpaceToken, null);
        }

        switch(this.current()){
            case '+': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.PlusToken, null);
            }
            case '-': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.MinusToken, null);
            }
            case '*': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.StarToken, null);
            }
            case '/': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.SlashToken, null);
            }
            case '(': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.OpenParenthesisToken, null);
            }
            case ')': {
                String text = Character.toString(this.current());
                return new SyntaxToken(position++, text, SyntaxType.CloseParenthesisToken, null);
            }
        }

        return new SyntaxToken(position++, text.substring(position - 1, 1), SyntaxType.BadToken, text);

    }


    /*
     * a consumer that takes a token and returns a token untill the token is an end of file token
     * a new lexer is created for each call
     * @param consumer the consumer that takes a token and returns a token
     */
    public void tokenize(Consumer<SyntaxToken> consumer){
        Lexer lexer = new Lexer(text);
        SyntaxToken token;
        do{
            token = lexer.nextToken();
            consumer.accept(token);
        }while(token.getType() != SyntaxType.EndOfFileToken);
    }

        /*
     * a consumer that takes a token and returns a token untill the token is an end of file token
     * a new lexer is created for each call
     * @param consumer the consumer that takes a token and returns a token
     * @param predicate the predicate that tests the token
     */
    public void tokenize(Consumer<SyntaxToken> consumer, Predicate<SyntaxToken> predicate){
        Lexer lexer = new Lexer(text);
        SyntaxToken token;
        do{
            token = lexer.nextToken();
            boolean test = predicate.test(token);
            if(test){
                consumer.accept(token);
            }
        }while(token.getType() != SyntaxType.EndOfFileToken);
    }

    /**
     * gets all the tokens in the text, ignoring white space and bad tokens and returns them in a list
     * tokens will be added untill the end of file token is reached
     * @return an array of tokens
     */
    public SyntaxToken[] getTokens(){
        List<SyntaxToken> tokens = new ArrayList<>();
        this.tokenize(tokens::add, (token) -> {
            return token.getType() != SyntaxType.WhiteSpaceToken && token.getType() != SyntaxType.BadToken;
        });
        return tokens.toArray(new SyntaxToken[tokens.size()]);
    }


}
