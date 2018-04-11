package com.example.spring;

import com.example.ClassLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Spring {
    public static void run(Class applicationClass) {
        try {
            Class[] classes = ClassLoader.getClasses(applicationClass.getPackage().getName());
            for (Class aClass : classes) {
                Object objectWithAnnotatedFields = null;
                if (aClass.getConstructors().length > 0) {
                    objectWithAnnotatedFields = aClass.newInstance();
                }
                for (Field field : aClass.getDeclaredFields()) {
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation.annotationType().equals(MyAutowired.class)) {
                            field.setAccessible(true);
                            Class<?> type = field.getType();
                            Object object = type.newInstance();
//                            Klasa {
//                                Typ pole;
//                            }
//                            Klasa mojObiekt = new Klasa();
//                            System.out.println(mojObiekt.pole);
//                            mojObiekt.pole = 42
//                            field -> pole
//                            objectWithAnnotatedFields -> mojObiekt
//                            object -> 42
                            field.set(objectWithAnnotatedFields, object);
                        }
                    }
                }
                for (Annotation annotation : aClass.getAnnotations()) {
                    if (annotation.annotationType().equals(MySpringApplication.class)) {
                        Method start = objectWithAnnotatedFields.getClass().getDeclaredMethod("start");
                        start.invoke(objectWithAnnotatedFields);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
