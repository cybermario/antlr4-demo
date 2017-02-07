// Generated from com\sandbox\Drink.g4 by ANTLR 4.3
package com.formation;

import java.util.function.Consumer;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.formation.model.Formation;
import com.formation.model.Offer;
import com.formation.model.PassThrough;
import com.formation.model.Vehicle;
import com.formation.model.VehicleGroup;
import com.formation.model.VehicleStatus;
import com.formation.model.VehicleType;

public class FormationBuilder extends FormationBaseListener {

    private static final Logger LOG = LoggerFactory.getLogger(FormationBuilder.class.getName());


    private Consumer<Formation> formationConsumer;

    private Formation.Builder formationBuilder;

    private VehicleGroup.Builder vehicleGroupBuilder;

    private Vehicle.Builder vehicleBuilder;

    private String sector;

    private int vehicleGroupIndex = 0;

    public FormationBuilder(Consumer<Formation> formationConsumer) {
        this.formationConsumer = formationConsumer;
    }

    @Override
    public void enterFormation(@NotNull FormationParser.FormationContext ctx) {
        this.formationBuilder = new Formation.Builder();
    }

    @Override
    public void enterGroup(@NotNull FormationParser.GroupContext ctx) {
        LOG.debug("Enter Group: {} ", ctx.getText());
        this.vehicleGroupBuilder = new VehicleGroup.Builder();
    }

    @Override
    public void exitGroup(@NotNull FormationParser.GroupContext ctx) {
        LOG.debug("Exit Group: {} ", ctx.getText());
        formationBuilder.addVehicleGroup(vehicleGroupBuilder.createVehicleGroup());
        vehicleGroupBuilder = null;
        vehicleGroupIndex++;
    }

    @Override
    public void enterVehicle(@NotNull FormationParser.VehicleContext ctx) {
        LOG.debug("Enter Vehicle: {} ", ctx.getText());
        vehicleBuilder = new Vehicle.Builder();

        if (ctx.STATUS() != null) {
            vehicleBuilder.setVehicleStatus(VehicleStatus.get(ctx.STATUS().getText()));
        }

        if (ctx.NO_LEFT_PASSAGE() != null) {
            vehicleBuilder.setPassThrough(PassThrough.NO_LEFT_PASSTHROUGH);
        } else if (ctx.NO_RIGHT_PASSAGE() != null) {
            vehicleBuilder.setPassThrough(PassThrough.NO_RIGHT_PASSTHROUGH);
        }
    }

    @Override
    public void enterSectorName(@NotNull FormationParser.SectorNameContext ctx) {
        LOG.debug("Enter Sector Name: {} ", ctx.getText());
        sector = ctx.getText();
    }

    @Override
    public void exitFormation(@NotNull FormationParser.FormationContext ctx) {
        LOG.debug("Exit Formation: {} ", ctx.getText());
        formationConsumer.accept(formationBuilder.createFormation());
    }

    @Override
    public void exitVehicleType(@NotNull FormationParser.VehicleTypeContext ctx) {
    }

    @Override
    public void enterOffer(@NotNull FormationParser.OfferContext ctx) {
    }

    @Override
    public void exitOffer(@NotNull FormationParser.OfferContext ctx) {
    }

    @Override
    public void enterOrderNumber(@NotNull FormationParser.OrderNumberContext ctx) {
        LOG.debug("Enter Order Number: {} ", ctx.getText());
        vehicleBuilder.setOrderNumber(Integer.parseInt(ctx.getText()));
    }

    @Override
    public void exitOrderNumber(@NotNull FormationParser.OrderNumberContext ctx) {
    }

    @Override
    public void exitSectorName(@NotNull FormationParser.SectorNameContext ctx) {
    }

    @Override
    public void enterSector(@NotNull FormationParser.SectorContext ctx) {
    }

    @Override
    public void exitSector(@NotNull FormationParser.SectorContext ctx) {
    }

    @Override
    public void enterVehicleType(@NotNull FormationParser.VehicleTypeContext ctx) {
        LOG.debug("Enter Vehicle Type: {} ", ctx.getText());
        LOG.debug("Related VehicleType is {}", VehicleType.get(ctx.getText()));
        vehicleBuilder.setVehicleType(VehicleType.get(ctx.getText()));
    }

    @Override
    public void enterOfferText(@NotNull FormationParser.OfferTextContext ctx) {
        LOG.debug("Enter Offer Text: {} ", ctx.getText());
        LOG.debug("Related Offer is {}", Offer.get(ctx.getText()));
        vehicleBuilder.addOffer(Offer.get(ctx.getText()));
    }

    @Override
    public void exitOfferText(@NotNull FormationParser.OfferTextContext ctx) {
    }

    @Override
    public void exitVehicle(@NotNull FormationParser.VehicleContext ctx) {
        LOG.debug("Exit Vehicle: {} ", ctx.getText());
        vehicleBuilder.setSector(sector);

        if (vehicleGroupBuilder != null) {
            vehicleBuilder.setVehicleGroupIndex(vehicleGroupIndex);
        }

        Vehicle vehicle = vehicleBuilder.createVehicle();

        if (vehicleGroupBuilder != null) {
            vehicleGroupBuilder.addVehicle(vehicle);
            vehicleBuilder = null;
        }

        formationBuilder.addVehicle(vehicle);
    }

    @Override
    public void enterOrder(@NotNull FormationParser.OrderContext ctx) {
    }

    @Override
    public void exitOrder(@NotNull FormationParser.OrderContext ctx) {
    }

    @Override
    public void enterEveryRule(@NotNull ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(@NotNull ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
    }

    @Override
    public void visitErrorNode(@NotNull ErrorNode node) {
    }
}

