package com.nerzon.restcource1.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Getter
@Setter
@Document
public class Dog {

    @Id
    private String id = UUID.randomUUID().toString();

    @Indexed(unique = true)
    private String name;

    private Integer age;

}