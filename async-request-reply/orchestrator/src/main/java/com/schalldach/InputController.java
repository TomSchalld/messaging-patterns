package com.schalldach;

import com.schalldach.data.Calculation;
import com.schalldach.service.CalculationService;
import jakarta.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputController.class);

    @Autowired
    private CalculationService calculationService;


    @PostMapping
    public ResponseEntity<String> calculate(@RequestBody Calculation calculation, @RequestHeader HttpHeaders headers){
        LOGGER.info(calculation.toString());
        final String correlationId = calculationService.calculate(calculation);
        final List<String> hostHeaders = headers.get(HttpHeaders.HOST);
        String host = hostHeaders.get(0);
        return ResponseEntity.accepted().location(URI.create("http://" + host + "/status/" + correlationId)).header(HttpHeaders.RETRY_AFTER,"3000").body(correlationId);

    }


}
