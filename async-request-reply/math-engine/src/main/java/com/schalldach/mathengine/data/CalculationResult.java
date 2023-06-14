package com.schalldach.mathengine.data;

import java.io.Serial;
import java.io.Serializable;

public class CalculationResult implements Serializable {


    @Serial
    private static final long serialVersionUID = -8379464842428011834L;
    private int result;
    private String correlationID;


    public CalculationResult(int result, String correlationID) {
        this.result = result;
        this.correlationID = correlationID;
    }

    public CalculationResult() {
    }

    public int getResult() {
        return result;
    }

    public String getCorrelationID() {
        return correlationID;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }
}
