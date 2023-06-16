package com.schalldach.service;

import com.schalldach.data.Calculation;
import com.schalldach.data.CalculationResult;

public interface CalculationService {
    String calculate(Calculation calculation);

    void storeResult(CalculationResult result);

    boolean hasResult(String correlationID);

    CalculationResult getResult(String correlationID);
}
