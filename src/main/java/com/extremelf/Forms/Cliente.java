package com.extremelf.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente extends JFrame {
    private JPanel panelCli;
    private JPanel ClienteP;
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

    public Cliente(){

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start back = new start();
                setVisible(false);
                back.setVisible(true);
                dispose();


            }
        });
    }

    public JPanel getPanelCli(){
        return panelCli;
    }
}
