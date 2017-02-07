package com.formation;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        // Get our lexer
        // TokenSource lexer = new FormationLexer(new ANTLRInputStream("@A,1,1#BHP,1:1"));

        TokenSource lexer = new FormationLexer(new ANTLRInputStream("@A,F,F,F,F,[(LK,1:1#BHP@B,1:2#BHP,1#BHP,1#BHP@C,WR:5#BHP],[2:6#BHP,2#BHP@D,2#BHP,2#BHP;VR,FA):10#BHP;VH],F,F"));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        FormationParser parser = new FormationParser(tokens);

        // Specify our entry point
        FormationParser.FormationContext formationContext = parser.formation();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        FormationListener formationBuilder = new FormationBuilder(f -> {
            System.out.println(f);
        });
        walker.walk(formationBuilder, formationContext);
    }
}
