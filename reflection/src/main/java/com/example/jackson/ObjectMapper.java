package com.example.jackson;

import org.json.JSONObject;

import java.util.Iterator;

public class ObjectMapper {
    public <T> T readValue(String json, Class<T> type) {
        try {
            // utwórz instancję typu T
            // kawałek kodu: type.<metoda do tworzenia obiektu/instancji>()

            JSONObject jsonObject = new JSONObject(json);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) { //dla każdego klucza w JSONie
                // pobierz wartość klucza
                // kawałek kodu: jsonObject.get("<nazwa klucza w JSONie>");

                // ustaw klucz we wcześniej utworzonym obiekcie
                // kawałek kodu: type.getMethod("set<nazwa klucz w JSONie z pierwsza wielką literą")

                // wywołaj metodę
                // kawałek kodu method.invoke(<obiekt utworzony w linijce 10>, <wartość klucza>)
            }

            // zwróć obiekt z linijki 10
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
