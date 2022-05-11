package com.ciklum.microservice.camel.processor;

import com.ciklum.microservice.camel.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonProcessor {

    private Logger logger = LoggerFactory.getLogger(PersonProcessor.class);

    public void processPersonData(Person[] personList) {
        logger.info("PersonProcessor: Total number of persons: {}", personList.length);
    }
}
