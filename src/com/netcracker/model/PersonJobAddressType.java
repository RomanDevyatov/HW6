package com.netcracker.model;

public enum PersonJobAddressType {

    GAGARINA("Gagarina"),
    GORKIYSQUARE("Gorkiy"),
    POKROVSKAYA("BolhhayaPokrovskaya"),
    BEKETOVA("Beketova"),
    SVOBODASQUARE("Svoboda"),
    MASLYZKOVA("Maslyakova");

    private final String displayName;

    PersonJobAddressType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PersonJobAddressType toPersonJobAddressType(String address) {
        if (address.equals("Gagarina") ) return GAGARINA;
        if (address.equals("Gorkiy"))return GORKIYSQUARE;
        if (address.equals("BolhhayaPokrovskaya"))return POKROVSKAYA;
        if (address.equals("Beketova"))return BEKETOVA;
        if (address.equals("Svoboda"))return SVOBODASQUARE;
        if (address.equals("Maslyakova")) { return MASLYZKOVA; }
        return GAGARINA;
    }
}