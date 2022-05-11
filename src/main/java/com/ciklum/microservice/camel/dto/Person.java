package com.ciklum.microservice.camel.dto;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
