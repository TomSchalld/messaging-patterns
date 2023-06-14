package com.schalldach;

import com.schalldach.data.FirstReply;
import com.schalldach.service.CalculationService;
import com.schalldach.data.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputController.class);

    @Autowired
    private CalculationService calculationService;


    @PostMapping
    public ResponseEntity<FirstReply> calculate(@RequestBody Calculation calculation){
        LOGGER.info(calculation.toString());
        final String correlationId = calculationService.calculate(calculation);
        return ResponseEntity.accepted().body(new FirstReply(correlationId, 0));
    }


}
