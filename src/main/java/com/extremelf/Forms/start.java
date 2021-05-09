package com.extremelf.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import org.projetoDois.*

public class start extends JFrame {

    private JLabel label;
    private JPanel sidebar;
    private JButton button;
    private JLabel passwordLabel;
    private JTextField userTexte;
    private JPasswordField passwordText;
    private JButton buttonespecie;
    public JPanel panel5000;
    private JButton clienteBut;
    private JButton buttonEnc;
    private JButton buttonFor;
    private JButton buttonFun;
    private JButton buttonLot;
    private JButton buttonMan;
    private JButton buttonTan;


    public start() {

        panel5000 = new JPanel(/*new FlowLayout(FlowLayout.LEFT,0,0)*/);



        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel5000);

        //sidebar = new JPanel();

        //sidebar.setPreferredSize(new Dimension(20, 200));

        //sidebar.setLocation(0,0);

        //sidebar.setBackground(Color.BLACK);

        //panel5000.add(sidebar);
/*
        label = new JLabel("User:");

        label.setBounds(10, 20, 80, 25);
        panel5000.add(label);
        userTexte = new JTextField(20);
        userTexte.setBounds(100, 20, 165, 25);
        panel5000.add(userTexte);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel5000.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(10, 50, 165, 25);
        panel5000.add(passwordText);*/


        buttonEnc = new JButton("Encomenda");
        buttonEnc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagEncomenda(e);
            }
        });
        buttonEnc.setBounds(200,300,80, 25);
        panel5000.add(buttonEnc);

        buttonFor = new JButton("Fornecedor");
        buttonFor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagFornecedor(e);
            }
        });

        buttonFor.setBounds(200,400,80, 25);
        panel5000.add(buttonFor);

        buttonFun = new JButton("Funcionario");
        buttonFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagFuncionario(e);
            }
        });

        buttonFun.setBounds(200,500,80, 25);
        panel5000.add(buttonFun);


        buttonLot = new JButton("Lote");
        buttonLot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagLotes(e);
            }
        });

        buttonLot.setBounds(200,600,80, 25);
        panel5000.add(buttonLot);

        buttonMan = new JButton("Manutencao");
        buttonMan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagManutencao(e);
            }
        });

        buttonMan.setBounds(200,700,80, 25);
        panel5000.add(buttonMan);


        buttonTan = new JButton("Tanque");
        buttonTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagTanque(e);
            }
        });

        buttonTan.setBounds(200,800,80, 25);
        panel5000.add(buttonTan);


        clienteBut = new JButton("cliente");
        clienteBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagCliente(e);
            }
        });
        clienteBut.setBounds(200, 200, 80, 25);
        panel5000.add(clienteBut);




        buttonespecie = new JButton("especie");
        buttonespecie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagAddEspecie(e);
            }
        });
        buttonespecie.setBounds(100, 100, 80, 25);
        panel5000.add(buttonespecie);
        button = new JButton("Login");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginicialconta(e);
            }
        });
        button.setBounds(100, 80, 80, 25);
        panel5000.add(button);



        this.setVisible(true);

    }


    public void paginicialconta (java.awt.event.ActionEvent e){

        mainpage UI = new mainpage();

        UI.getPanel1().setVisible(true);
        this.setContentPane(UI.getPanel1());
        this.pack();
        this.repaint();
    }
    public void pagAddEspecie (java.awt.event.ActionEvent e){

        especieAdd UI1 = new especieAdd();
        UI1.getPanelAddEspecie().setVisible(true);
        this.setContentPane(UI1.getPanelAddEspecie());
        this.pack();
        this.repaint();

    }

    public void pagCliente (java.awt.event.ActionEvent evt){

        Cliente page = new Cliente();
        page.getPanelCli().setVisible(true);
        this.setContentPane(page.getPanelCli());
        this.pack();
        this.repaint();
    }

    public void pagEncomenda (java.awt.event.ActionEvent evt){

        Encomendas page = new Encomendas();
        page.getPanelEnco().setVisible(true);
        this.setContentPane(page.getPanelEnco());
        this.pack();
        this.repaint();
    }

    public void pagFornecedor (java.awt.event.ActionEvent evt){

        Fornecedor page = new Fornecedor();
        page.getPanelF().setVisible(true);
        this.setContentPane(page.getPanelF());
        this.pack();
        this.repaint();

    }

    public void pagFuncionario (java.awt.event.ActionEvent evt){

        Funcionario page = new Funcionario();
        page.getpanelFunc().setVisible(true);
        this.setContentPane(page.getpanelFunc());
        this.pack();
        this.repaint();
    }

    public void pagLotes (java.awt.event.ActionEvent evt){

        Lotes page = new Lotes();
        page.getPanelLot().setVisible(true);
        this.setContentPane(page.getPanelLot());
        this.pack();
        this.repaint();
    }

    public void pagManutencao (java.awt.event.ActionEvent evt){

        Manutenção page = new Manutenção();
        page.getPanelManu().setVisible(true);
        this.setContentPane(page.getPanelManu());
        this.pack();
        this.repaint();
    }

    public void pagTanque (java.awt.event.ActionEvent evt){

        Tanque page = new Tanque();
        page.getPanelTan().setVisible(true);
        this.setContentPane(page.getPanelTan());
        this.pack();
        this.repaint();
    }

}
