package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Multiplication extends Aplication{
    public LinkedList<Termen> rezultat = new LinkedList<>();

    public void inmultire(ArrayList<Termen> polynom1, ArrayList<Termen> polynom2){
        for(Termen termen_polynom1:polynom1){
            for (Termen termen_polynom2:polynom2){
                rezultat.add(new Termen(termen_polynom1.getGrad()+termen_polynom2.getGrad(),termen_polynom1.getCoeficient()*termen_polynom2.getCoeficient()));
            }
        }
        Collections.sort(rezultat);
       for(int i=0;i<rezultat.size()-1;i++){
            if(rezultat.get(i).getGrad()==rezultat.get(i+1).getGrad()){
                Termen nou = new Termen(rezultat.get(i).getGrad(),rezultat.get(i).getCoeficient()+rezultat.get(i+1).getCoeficient());
                rezultat.remove(rezultat.get(i+1));
                rezultat.remove(rezultat.get(i));
                rezultat.add(rezultat.indexOf(rezultat.get(i)),nou);
            }
        }
    }
    public String toString() {
        String polynomial = "";
        for (Termen temp: rezultat) {
            if (temp.getCoeficient() == 0) {
                continue;
            }

            else if (temp != rezultat.getFirst() && temp.getCoeficient() > 0) {
                polynomial += "+" + temp.toString();
            }
            else {
                polynomial += temp.toString();
            }
        }
        if (polynomial.equals("")) {
            return "0";
        }
        else if (polynomial.charAt(0) == '+') {
            String newPolynomial = polynomial.substring(1, polynomial.length());
            return newPolynomial;
        }
        return polynomial;
    }
}
