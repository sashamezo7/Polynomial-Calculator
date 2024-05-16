package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
public static void main(String[] args) {
    JFrame window = new JFrame("Polynomial Calculator");
    window.setContentPane(new Aplication(500,500));
    window.pack();
    window.setResizable(true);
    window.setLocation(500,700);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

}
}