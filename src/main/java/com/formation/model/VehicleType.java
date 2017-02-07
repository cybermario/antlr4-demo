package com.formation.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum VehicleType {
    FIRST_CLASS("1"),
    SECONC_CLASS("2"),
    FIRST_AND_SECONC_CLASS("12"),
    LAYN("CC"),
    FAMILY("FA"),
    SLEEP("WL"),
    SLEEP_AND_LAY("WC"),
    RESTAURANT("WR"),
    TRACTION("LK"),
    BAGGAGE("D"),
    FICTIVE("F"),
    CLASS_LESS("K"),
    PARKED("X");

    private final String value;

    private static final Map<String, VehicleType> lookup = new ConcurrentHashMap();

    static {
        for (VehicleType vehicleType : VehicleType.values()) {
            lookup.put(vehicleType.value(),
                    vehicleType);
        }
    }

    VehicleType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static VehicleType get(String value) {
        return lookup.get(value);
    }
}
