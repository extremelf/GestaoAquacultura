package com.extremelf.Forms;


import javax.swing.*;

public class main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello World Swing!");
        frame.setContentPane(new Cliente().getPanelCli());
        frame.setSize(500, 400);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

}
