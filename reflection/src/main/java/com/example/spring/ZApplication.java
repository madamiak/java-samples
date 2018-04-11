package com.example.spring;

import com.example.ApiConnect;

@MySpringApplication
public class ZApplication {

    @MyAutowired
    private SomeService someService;

    @MyAutowired
    private ApiConnect apiConnect;

    public static void main(String[] args) {
        Spring.run(ZApplication.class);
    }

    public void start() {
        someService.execute("hello");
        System.out.println("someService injected? " + (someService != null));
        System.out.println("apiConnect injected? " + (apiConnect != null));
    }
}
