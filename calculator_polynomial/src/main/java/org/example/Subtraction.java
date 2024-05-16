package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Subtraction extends  Aplication{
    public LinkedList<Termen> rezultat = new LinkedList<>();

    public void scadere(int grad, double coeficient, ArrayList<Termen> polynom, int ok) {

        Termen nou = new Termen(grad, coeficient);
        int okk = 0;
        for (int i = 0; i < polynom.size(); i++) {
            if (polynom.get(i).grad == grad) {
                okk = 1;
                if(ok==0) {
                    Termen nou2 = new Termen(grad,coeficient-polynom.get(i).getCoeficient());
                    rezultat.add(nou2);
                }
                break;
            }
        }
        if(okk == 0) {
            if (ok == 1) {
                rezultat.add(new Termen(grad, -coeficient));

            } else
                rezultat.add(nou);
        }

    }

    public void substractPolynomials(ArrayList<Termen> polynom1, ArrayList<Termen> polynom2){
        for(Termen termen : polynom1){
            scadere(termen.getGrad(),termen.getCoeficient(),polynom2,0);
        }
        for(Termen termen : polynom2){
            scadere(termen.getGrad(),termen.getCoeficient(),polynom1,1);
        }
        // sortare
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
