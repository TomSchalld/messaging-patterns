package com.schalldach.service;


import com.schalldach.data.CalculationEntity;
import com.schalldach.data.CalculationRepository;
import com.schalldach.data.CalculationResult;
import com.schalldach.data.Calulation;
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
    public String calculate(Calulation calulation) {
        final CalculationEntity storedEntity = calculationRepository.save(toEntity(calulation));
        messageDispatcher.send(calulation);
        return storedEntity.getCorrelationID();
    }

    @Override
    public void storeResult(CalculationResult result) {
        final CalculationEntity calculationTask = calculationRepository.findByCorrelationID(result.getCorrelationID());
        calculationTask.setResult(result.getResult());
    }

    private CalculationEntity toEntity(Calulation calulation) {
        return new CalculationEntity(calulation.getLeft(), calulation.getRight(), calulation.getAction(), UUID.randomUUID().toString());
    }

}
