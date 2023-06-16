package com.schalldach.mathengine.receiver;

import com.schalldach.mathengine.MessageReceiver;
import com.schalldach.mathengine.data.CalculationRequest;
import com.schalldach.mathengine.data.CalculationResult;
import com.schalldach.mathengine.operation.ThreadBlocker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile({"divide", "all"})
public class DivideReceiver implements MessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DivideReceiver.class);


    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ThreadBlocker threadBlocker;

    @Value("${orchestrator.reply.queue}")
    private String replyQueue;

    @JmsListener(destination = "${orchestrator.divide.queue}")
    @Override
    public void receive(CalculationRequest request) {
        LOGGER.info("Received calculation request: {}",request);
        final int result = request.getAction().calculate(request.getLeft(), request.getRight());
        threadBlocker.block();
        jmsTemplate.convertAndSend(replyQueue, new CalculationResult(result, request.getCorrelationID()));
        LOGGER.info("Answer send ");
    }
}
