package com.extremelf.Forms;

import com.extremelf.BLL.ClienteBLL;
import com.extremelf.BLL.CodpostalBLL;
import com.extremelf.DAL.ClienteEntity;
import com.extremelf.DAL.CodpostalEntity;
import net.bytebuddy.asm.Advice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Cliente extends JFrame {
    private JPanel panelCli;
    private JPanel ClienteP;
    private JPanel panelbutt;
    private JButton button1;
    private JButton Lotes;
    private JButton encomendasButton;
    private JButton funcionariosButton;
    private JButton fornecedorButton;
    private JButton clienteButton;
    private JButton manutençãoButton;
    private JButton tanquesButton;
    private JButton definiçõesButton;
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

    public Cliente() {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.addColumn("Nome");
        dtm.addColumn("Rua");
        dtm.addColumn("Numero da Porta");
        dtm.addColumn("Codigo Postal");
        dtm.addColumn("Contacto");
        dtm.addColumn("Cartão Cidadão");
        DefaultComboBoxModel combobox = (DefaultComboBoxModel) ComboBox.getModel();

        List<CodpostalEntity> listaCodigoPostal = CodpostalBLL.readAll();
        for(CodpostalEntity list: listaCodigoPostal){
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
                for(int i = dtm.getRowCount()-1 ; i >= 0; i--){
                    dtm.removeRow(i);
                }
                List<ClienteEntity> listacliente = ClienteBLL.readAll();

                for (ClienteEntity lista : listacliente) {
                    String[] data = {lista.getNome(), lista.getNomerua(), String.valueOf(lista.getNumeroporta()), lista.getCodigopostal(), String.valueOf(lista.getContacto()), String.valueOf(lista.getCc())};
                    dtm.addRow(data);
                }
            }
        });
        submeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField1.getText() == null || textField2.getText() == null || textField3.getText() == null || textField5.getText() == null || textField6.getText() == null){
                    textField1.setText("Dados incompletos");
                    textField2.setText("Dados incompletos");
                    textField3.setText("Dados incompletos");
                    textField5.setText("Dados incompletos");
                    textField6.setText("Dados incompletos");
                }
                else{
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
    }

    public JPanel getPanelCli() {
        return panelCli;
    }
}
