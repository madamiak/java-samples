package com.example.jackson;

public class Jackson {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{}";

        MyJson myJson = objectMapper.readValue(json, MyJson.class);
    }

}
