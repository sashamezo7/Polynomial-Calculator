package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Division extends Aplication{
    ArrayList<Termen> cat = new ArrayList<>();
    ArrayList<Termen> rest;

   /* public boolean ceckNegativeGrad(ArrayList<Termen> polynom1,ArrayList<Termen> polynom2){
        int ok = 0;
        if(polynom1.size()>polynom2.size()) {
            for (int i = polynom1.size() - 1; i >= 0; i--) {
                if(polynom2.size()-1==i){
                    ok=1;
                    if(polynom2.get(i).getGrad()<0 || polynom1.get(i).getGrad()<0)
                        return false;
                }
                else if(ok==1){
                    if (polynom2.get(i).getGrad() < 0 || polynom1.get(i).getGrad() < 0)
                        return false;
                }
                else {
                    if (polynom1.get(i).getGrad() < 0)
                        return false;
                }
            }
            return true;
        }
        else {
            for (int i = polynom2.size() - 1; i >= 0; i--) {
                if(polynom1.size()-1==i){
                    ok=1;
                    if(polynom2.get(i).getGrad()<0 || polynom1.get(i).getGrad()<0)
                        return false;
                }
                else if(ok==1){
                    if (polynom2.get(i).getGrad() < 0 || polynom1.get(i).getGrad() < 0)
                        return false;
                }
                else {
                    if (polynom2.get(i).getGrad() < 0)
                        return false;
                }
            }
            return true;
        }
    }*/

    public boolean ceckGrad(ArrayList<Termen> rest, ArrayList<Termen> polynom2){
        if(rest.get(0).getGrad()<polynom2.get(0).getGrad()) return true;
        return false;
    }

    public void impartire(ArrayList<Termen> polynom1, ArrayList<Termen> polynom2){
        rest = new ArrayList<>(polynom1);
        System.out.println("initializare: "+rest);

        boolean stopCondition = rest.isEmpty() || ceckGrad(rest, polynom2);
        while(!stopCondition){

            Termen termenCat = new Termen(rest.get(0).getGrad() - polynom2.get(0).getGrad(),
                    rest.get(0).getCoeficient() / polynom2.get(0).getCoeficient());

            cat.add(termenCat);
            ArrayList<Termen> produs = inmultire(termenCat,polynom2);
            ArrayList<Termen> retine = new ArrayList<>(rest);
            rest.clear();
            substractPolynomials(retine,produs);
           // Collections.sort(rest, Collections.reverseOrder());
            stopCondition = rest.isEmpty() || ceckGrad(rest, polynom2);
        }
    }

    public ArrayList inmultire(Termen termen, ArrayList<Termen> polynom2){
        ArrayList<Termen> rezultat = new ArrayList<>();

            for (Termen termen_polynom2:polynom2){
                rezultat.add(new Termen(termen.getGrad()+termen_polynom2.getGrad(),termen.getCoeficient()*termen_polynom2.getCoeficient()));
            }
            return  rezultat;
    }

    public void scadere(int grad, double coeficient, ArrayList<Termen> polynom, int ok) {

        Termen nou = new Termen(grad, coeficient);
        int okk = 0;
        for (int i = 0; i < polynom.size(); i++) {
            if (polynom.get(i).grad == grad) {
                okk = 1;
                if(ok==0) {
                    Termen nou2 = new Termen(grad,coeficient-polynom.get(i).getCoeficient());
                    rest.add(nou2);
                }
                break;
            }
        }
        if(okk == 0) {
            if (ok == 1) {
                rest.add(new Termen(grad, -coeficient));

            } else
                rest.add(nou);
        }

    }

    public void substractPolynomials(ArrayList<Termen> polynom1, ArrayList<Termen> polynom2){
        for(Termen termen : polynom1){
            scadere(termen.getGrad(),termen.getCoeficient(),polynom2,0);
        }
        for(Termen termen : polynom2){
            scadere(termen.getGrad(),termen.getCoeficient(),polynom1,1);
        }
        for(int i=0;i<rest.size();i++){
            if(rest.get(i).getCoeficient()==0)
                rest.remove(rest.get(i));
        }
        // sortare
        Collections.sort(rest);
    }
    public String toString_rest() { //outputs the linked list as the polynomial in the standard form
        String polynomial = ""; //initializes string to null string
        for (Termen temp: rest) {
            if (temp.getCoeficient() == 0) {
                continue;
            }

            else if (temp != rest.get(0) && temp.getCoeficient() > 0) { //checks for the head of the list for appropriate formatting
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
    public String toString_cat() { //outputs the linked list as the polynomial in the standard form
        String polynomial = ""; //initializes string to null string
        for (Termen temp: cat) {
            if (temp.getCoeficient() == 0) {
                continue;
            }

            else if (temp != cat.get(0) && temp.getCoeficient() > 0) { //checks for the head of the list for appropriate formatting
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
