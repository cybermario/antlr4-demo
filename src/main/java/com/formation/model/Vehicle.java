package com.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements FormationElement {

    private String sector;

    private VehicleStatus vehicleStatus;

    private PassThrough passThrough;

    private VehicleType vehicleType;

    private int orderNumber;

    private int positionInFormation;

    private List<Offer> offers;

    public Vehicle(Builder builder) {
        this.sector = builder.sector;
        this.passThrough = builder.passThrough;
        this.vehicleStatus = builder.vehicleStatus;
        this.positionInFormation = builder.positionInFormation;
        this.vehicleType = builder.vehicleType;
        this.orderNumber = builder.orderNumber;
        this.offers = builder.offers;
    }

    public static Builder newBuilder(int positionInFormation) {
        return new Builder(positionInFormation);
    }

    public String getSector() {
        return sector;
    }

    public PassThrough getPassThrough() {
        return passThrough;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getPositionInFormation() {
        return positionInFormation;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public static final class Builder {
        private String sector;
        private PassThrough passThrough;
        private VehicleStatus vehicleStatus;
        private int positionInFormation;
        private VehicleType vehicleType;
        private int orderNumber;
        private List<Offer> offers = new ArrayList();

        public Builder(int positionInFormation) {
            this.positionInFormation = positionInFormation;
            // this.displayClassId = Objects.requireNonNull(displayClassId);
        }

        public Builder setSector(String sector) {
            this.sector = sector;
            return this;
        }

        public Builder setPassThrough(PassThrough passThrough) {
            this.passThrough = passThrough;
            return this;
        }

        public Builder setVehicleStatus(VehicleStatus vehicleStatus) {
            this.vehicleStatus = vehicleStatus;
            return this;
        }

        public Builder setVehicleType(VehicleType vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder addOffer(Offer offer) {
            this.offers.add(offer);
            return this;
        }

        public Builder setOffers(List<Offer> offers) {
            this.offers = offers;
            return this;
        }

        public Vehicle createVehicle() {
            return new Vehicle(this);
        }
    }
}
