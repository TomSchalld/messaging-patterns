package com.schalldach.mathengine.operation;

import com.schalldach.mathengine.MessageReceiver;
import com.schalldach.mathengine.data.Action;
import com.schalldach.mathengine.data.CalculationRequest;
import com.schalldach.mathengine.data.CalculationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile({"divide","all"})
public class Divide implements MathematicalOperation, MessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Divide.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${orchestrator.reply.queue}")
    private String replyQueue;


    @Override
    public int calculate(int left, int right) {
        return left/right;
    }

    @Override
    public Action getAction() {
        return Action.DIVIDE;
    }

    @JmsListener(destination = "calc.q.in.divide")
    @Override
    public void receive(CalculationRequest request) {
        LOGGER.info("Received calculation request: {}",request);
        final int result = calculate(request.getLeft(), request.getRight());
        jmsTemplate.convertAndSend(replyQueue, new CalculationResult(result, request.getCorrelationID()));
        LOGGER.info("Answer send ");
    }
}
