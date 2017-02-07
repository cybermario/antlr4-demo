package com.formation.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Offer {
    HANDICAPED_PARKING("BHP"),
    BYCYCLE_HOOK("VH"),
    BYCYCLE_HOOK_WITH_RESERVATIONR("VR");

    private final String value;

    private static final Map<String, Offer> lookup = new ConcurrentHashMap();

    static {
        for (Offer offer : Offer.values()) {
            lookup.put(offer.value(),
                    offer);
        }
    }

    Offer(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Offer get(String value) {
        return lookup.get(value);
    }
}
