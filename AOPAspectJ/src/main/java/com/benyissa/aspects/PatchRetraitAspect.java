package com.benyissa.aspects;

import com.benyissa.metier.Compte;
import com.benyissa.metier.MetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
    @Pointcut("execution(* com.benyissa.metier.MetierBanqueImpl.retirer(..) )")
    public void pc1(){ }
    @Around("pc1() && args(code,montant)")
    public Object autourRetirer(Long code,double montant,ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        MetierBanqueImpl metierBanque=(MetierBanqueImpl) joinPoint.getTarget();
        Compte compte=metierBanque.consulter(code);
        if(compte.getSolde()<montant) throw new RuntimeException("Balance not sufficient ");
        return  proceedingJoinPoint.proceed();
    }
}
