package com.nerzon.restcource1.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class) //для автоматической конфигурации
@SpringBootTest  //аннотац нужна потому что mockMvc создается в контексте спринга
@AutoConfigureMockMvc //для автоматич конфигурации mockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc; //для интеграционных тестов, воссоздаем реальные условия чтоб к контроллеру общаться как к реальному серверу


    @Test
    void addCat() throws Exception {

        String jsonRequest = "{\"name\":\"Barsik\",\"age\":15,\"weight\":26}"; //json строка запроса
        var response = mockMvc.perform(
                post("/api/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andReturn(); //для получения результата

        String resultJson = response.getResponse().getContentAsString();
        assertEquals("{\"age\":15,\"id\":1,\"name\":\"Barsik\",\"weight\":26}", resultJson);
    }
}
