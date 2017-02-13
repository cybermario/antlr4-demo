package com.formation.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleGroup implements FormationElement {

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    private int positionInFormation;

    public VehicleGroup(Builder builder) {
        this.vehicles = builder.vehicles;
        this.positionInFormation = builder.positionInFormation;
    }

    public int getPositionInFormation() {
        return positionInFormation;
    }

    public final static class Builder {
        private List<Vehicle> vehicles = new ArrayList();
        private int positionInFormation;

        public Builder(int positionInFormation) {
            this.positionInFormation = positionInFormation;
        }

        public Builder setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public VehicleGroup.Builder addVehicle(Vehicle vehicle) {
            this.vehicles.add(vehicle);
            return this;
        }

        public VehicleGroup createVehicleGroup() {
            return new VehicleGroup(this);
        }
    }

}
