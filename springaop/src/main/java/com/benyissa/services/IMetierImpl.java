package com.benyissa.services;

import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Business processing ...");
    }

    @Override
    public double compute() {
        double data = 80;
        System.out.println("Business Computing and returning result ....");
        return data;
    }
}
