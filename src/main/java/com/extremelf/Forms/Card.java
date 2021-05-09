package com.extremelf.Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card {
    private JButton card1Button;
    private JButton card3Button;
    private JButton card2Button;
    private JPanel Cards;
    private JPanel Card1;
    private JPanel Card2;
    private JPanel Card3;
    private JPanel panel1;

    CardLayout cardLayout;

    public Card() {

        card2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards, "Card1");
            }
        });
        card3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards, "Card2");
            }
        });
        card1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards, "Card3");
            }
        });
        cardLayout = (CardLayout) Cards.getLayout();

    }
    public JPanel getPanel(){
        return panel1;
    }
}
