package com.formation;

import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import com.formation.model.VehicleGroup;

public class FormationBuilderTest {

    @Test
    public void testFormation() {
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
            Assert.assertEquals(f.getFormationElements().size(), 8);

            Assert.assertTrue(f.getFormationElements().stream().filter(e -> {
                if (e.getClass().equals(VehicleGroup.class)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList()).size() == 2);

        });
        walker.walk(formationBuilder, formationContext);

    }
}
