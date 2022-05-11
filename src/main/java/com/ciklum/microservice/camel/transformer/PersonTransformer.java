package com.ciklum.microservice.camel.transformer;

import com.ciklum.microservice.camel.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonTransformer {

    private Logger logger = LoggerFactory.getLogger(PersonTransformer.class);

    public List<Person> fetchActivePersons(List<Person> personsList) {
        logger.info("PersonTransformer: Total persons {} and processing only active persons", personsList.size());
        return personsList.stream()
                .filter(person -> person.getStatus().equalsIgnoreCase("active"))
                .toList();
    }
}
