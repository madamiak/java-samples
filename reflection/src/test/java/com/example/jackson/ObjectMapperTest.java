package com.example.jackson;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectMapperTest {

    @Test
    public void shouldReadInt() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "  \"intValue\": 42,\n" +
                "  \"stringValue\": \"moj string\",\n" +
                "  \"doubleValue\": 123.321\n" +
                "}";

        MyJson myJson = objectMapper.readValue(json, MyJson.class);

        assertEquals(42, myJson.getIntValue());
    }

    @Test
    public void shouldReadString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "  \"intValue\": 42,\n" +
                "  \"stringValue\": \"moj string\",\n" +
                "  \"doubleValue\": 123.321\n" +
                "}";

        MyJson myJson = objectMapper.readValue(json, MyJson.class);

        assertEquals("moj string", myJson.getStringValue());
    }

    @Test
    public void shouldReadDouble() {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "  \"intValue\": 42,\n" +
                "  \"stringValue\": \"moj string\",\n" +
                "  \"doubleValue\": 123.321\n" +
                "}";

        MyJson myJson = objectMapper.readValue(json, MyJson.class);

        assertEquals(123.321, myJson.getDoubleValue(), 0.00000001);
    }


}