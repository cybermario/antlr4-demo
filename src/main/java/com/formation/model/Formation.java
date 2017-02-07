package com.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formation {
    private List<VehicleGroup> vehicleGroups;

    private List<Vehicle> vehicles;

    public List<VehicleGroup> getVehicleGroups() {
        return vehicleGroups;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Formation(Formation.Builder builder) {
        this.vehicleGroups = builder.vehicleGroups;
        this.vehicles = builder.vehicles;
    }

    public final static class Builder {
        private List<VehicleGroup> vehicleGroups = new ArrayList();

        private List<Vehicle> vehicles = new ArrayList();

        public Formation.Builder setVehicleGroups(List<VehicleGroup> vehicleGroups) {
            this.vehicleGroups = vehicleGroups;
            return this;
        }

        public Formation.Builder addVehicleGroup(VehicleGroup vehicleGroup) {
            this.vehicleGroups.add(vehicleGroup);
            return this;
        }

        public Formation.Builder setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public Formation.Builder addVehicle(Vehicle vehicle) {
            this.vehicles.add(vehicle);
            return this;
        }

        public Formation createFormation() {
            return new Formation(this);
        }
    }

}
