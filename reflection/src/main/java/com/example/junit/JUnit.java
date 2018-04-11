package com.example.junit;

import com.example.ClassLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JUnit {
    public static void main(String[] args) throws Exception {
        Class[] classes = ClassLoader.getClasses(JUnit.class.getPackage().getName());
        System.out.println(Arrays.toString(classes));

        for (Class aClass : classes) {
            for (Method method : aClass.getDeclaredMethods()) {
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation.annotationType().equals(MyTest.class)) {
                        Object testObject = aClass.newInstance();
                        try {
                            method.invoke(testObject);
                        } catch (Throwable t) {
                            t.printStackTrace(System.err);
                        }
                    }
                }
            }
        }
    }
}
