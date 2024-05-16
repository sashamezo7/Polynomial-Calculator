package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @Test
    void Test1() {

        Addition adunare = new Addition();
        Termen termen0 = new Termen(0, 1);
        Termen termen1 = new Termen(1, 1);
        Termen termen2 = new Termen(2, 1);

        Termen Termen0 = new Termen(1, 1);
        Termen Termen1 = new Termen(3, 1);
        Termen Termen2 = new Termen(5, 1);
        Termen rez = new Termen(1, 2);
        LinkedList<Termen> expected = new LinkedList<>(Arrays.asList(termen0, rez, termen2, Termen1, Termen2));

        adunare.polynom1 = new ArrayList<>(Arrays.asList(termen0,termen1,termen2));
        adunare.polynom2 = new ArrayList<>(Arrays.asList(Termen0,Termen1,Termen2));

        adunare.addPolynomials(adunare.polynom1,adunare.polynom2);

        System.out.println("rezultat");
        for (int i = 0; i < adunare.rezultat.size(); i++)
            System.out.println("index " + i + " " + adunare.rezultat.get(i).toString());

        //verificam daca cele doua liste sunt egale
        assertEquals(expected.size(), adunare.rezultat.size());
        // verificam elementele din cele doua liste
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).grad, adunare.rezultat.get(i).grad);
            assertEquals(expected.get(i).coeficient, adunare.rezultat.get(i).coeficient);

        }
    }


    @Test
    void Test2() {
        Addition adunare = new Addition();
        Termen termen0 = new Termen(3, 1);
        Termen termen1 = new Termen(4, 1);
        Termen termen2 = new Termen(5, 1);

        Termen Termen0 = new Termen(0, 1);
        Termen Termen1 = new Termen(2, 1);
        Termen Termen2 = new Termen(3, 1);
        Termen rez = new Termen(3, 2);
        LinkedList<Termen> expected = new LinkedList<>(Arrays.asList(Termen0,Termen1,rez,termen1,termen2));

        adunare.polynom1 = new ArrayList<>(Arrays.asList(termen0,termen1,termen2));
        adunare.polynom2 = new ArrayList<>(Arrays.asList(Termen0,Termen1,Termen2));

        adunare.addPolynomials(adunare.polynom1,adunare.polynom2);

        for (int i = 0; i < adunare.rezultat.size(); i++)
            System.out.println("index " + i + " " + adunare.rezultat.get(i).toString());

        //verificam daca cele doua liste sunt egale
        assertEquals(expected.size(), adunare.rezultat.size());
        // verificam elementele din cele doua liste
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).grad, adunare.rezultat.get(i).grad);
            assertEquals(expected.get(i).coeficient, adunare.rezultat.get(i).coeficient);

        }
    }
}