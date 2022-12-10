package com.benyissa;

import com.benyissa.services.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.benyissa.services"})
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IMetier metier = context.getBean(IMetier.class);
        metier.process();
        System.out.println(metier.compute());
    }
}