package com.benyissa.test;

import com.benyissa.metier.IMetierBanque;
import com.benyissa.metier.Compte;
import com.benyissa.metier.IMetierBanque;
import com.benyissa.metier.MetierBanqueImpl;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        new Application2().start();
    }

    public void start() {
        System.out.println("Application is starting ... 😁");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account code : ");
        Long code = scanner.nextLong();
        System.out.println("initial balance : ");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanque = new MetierBanqueImpl();
        metierBanque.addCompte(new Compte(code, solde));
        while (true) {
            try {
                System.out.println("Operation Type: ");
                String type = scanner.next();
                if (type.equals("q")) break;
                System.out.println("Amount : ");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanque.verser(code, montant);
                } else if (type.equals("r")) {
                    metierBanque.retirer(code, montant);
                }
                Compte c = metierBanque.consulter(code);
                System.out.println("Account Balance  = $" + c.getSolde());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("end of Application,Thanks for being here ❤");

    }
}
