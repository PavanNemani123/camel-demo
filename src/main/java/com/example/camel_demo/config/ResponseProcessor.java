package com.example.camel_demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("responseProcessor")
@Slf4j
public class ResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        log.info("body has been logged {}", body);
        TimeUnit.SECONDS.sleep(5);
        log.info("sleep over {}", exchange.getIn().getHeaders());
    }
}
