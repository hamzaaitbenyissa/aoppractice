package com.benyissa;

import com.benyissa.services.IMetier;
import com.benyissa.services.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SecurityContext.authenticateUser("root", "1234", new String[]{"ADMIN"});
        IMetier metier = context.getBean(IMetier.class);
        metier.process();
        System.out.println(metier.compute());
    }
}