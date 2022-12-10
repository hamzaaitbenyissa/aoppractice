package com.benyissa.aspects;

public aspect FirstAspect {

    pointcut pc1():execution(* com.benyissa.test.Application1.main(..));
    before():pc1(){
        System.out.println("################################################################################");
        System.out.println("Test before going with aspectj syntax  ");
        System.out.println("################################################################################");

    }

    after():pc1(){

        System.out.println("################################################################################");
        System.out.println("Test after going with aspectj syntax");
        System.out.println("################################################################################");
    }
}
