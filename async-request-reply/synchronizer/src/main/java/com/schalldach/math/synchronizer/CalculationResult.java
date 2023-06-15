package com.schalldach.math.synchronizer;

import java.io.Serial;
import java.io.Serializable;

public class CalculationResult implements Serializable {


    @Serial
    private static final long serialVersionUID = -8379464842428070834L;
    private int result;
    private String correlationID;


    public CalculationResult(int result, String correlationID) {
        this.result = result;
        this.correlationID = correlationID;
    }

    public CalculationResult() {
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    public int getResult() {
        return result;
    }

    public String getCorrelationID() {
        return correlationID;
    }
}
