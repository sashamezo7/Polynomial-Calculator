package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Aplication extends JPanel implements ActionListener {
    JTextField t1, t2, t3, t4;
    JTextArea t5;
    JLabel p1, p2, op, val, exp;
    JComboBox<String> operator;
    JButton b1,b2;
    public ArrayList<Termen> polynom1 = new ArrayList<>();
    public ArrayList<Termen> polynom2 = new ArrayList<>();
    double valoare;

    public Aplication(int width,int height){
        setLayout(null);
        setBackground(new Color(220,220,255));
        setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
        setPreferredSize( new Dimension(width,height)); //sets the size of the panel

        operator = new JComboBox<String>(); //initializes the elements of the interface
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextArea();
        p1 = new JLabel("Enter the first polynomial");
        p2 = new JLabel("Enter the second polynomial");
        op = new JLabel("Enter the operator");
        val = new JLabel("Enter the value at which the first polynomial is to be evaluated");
        exp = new JLabel("Enter the exponent value");

        operator.addItem("+"); //adds options to the combo box
        operator.addItem("-");
        operator.addItem("*");
        operator.addItem("/");
        operator.addItem("derivative (for 1st polynomial)");
        operator.addItem("integration(for 1st polynomial)");
        operator.setBackground(Color.WHITE);

        b1 = new JButton("Compute"); //adds two buttons and implements the action listener interface for both buttons
        b1.addActionListener(this);
        b1.setBackground(Color.GRAY);

        b2 = new JButton("Clear");
        b2.addActionListener(this);
        b2.setBackground(Color.GRAY);

        add(t1); //adds the elements to the frame
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(val);
        add(exp);
        add(p1);
        add(p2);
        add(op);
        add(b1);
        add(operator);
        add(b2);

        p1.setBounds(15, height-490, width-30, 23); //sets the size and the location of the elements in the frame
        t1.setBounds(12, height-465, (width-165)/2, 28);
        p2.setBounds(15, height-425, width-30, 23);
        t2.setBounds(12, height-400, (width-165)/2, 28);
        val.setBounds(15, height-360, width-30, 23);
        t3.setBounds(12, height-335, (width-165)/2, 28);
        exp.setBounds(15, height-295, width-30, 23);
        t4.setBounds(12, height-270, (width-165)/2, 28);
        b1.setBounds(width/2-10, height-303, (width-30)/2, 28);
        operator.setBounds(width/2-10, height-433, (width-40)/2, 28);
        op.setBounds(244, height-458, width-30,23);
        t5.setBounds(12, height-225, width-24, 172);
        b2.setBounds(width/2-10, height-40, (width-30)/2, 28);
    }


    public Aplication() {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (actionEvent.getActionCommand().equals("Compute")) {
                String operatorSelectat = (String) operator.getSelectedItem();
                if (operatorSelectat.equals("+") || operatorSelectat.equals("-") || operatorSelectat.equals("*") || operatorSelectat.equals("/")) {
                    if (t1.getText().equals("") || t2.getText().equals("")) {
                        t5.setText("Enter both polynomials.");
                    }
                    polynom1.clear();
                    polynom2.clear();
                    getInput(t1.getText(), polynom1);
                    getInput(t2.getText(), polynom2);

                    if (operatorSelectat.equals("+")) {
                        Addition adunare = new Addition();
                        adunare.addPolynomials(polynom1, polynom2);
                        t5.setText(adunare.toString());

                    }
                    if (operatorSelectat.equals("-")) {
                        Subtraction scadere = new Subtraction();
                        scadere.substractPolynomials(polynom1, polynom2);
                        System.out.println("Rezultatul: " + scadere.rezultat);
                        t5.setText(scadere.toString());

                    }
                    if (operatorSelectat.equals("*")) {
                        Multiplication inmultire = new Multiplication();
                        inmultire.inmultire(polynom1, polynom2);
                        System.out.println("Rezultatul: " + inmultire.rezultat);
                        t5.setText(inmultire.toString());

                    }
                    if (operatorSelectat.equals("/")) {
                        Division impartire = new Division();
                        Collections.sort(polynom1);
                        Collections.sort(polynom2);
                        if (impartire.ceckGrad(polynom1, polynom2))
                            t5.setText("1th polynom must be grader than 2th polynom");
                        else {
                            if (polynom2.get(0).getCoeficient() == 0) {
                                t5.setText("2th polinom must be different from 0");
                                return;
                            }
                            impartire.impartire(polynom1, polynom2);
                            t5.setText("");
                            t5.append("Catul: " + impartire.toString_cat() + "\n");
                            t5.append("Restul: " + impartire.toString_rest() + "\n");
                        }

                    }
                } else {
                    polynom1.clear();
                    getInput(t1.getText(), polynom1);

                    if (operatorSelectat.equals("derivative (for 1st polynomial)")) {

                        Derivative derivata = new Derivative();
                        derivata.derivata(polynom1);
                        System.out.println(polynom1);
                        System.out.println(derivata.rezultat);
                        t5.setText(derivata.toString());
                    }
                    if (operatorSelectat.equals("integration(for 1st polynomial)")) {

                        Integration integrare = new Integration();
                        integrare.integration(polynom1);
                        t5.setText(integrare.toString());
                    }
                }
                String valueText = t3.getText();
                if (!valueText.isEmpty()) {
                    polynom1.clear();
                    getInput(t1.getText(), polynom1);
                    try {
                        Value valoare = new Value();
                        double replacementValue = Double.parseDouble(valueText);
                        valoare.value(polynom1, replacementValue);
                        t5.append("\n" + "Value of the polynom is: " + valoare.rezultat);

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid value entered. Please enter a numeric value.");
                    }
                }
                String value = t4.getText();
                if(!value.isEmpty()){
                    polynom1.clear();
                    getInput(t1.getText(),polynom1);
                    try{
                        Exponential expo = new Exponential();
                        int replacementValue = Integer.parseInt(value);
                        expo.exponential(polynom1,replacementValue);
                        t5.append("\n"+"Exponential value of the 1th polynom is: "+"\n");
                        t5.append(expo.toString());
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(this,"Invalid value entered. Please enter a numeric value.");
                    }
                }
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Invalid Polynoms");
        }

        if(actionEvent.getActionCommand().equals("Clear")){
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            polynom1.clear();
            polynom2.clear();

        }
    }
    public void getInput(String input,ArrayList<Termen> polynom) { //receives string polynomial and creates a linked list out of it
        String cleanInput = input.replaceAll("[^0-9x^+-]", "");
        String[] splitString = input.split("(?=[+-])"); //splits string with + and - signs as delimiters
        createPolynom(splitString,polynom); //calls createNode method to create linked list
    }

    public void createPolynom(String []splitstring,ArrayList<Termen> polynom){

        for (int i = 0; i < splitstring.length; i++) { //traverses through the String array created in getInput method
            String[] split = splitstring[i].split("[x^]"); //splits string using 'x' and '^' as delimiters
            int grad = 0;
            double coeficient = 0.0;
            if (split.length == 3) { //checks for the length of the newly created string array
                String node = split[0]; //string value of the coefficient in the string array
                switch (node) { //switch case for coefficient
                    case "-":
                        coeficient = -1.0;
                        grad = Integer.parseInt(split[2]);
                        polynom.add(new Termen(grad,coeficient));
                        break;
                    case "+", "":
                        coeficient = 1.0;
                        grad = Integer.parseInt(split[2]);
                        polynom.add(new Termen(grad,coeficient));
                        break;
                    default:
                        coeficient = Double.parseDouble(split[0]);
                        grad = Integer.parseInt(split[2]);
                        polynom.add(new Termen(grad,coeficient));
                        break;
                }
            }
            else if (split.length == 1) {
                if (!splitstring[i].contains("x")) { //checks if the original string contains the variable term 'x'

                    coeficient = Double.parseDouble(split[0]);
                    grad = 0;
                    polynom.add(new Termen(grad,coeficient));
                }
                else if (splitstring[i].contains("x")) {
                    String node = split[0];
                    switch (node) {
                        case "-":
                            coeficient = -1.0;
                            grad = 1;
                            polynom.add(new Termen(grad,coeficient));
                            break;

                        case "+":
                            coeficient = 1.0;
                            grad = 1;
                            polynom.add(new Termen(grad,coeficient));
                            break;

                        default:
                            coeficient = Double.parseDouble(split[0]);
                            grad = 1;
                            polynom.add(new Termen(grad,coeficient));
                            break;
                    }
                }
            }
            else if (split.length == 0) { //checks if there is leading term 'x'
                coeficient = 1.0;
                grad = 1;
                polynom.add(new Termen(grad,coeficient));
            }
        }
    }
    @Override
    public String toString() {
        return "Aplication{" +
                "polynom1=" + polynom1 +
                ", polynom2=" + polynom2 +
                '}';
    }
}

