package com.schalldach.data;

public class FirstReply {

    private final String correlationID;


    private final long comeAgain;


    public FirstReply(String correlationID, long comeAgain) {
        this.correlationID = correlationID;
        this.comeAgain = comeAgain;
    }

    public String getCorrelationID() {
        return correlationID;
    }

    public long getComeAgain() {
        return comeAgain;
    }
}
