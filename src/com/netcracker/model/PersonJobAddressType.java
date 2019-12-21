package com.netcracker.model;

public enum PersonJobAddressType {

    GAGARINA("Gagarinastreet"),
    GORKIYSQUARE("Girkiysq"),
    POKROVSKAYA("BolhhayaPokrovskayabstreet"),
    BEKETOVA("Beketova street"),
    SVOBODASQUARE("Sboboda sq."),
    MASLYZKOVA("Maslyakova street");

    private final String displayName;

    PersonJobAddressType(String displayName){
        this.displayName=displayName;
    }

    public  String getDisplayName(){
        return displayName;
    }

}
