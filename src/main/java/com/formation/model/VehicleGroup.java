package com.formation.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleGroup {

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public VehicleGroup(Builder builder) {
        this.vehicles = builder.vehicles;
    }

    public final static class Builder {
        private List<Vehicle> vehicles = new ArrayList();

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
