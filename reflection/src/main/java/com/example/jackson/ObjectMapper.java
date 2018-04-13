package com.example.jackson;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class ObjectMapper {
    public <T> T readValue(String json, Class<T> type) {
        try {
            // utwórz instancję typu T
            T instance = type.newInstance();

            JSONObject jsonObject = new JSONObject(json);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) { //dla każdego klucza w JSONie
                // pobierz wartość klucza
                String key = keys.next();

                // pobierz typ pola
                Field declaredField = type.getDeclaredField(key);
                Object value = jsonObject.get(key);

                // ustaw klucz we wcześniej utworzonym obiekcie
                Method method = type.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), declaredField.getType());

                // wywołaj metodę
                method.invoke(instance, value);
            }

            // zwróć obiekt z linijki 10
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
