package com.monitoring.controller;

import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.random.RandomGenerator;

@RestController
@RequiredArgsConstructor
public class IDController {

    private final Tracer tracer;
    private final Logger logger= LoggerFactory.getLogger(IDController.class);

    @GetMapping("/Id")
    public Integer  getId( @RequestHeader HttpHeaders headers){
        String traceParentHeader = headers.getFirst("traceparent");

        if (traceParentHeader != null) {
            logger.info("Traceparent Header: {}", traceParentHeader);
        } else {
            logger.warn("Traceparent header bulunamadı!");
        }
        int i = RandomGenerator.getDefault().nextInt(1000);
        logger.info("ID Controller Called and return ID: {}",i);
        return i;
    }
}
