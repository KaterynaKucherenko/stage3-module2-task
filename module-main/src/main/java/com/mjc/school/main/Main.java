package com.mjc.school.main;

import com.mjc.school.controller.commands.Menu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Menu menu = applicationContext.getBean(Menu.class);
       menu.start();
    }
}
