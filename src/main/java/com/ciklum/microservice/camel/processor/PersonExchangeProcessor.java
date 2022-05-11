package com.ciklum.microservice.camel.processor;

import com.ciklum.microservice.camel.dto.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonExchangeProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(PersonExchangeProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Person> persons;
        persons = (List<Person>) exchange.getIn().getBody();
        logger.info("PersonExchangeProcessor: Number of active persons: {}", persons.size());
    }
}
