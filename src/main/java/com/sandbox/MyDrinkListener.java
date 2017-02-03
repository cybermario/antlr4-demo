// Generated from com\sandbox\Drink.g4 by ANTLR 4.3
package com.sandbox;

import org.antlr.v4.runtime.misc.NotNull;

public class MyDrinkListener extends DrinkBaseListener {

    @Override
    public void enterDrink(@NotNull DrinkParser.DrinkContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void exitDrinkSentence(@NotNull DrinkParser.DrinkSentenceContext ctx) {
        System.out.println("getText(): " + ctx.getText());
        System.out.println("");
        System.out.println("ARTICLE(): " + ctx.ARTICLE());
        System.out.println("DRINKING_VESSEL(): " + ctx.DRINKING_VESSEL());
        System.out.println("OF(): " + ctx.OF());
        System.out.println("drink: " + ctx.drink().getText());
    }

    @Override
    public void exitDrink(@NotNull DrinkParser.DrinkContext ctx) {
        System.out.println(ctx.getText());
    }
}