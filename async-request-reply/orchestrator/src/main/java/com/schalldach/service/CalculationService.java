package com.schalldach.service;

import com.schalldach.data.CalculationResult;
import com.schalldach.data.Calculation;

public interface CalculationService {
    String calculate(Calculation calculation);

    void storeResult(CalculationResult result);
}
