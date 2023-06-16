package com.schalldach;

import com.schalldach.data.CalculationResult;
import com.schalldach.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private CalculationService calculationService;


    @GetMapping
    @RequestMapping("{correlationID}")
    public ResponseEntity<CalculationResult> getResult(@PathVariable String correlationID) {
        LOGGER.info("Getting request for result on correlationID: [{}]", correlationID);

        final CalculationResult result = calculationService.getResult(correlationID);
        if (result == null) {
            LOGGER.info("Response for result on correlationID: [{}] is not found 404", correlationID);
            return ResponseEntity.notFound().build();
        }
        LOGGER.info("Response for result on correlationID: [{}] is [{}]", correlationID, result.getResult());
        return ResponseEntity.ok(result);

    }


}
