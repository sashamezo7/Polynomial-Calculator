package org.example;

import java.util.ArrayList;

public class Value extends Aplication{
    double rezultat=0;

    public void value(ArrayList<Termen> polynom1,double valoare){
        for(Termen termen: polynom1){
            rezultat=rezultat+exponential(termen.getGrad(),valoare)*termen.getCoeficient();
        }

    }
    public double exponential(int grad,double valoare){
        double rez = Math.pow(valoare,grad);
        return rez;
    }
}
