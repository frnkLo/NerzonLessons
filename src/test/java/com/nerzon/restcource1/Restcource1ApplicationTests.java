package com.nerzon.restcource1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Restcource1ApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void concatTest(){
        String a = "Hello ";
        String b = "World";

        assertEquals("Hello World", a + b);
    }
}
