package com.schalldach.mathengine.operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThreadBlocker {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadBlocker.class);


    @Value("${math.engine.delay:-1}")
    private int delay;

    public void block() {
        if (delay > 0) {
            try {
                LOGGER.info("Blocking Thread for [{}]ms", delay);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                LOGGER.error("Failure during sleep", e);
            }
        }
    }


}
