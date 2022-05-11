package com.ciklum.microservice.camel.routes;

import com.ciklum.microservice.camel.dto.Person;
import com.ciklum.microservice.camel.processor.PersonExchangeProcessor;
import com.ciklum.microservice.camel.processor.PersonProcessor;
import com.ciklum.microservice.camel.transformer.PersonTransformer;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRouter extends RouteBuilder {
    @Autowired
    private PersonProcessor personProcessor;
    @Autowired
    private PersonTransformer personTransformer;

    @Override
    public void configure() throws Exception {
        restConfiguration().host("gorest.co.in").port(80);

        from("timer:rest-client?repeatCount=1")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("https://gorest.co.in/public/v2/users")
                .unmarshal().json(JsonLibrary.Jackson, Person[].class)
                .bean(personProcessor)
                .bean(personTransformer)
                .process(new PersonExchangeProcessor())
                .log("${body}");

    }
}
