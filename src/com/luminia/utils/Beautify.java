package com.luminia.utils;

import java.util.Optional;

import com.luminia.lexical_analysis.SyntaxToken;
import com.luminia.parser.SyntaxNode;

public class Beautify {

    public static void prettyPrint(SyntaxNode node, String text){
        System.out.println("┌── parsing (" + text + ")");
        Beautify.prettyPrint(node, "", true, true);
    }

    public static void prettyPrint(SyntaxNode node, String indent, boolean isLastChild, boolean root){

        String marker = !root ? (isLastChild ? "└──" : "├──") : "";

        System.out.print(indent);
        System.out.print(marker);
        System.out.print(node.getType());

        if(node instanceof SyntaxToken){
            SyntaxToken token = (SyntaxToken) node;
            token.getValue().ifPresent(value -> {
                System.out.print(" ");
                System.out.print(value);
            });
        }

        System.out.println();

        indent += isLastChild ? "    " : "│    ";
        Optional<SyntaxNode> lastChild = node.getLastChild();

        for(SyntaxNode child : node.getChildren()) {
            Beautify.prettyPrint(child, indent, child == lastChild.orElse(null), false);
        }
            
    }

}

