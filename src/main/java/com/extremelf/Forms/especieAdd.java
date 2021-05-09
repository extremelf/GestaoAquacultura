package com.extremelf.Forms;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class especieAdd extends JFrame{
    private JPanel panelAddEspecie;
    private JPanel first;
    private JPanel second;
    private JPanel third;
    private JPanel forth;
    private JPanel fifht;
    private JPanel lado;
    private JButton a2Button;
    private JButton button2;
    private JButton a3Button;


    public especieAdd(){



        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(second);
            }
        });



        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(third);
            }
        });

    }


    public void switchPanel(JPanel panel){
        getLayeredPane().removeAll();
        getLayeredPane().add(panel);
        getLayeredPane().repaint();
        getLayeredPane().revalidate();
    }

    public JPanel getPanelAddEspecie(){
        return panelAddEspecie;
    }
}
