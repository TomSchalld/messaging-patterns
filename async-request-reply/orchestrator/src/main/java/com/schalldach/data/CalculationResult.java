package com.schalldach.data;

import java.io.Serial;
import java.io.Serializable;

public class CalculationResult implements Serializable {


    @Serial
    private static final long serialVersionUID = -8379464842428010834L;
    private final int result;
    private final String correlationID;


    public CalculationResult(int result, String correlationID) {
        this.result = result;
        this.correlationID = correlationID;
    }

    public int getResult() {
        return result;
    }

    public String getCorrelationID() {
        return correlationID;
    }
}
