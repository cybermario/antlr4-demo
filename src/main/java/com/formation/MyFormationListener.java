// Generated from com\sandbox\Drink.g4 by ANTLR 4.3
package com.formation;

import org.antlr.v4.runtime.misc.NotNull;

public class MyFormationListener extends FormationBaseListener {

    StringBuilder formationBuilder = null;

    @Override
    public void enterFormation(@NotNull FormationParser.FormationContext ctx) {
        System.out.println("Formation:" + ctx.getText());

        formationBuilder = new StringBuilder();
    }

    @Override
    public void enterGroup(@NotNull FormationParser.GroupContext ctx) {
        System.out.println("Group: " + ctx.getText());
    }

    @Override
    public void enterVehicle(@NotNull FormationParser.VehicleContext ctx) {
        System.out.println("Vehicle: " + ctx.getText());
    }

    @Override
    public void exitFormation(@NotNull FormationParser.FormationContext ctx) {
        // System.out.println("getText(): " + ctx.getText());
    }

    @Override
    public void exitVehicleType(@NotNull FormationParser.VehicleTypeContext ctx) {
        // System.out.println(ctx.getText());
    }
}