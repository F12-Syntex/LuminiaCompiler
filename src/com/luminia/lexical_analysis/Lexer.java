package com.luminia.lexical_analysis;

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

    public SyntexToken nextToken(){
        //number
        //+ - * / ( )  
        //white space

        if(position >= text.length()){
            return new SyntexToken(position, "\0", SyntexType.EndOfFileToken, null);
        }

        if(Character.isDigit(this.current())){
            final int start = position;
            while(Character.isDigit(this.current())){
                this.next();
            }
            final int end = position;
            String text = this.text.substring(start, end);

            int value = Integer.parseInt(text);
            return new SyntexToken(start, text, SyntexType.NumberToken, value);
        }

        if(Character.isWhitespace(this.current())){
            final int start = position;
            while(Character.isWhitespace(this.current())){
                this.next();
            }
            final int end = position;
            String text = this.text.substring(start, end);

            return new SyntexToken(start, text, SyntexType.WhiteSpaceToken, null);
        }

        switch(this.current()){
            case '+': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.PlusToken, null);
            }
            case '-': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.MinusToken, null);
            }
            case '*': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.StarToken, null);
            }
            case '/': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.SlashToken, null);
            }
            case '(': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.OpenParenthesisToken, null);
            }
            case ')': {
                String text = Character.toString(this.current());
                return new SyntexToken(position++, text, SyntexType.CloseParenthesisToken, null);
            }
        }

        return new SyntexToken(position++, text.substring(position - 1, 1), SyntexType.BadToken, text);

    }
}
