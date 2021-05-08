package com.extremelf.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainpage extends JFrame{
    private JPanel panel1;
    private JPanel panelCima;
    private JPanel panelBaixo;
    private JButton button1;
    private JButton button2;
    private JButton encomendasButton;
    private JButton funcionariosButton;
    private JButton fornecedorButton;
    private JButton clienteButton;
    private JButton manutençãoButton;
    private JPanel panelbutt;
    private JButton tanquesButton;
    private JButton definiçõesButton;
    private JButton backButton;


    public mainpage(){


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent j) {
            pagAddEspecie(j);
            }
        });

       button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });

       clienteButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Cliente newpage = new Cliente();
               setVisible(false);
               newpage.getPanelCli().setVisible(true);
           }
       });

    }
    public void pagAddEspecie (java.awt.event.ActionEvent j){

        especieAdd UI1 = new especieAdd();
        UI1.getPanelAddEspecie().setVisible(true);
        this.setContentPane(UI1.getPanelAddEspecie());
        this.pack();
        this.repaint();

    }

    public void switchpanel(JPanel panel){
        getLayeredPane().removeAll();
        getLayeredPane().add(panel);
        getLayeredPane().repaint();
        getLayeredPane().revalidate();

    }
    public JPanel getPanel1(){
        return panel1;
    }
    public JButton getButton1(){
        return button1;
    }
}

