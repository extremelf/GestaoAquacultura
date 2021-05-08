package com.extremelf.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tanque extends JFrame{
    private JPanel panelTan;
    private JPanel tanques;
    private JPanel panelbutt;
    private JButton button1;
    private JButton button2;
    private JButton encomendasButton;
    private JButton funcionariosButton;
    private JButton fornecedorButton;
    private JButton clienteButton;
    private JButton manutençãoButton;
    private JButton tanquesButton;
    private JButton definiçõesButton;
    private JButton backButton;
    private JButton verInformacaoButton;
    private JButton button3;
    private JButton button4;
    private JButton button5;



    public Tanque(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start back = new start();
                setVisible(false);
                back.setVisible(true);


            }
        });
    }
    public JPanel getPanelTan(){
        return panelTan;
    }



}
