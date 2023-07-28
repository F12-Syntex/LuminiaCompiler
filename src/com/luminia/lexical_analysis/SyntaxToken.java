package com.luminia.lexical_analysis;

import java.util.Collections;
import java.util.Optional;

import com.luminia.parser.SyntexNode;

public class SyntaxToken extends SyntexNode{

    private int position;
    private String text;
    private SyntaxType type;
    private Object value;

    /**
     * this is a syntex token a lexical unit that carries information about its type and any associated values or attributes.
     * @param position the position of the token in the text
     * @param text the text of the token
     * @param type the type of the token
     * @param value the value of the token current types
     */
    public SyntaxToken(int position, String text, SyntaxType type, Object value) {
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

    public Optional<Object> getValue() {
        return Optional.ofNullable(value);
    }

    @Override
    public SyntaxType getType() {
        return type;
    }

    @Override
    public Iterable<SyntexNode> getChildren() {
        return Collections.emptyList();
    }
    
}
