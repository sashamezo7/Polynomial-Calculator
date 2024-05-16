package org.example;

public class Termen implements Comparable<Termen>{
   public  int grad;
    public double coeficient;

    public Termen(int grad, double coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
    }
    public Termen() {
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

   /* @Override
    public String toString() {
        return "Termen{" +
                "grad=" + grad +
                ", coeficient=" + coeficient +
                '}';
    }*/
    @Override
    public int compareTo(Termen other){
        return Integer.compare(other.grad,this.grad);
    }
    public String toString() { //start of toString method
        String term; //initializes the string term
        switch (grad) { //creates switch cases for the exponent of the monomial
            case 0: //case for when exponent is zero
                term = String.valueOf(coeficient);
                return term;

            case 1: //case for when the exponent is one
                switch ((int) coeficient) { //switch case for coefficient
                    case 1:
                        term = "x";
                        return term;
                    case -1:
                        term = "-x";
                        return term;
                    default:
                        term = String.valueOf(coeficient) + "x";
                        return term;
                }
            default: //default case when the exponent is greater than one
                switch ((int) coeficient) { //switch case for the coefficient
                    case 1:
                        term = "x" + "^" + String.valueOf(grad);
                        return term;
                    case -1:
                        term = "-x" + "^" + String.valueOf(grad);
                        return term;
                    default:
                        term = String.valueOf(coeficient) + "x" + "^" + String.valueOf(grad);
                        return term;
                }
        }
    }
}
