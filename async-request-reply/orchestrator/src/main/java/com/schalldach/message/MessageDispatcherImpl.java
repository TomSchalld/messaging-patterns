package com.schalldach.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schalldach.data.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageDispatcherImpl implements MessageDispatcher {


    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDispatcherImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void send(Calculation calculation) {
        final String destination = calculation.getAction().getQueueDestination();
        LOGGER.info("Sending message to {}, with value {}", destination, calculation);
        jmsTemplate.convertAndSend(destination, calculation);
    }


}
