package com.benyissa.services;

import com.benyissa.aspects.Log;
import com.benyissa.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier {
    @Log
    @SecuredByAspect(roles = {"ADMIN", "USER"})
    @Override
    public void process() {
        System.out.println("Business processing ...");
    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double data = 80;
        System.out.println("Business Computing and returning result ....");
        return data;
    }
}
