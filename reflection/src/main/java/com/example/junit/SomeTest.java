package com.example.junit;

public class SomeTest {

//    @MyTest
    public void test1() {
        System.out.println("test1");
    }

    @MyTest
    public void test2() {
        System.out.println("test2");
        throw new RuntimeException();
    }

//    @MyTest
    public void test3() {
        System.out.println("test3");
    }

//    @MyTest
    public void test4() {
        System.out.println("test4");
    }
}
