package com.schalldach;

import com.schalldach.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private CalculationService calculationService;




    @GetMapping
    @RequestMapping("/{correlationID}")
    public ResponseEntity<String> getStatus(@PathVariable String correlationID, @RequestHeader HttpHeaders headers){
        LOGGER.info("Get status for [{}]",correlationID);
        final List<String> hostHeaders = headers.get(HttpHeaders.HOST);
        String host = hostHeaders.get(0);

        if (calculationService.hasResult(correlationID)) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://" + host + "/result/" + correlationID)).build();
        }

        return ResponseEntity.ok().location(URI.create("http://" + host + "/status/" + correlationID)).header(HttpHeaders.RETRY_AFTER,"3000").build();

    }


}
