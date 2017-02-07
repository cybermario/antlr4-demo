package com.formation.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum VehicleStatus {
    CLOSED("-"),
    RESERVED("R");

    private final String value;

    private static final Map<String, VehicleStatus> lookup = new ConcurrentHashMap();

    static {
        for (VehicleStatus vehicleStatus : VehicleStatus.values()) {
            lookup.put(vehicleStatus.value(),
                    vehicleStatus);
        }
    }

    VehicleStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static VehicleStatus get(String value) {
        return lookup.get(value);
    }
}
