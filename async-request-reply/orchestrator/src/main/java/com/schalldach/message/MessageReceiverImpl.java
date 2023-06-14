package com.schalldach.message;

import com.schalldach.data.CalculationResult;
import com.schalldach.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MessageReceiverImpl implements MessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiverImpl.class);

    @Autowired
    private CalculationService calculationService;


    @JmsListener(destination = "${orchestrator.reply.queue}")
    @Override
    public void receive(CalculationResult result){
        LOGGER.info("Received result {} for task with correlation id: {}",result.getResult(),result.getCorrelationID());
        calculationService.storeResult(result);
    }



}
