package com.schalldach.math.synchronizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/input")
public class SynchronizedInputController {


    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedInputController.class);

    @Value("${orchestrator.url}")
    private String orchestratorUrl;
    @Value("${orchestrator.polling.max}")
    private int maxPolling;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping
    public ResponseEntity<CalculationResult> calculate(@RequestBody Calculation calculation) throws InterruptedException {
        final long startTime = System.currentTimeMillis();
        LOGGER.info(calculation.toString());
        final URI inputUri = UriComponentsBuilder
                .fromHttpUrl(orchestratorUrl)
                .path("input").build().encode().toUri();
        final RequestEntity<Calculation> body = RequestEntity.method(HttpMethod.POST, inputUri).body(calculation);

        final ResponseEntity<String> acceptedRequest = restTemplate.exchange(body, String.class);
        final HttpHeaders headers = acceptedRequest.getHeaders();
        final URI location = headers.getLocation();
        LOGGER.info("Received location [{}]", location);
        final List<String> strings = headers.get(HttpHeaders.RETRY_AFTER);
        final int pollinterval = Integer.parseInt(Objects.requireNonNull(strings).stream().findFirst().orElse("1000"));
        for (int i = 0; i < maxPolling; i++) {
            final ResponseEntity<CalculationResult> exchange = restTemplate.exchange(RequestEntity.method(HttpMethod.GET, Objects.requireNonNull(location)).build(), CalculationResult.class);
            final long currentTime = (System.currentTimeMillis() - startTime) / 1000;
            LOGGER.info("Received response: [{}] in [{}]s", exchange.getStatusCode(), currentTime);
            if (exchange.getBody() != null) {
                LOGGER.info("Received result: [{}] in [{}]s", exchange.getBody().getResult(), currentTime);
                return exchange;
            }
            Thread.sleep(pollinterval);
        }
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
    }


}
