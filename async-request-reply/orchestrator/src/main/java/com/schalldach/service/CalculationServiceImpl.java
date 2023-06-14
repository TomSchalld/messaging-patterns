package com.schalldach.service;


import com.schalldach.data.CalculationEntity;
import com.schalldach.data.CalculationRepository;
import com.schalldach.data.CalculationResult;
import com.schalldach.data.Calculation;
import com.schalldach.message.MessageDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private MessageDispatcher messageDispatcher;
    @Autowired
    private CalculationRepository calculationRepository;


    @Override
    public String calculate(Calculation calculation) {
        final CalculationEntity storedEntity = calculationRepository.save(toEntity(calculation));
        calculation.setCorrelationID(storedEntity.getCorrelationID());
        messageDispatcher.send(calculation);
        return storedEntity.getCorrelationID();
    }

    @Override
    public void storeResult(CalculationResult result) {
        final CalculationEntity calculationTask = calculationRepository.findByCorrelationID(result.getCorrelationID());
        calculationTask.setResult(result.getResult());
    }

    private CalculationEntity toEntity(Calculation calculation) {
        return new CalculationEntity(calculation.getLeft(), calculation.getRight(), calculation.getAction(), UUID.randomUUID().toString());
    }

}
