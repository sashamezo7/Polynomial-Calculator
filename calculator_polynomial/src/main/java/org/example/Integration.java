package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Integration extends Aplication{
    LinkedList<Termen> rezultat = new LinkedList<>();

    public void integration(ArrayList<Termen> polynom1){
        for(int i=0;i<polynom1.size();i++){
            Termen termen = new Termen(polynom1.get(i).getGrad()+1,polynom1.get(i).getCoeficient()/(polynom1.get(i).getGrad()+1));
            rezultat.add(termen);
        }
        Collections.sort(rezultat);
    }
    public String toString() { //outputs the linked list as the polynomial in the standard form
        String polynomial = ""; //initializes string to null string
        for (Termen temp: rezultat) {
            if (temp.getCoeficient() == 0) {
                continue;
            }

            else if (temp != rezultat.getFirst() && temp.getCoeficient() > 0) { //checks for the head of the list for appropriate formatting
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
