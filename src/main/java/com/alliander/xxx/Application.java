package com.alliander.xxx;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @PostConstruct
    public void runAtStartup() throws IOException {
        LOG.info("At the moment, the time is: " + dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
