package com.luminia.lexical_analysis;

import java.util.Optional;

public class SyntexToken {

    private int position;
    private String text;
    private SyntexType type;
    private Object value;

    /**
     * this is a syntex token a lexical unit that carries information about its type and any associated values or attributes.
     * @param position the position of the token in the text
     * @param text the text of the token
     * @param type the type of the token
     * @param value the value of the token current types
     */
    public SyntexToken(int position, String text, SyntexType type, Object value) {
        this.position = position;
        this.text = text;
        this.type = type;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public SyntexType getType() {
        return type;
    }

    public Optional<Object> getValue() {
        return Optional.ofNullable(value);
    }
    
}
