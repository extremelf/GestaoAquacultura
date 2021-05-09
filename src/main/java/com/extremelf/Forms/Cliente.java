package com.extremelf.Forms;

import com.extremelf.BLL.ClienteBLL;
import com.extremelf.BLL.CodpostalBLL;
import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.CodpostalEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class Cliente extends JFrame {
    private JPanel panelCli;
    private JPanel ClienteP;
    private JButton definicoesButton;
    private JButton tanquesButton;
    private JButton manutencaoButton;
    private JButton clienteButton;
    private JButton fornecedorButton;
    private JButton funcionariosButton;
    private JButton encomendasButton;
    private JButton button1;
    private JPanel panelbutt;
    private JButton Lotes;
    private JButton backButton;
    private JPanel NovoCliente;
    private JPanel ListarClientes;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox ComboBox;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel Nome;
    private JButton submeterButton;
    private JTable table1;
    private JButton refreshButton;
    private JPanel Cards1;
    private JPanel Funcionario;
    private JPanel Lotees;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel Fornecedor;
    private JPanel Manutencao;
    private JPanel Encomendas;
    private JPanel Tanques;
    private JPanel Definicoes;
    private JTable table2;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    DefaultTableModel dtm = (DefaultTableModel) table1.getModel();

    CardLayout cardLayout;

    public Cliente() {
        cardLayout = (CardLayout) Cards1.getLayout();
        System.out.println("2");
        dtm.addColumn("Id");
        dtm.addColumn("Nome");
        dtm.addColumn("Rua");
        dtm.addColumn("Numero da Porta");
        dtm.addColumn("Codigo Postal");
        dtm.addColumn("Contacto");
        dtm.addColumn("Cartão Cidadão");


        DefaultComboBoxModel combobox = (DefaultComboBoxModel) ComboBox.getModel();

        List<CodpostalEntity> listaCodigoPostal = CodpostalBLL.readAll();
        for (CodpostalEntity list : listaCodigoPostal) {
            combobox.addElement(list.getCodigopostal());
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start back = new start();
                setVisible(false);
                back.setVisible(true);
                dispose();
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                update();
            }
        });
        submeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField1.getText() == null || textField2.getText() == null || textField3.getText() == null || textField5.getText() == null || textField6.getText() == null) {
                    textField1.setText("Dados incompletos");
                    textField2.setText("Dados incompletos");
                    textField3.setText("Dados incompletos");
                    textField5.setText("Dados incompletos");
                    textField6.setText("Dados incompletos");
                } else {
                    ClienteEntity novoCli = new ClienteEntity();
                    novoCli.setNome(textField1.getText());
                    novoCli.setNomerua(textField2.getText());
                    novoCli.setNumeroporta(Long.valueOf(textField3.getText()));
                    novoCli.setCodigopostal(String.valueOf(ComboBox.getSelectedItem().toString()));
                    novoCli.setContacto(Long.valueOf(textField5.getText()));
                    novoCli.setCc(Long.valueOf(textField6.getText()));

                    ClienteBLL.create(novoCli);
                }
            }
        });
        funcionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card1");
                System.out.println("1");
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card2");

            }
        });

        Lotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card3");
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table1.getSelectedRow();
                ClienteBLL.delete(ClienteBLL.readById(Integer.parseInt(String.valueOf(table1.getValueAt(row, 0)))));
                update();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = dtm.getRowCount() -1; i >= 0; i--){
                    ClienteEntity cliSelecionado = ClienteBLL.readById(Integer.parseInt(String.valueOf(table1.getValueAt(i, 0))));
                    Objects.requireNonNull(cliSelecionado).setNome(String.valueOf(table1.getValueAt(i, 1)));
                    Objects.requireNonNull(cliSelecionado).setNomerua(String.valueOf(table1.getValueAt(i, 2)));
                    Objects.requireNonNull(cliSelecionado).setNumeroporta(Long.valueOf(String.valueOf(table1.getValueAt(i, 3))));
                    Objects.requireNonNull(cliSelecionado).setContacto(Long.valueOf(String.valueOf(table1.getValueAt(i, 5))));
                    Objects.requireNonNull(cliSelecionado).setCc(Long.valueOf(String.valueOf(table1.getValueAt(i, 6))));
                    ClienteBLL.update(cliSelecionado);
                }
            }
        });

    }

    private void update(){
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        List<ClienteEntity> listacliente = ClienteBLL.readAll();

        for (ClienteEntity lista : listacliente) {
            String[] data = {String.valueOf(lista.getIdcliente()), lista.getNome(), lista.getNomerua(), String.valueOf(lista.getNumeroporta()), lista.getCodigopostal(), String.valueOf(lista.getContacto()), String.valueOf(lista.getCc())};
            dtm.addRow(data);
        }
    }

    public JPanel getPanelCli() {
        return panelCli;
    }
}
