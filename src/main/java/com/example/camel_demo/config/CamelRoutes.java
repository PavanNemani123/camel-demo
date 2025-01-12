package com.example.camel_demo.config;

import org.apache.camel.Configuration;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Component
public class CamelRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:{{sftp.incoming}}?noop=false&recursive=false&readLock=markerFile")
                .threads()
                .poolSize(3)
                .maxPoolSize(10)
                .process(new ResponseProcessor())
                .to("file:{{sftp.backup}}");
    }
}
