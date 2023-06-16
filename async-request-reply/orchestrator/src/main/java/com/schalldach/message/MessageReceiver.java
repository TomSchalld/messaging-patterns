package com.schalldach.message;

import com.schalldach.data.CalculationResult;
import org.springframework.jms.annotation.JmsListener;

public interface MessageReceiver {


    @JmsListener(destination = "${orchestrator.reply.queue}")
    void receive(CalculationResult result);
}
