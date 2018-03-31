package com.library;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Autowired
    private SessionFactory sessionFactory;

    public void test(){
        System.out.println(sessionFactory);
    }
}
