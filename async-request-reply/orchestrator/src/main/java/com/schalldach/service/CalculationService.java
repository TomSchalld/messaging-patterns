package com.schalldach.service;

import com.schalldach.data.CalculationResult;
import com.schalldach.data.Calulation;

public interface CalculationService {
    String calculate(Calulation calulation);

    void storeResult(CalculationResult result);
}
