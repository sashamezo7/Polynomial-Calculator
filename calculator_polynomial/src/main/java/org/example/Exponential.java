package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Exponential extends Aplication{
    ArrayList<Termen> rezultat = new ArrayList<>();
    ArrayList<Termen> calcul = new ArrayList<>();


    /*public void exponential(ArrayList<Termen> polynom1, int exponent){
        rezultat.clear();
        rezultat.addAll(polynom1);

        for(int i=0;i<exponent;i++){
            inmultire(polynom1,rezultat);
        }
    }*/
    public void exponential(ArrayList<Termen> polynom1, int exponent) {
        ArrayList<Termen> tempResult = new ArrayList<>();

        tempResult.addAll(polynom1);
        inmultire(tempResult,polynom1);

        for (int i = 1; i < exponent-1; i++) {
            inmultire(calcul, polynom1);
        }
    }


    public void inmultire(ArrayList<Termen> polynom1, ArrayList<Termen> polynom2){
        ArrayList<Termen> temporar = new ArrayList<>();
        for(Termen termen_polynom1:polynom1){
            for (Termen termen_polynom2:polynom2){
                temporar.add(new Termen(termen_polynom1.getGrad()+termen_polynom2.getGrad(),termen_polynom1.getCoeficient()*termen_polynom2.getCoeficient()));
            }
        }
        for(int i=0;i<temporar.size()-1;i++){
            if(temporar.get(i).getGrad()==temporar.get(i+1).getGrad()){
                Termen nou = new Termen(temporar.get(i).getGrad(),temporar.get(i).getCoeficient()+temporar.get(i+1).getCoeficient());
                temporar.remove(temporar.get(i+1));
                temporar.remove(temporar.get(i));
                temporar.add(temporar.indexOf(temporar.get(i)),nou);
            }
        }
        rezultat.clear();
        rezultat.addAll(temporar);
        calcul.clear();
        calcul.addAll(temporar);
    }

    public String toString() { //outputs the linked list as the polynomial in the standard form
        String polynomial = ""; //initializes string to null string
        for (Termen temp: rezultat) {
            if (temp.getCoeficient() == 0) {
                continue;
            }

            else if (temp != rezultat.get(0) && temp.getCoeficient() > 0) { //checks for the head of the list for appropriate formatting
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
        return polynomial; //returns the created polynomial string
    }

}
