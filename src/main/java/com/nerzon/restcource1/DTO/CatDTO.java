package com.nerzon.restcource1.DTO;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

//dto нужно чтоб обмениваться данными
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatDTO {
    String name;
    int age;
    int weight;


}
