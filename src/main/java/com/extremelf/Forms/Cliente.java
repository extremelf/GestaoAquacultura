package com.extremelf.Forms;

import com.extremelf.BLL.AguaBLL;
import com.extremelf.BLL.ClienteBLL;
import com.extremelf.DAL.AguaEntity;
import com.extremelf.DAL.ClienteEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
    private JComboBox textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel Nome;
    private JButton submeterButton;
    private JTable table1;
    private JButton refreshButton;

    public Cliente(){
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.addColumn("Nome");
        dtm.addColumn("Rua");
        dtm.addColumn("Numero da Porta");
        dtm.addColumn("Codigo Postal");
        dtm.addColumn("Contacto");
        dtm.addColumn("Cartão Cidadão");

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
                List<ClienteEntity> listacliente = ClienteBLL.readAll();

                for(ClienteEntity lista: listacliente){
                    String[] data = {lista.getNome(),lista.getNomerua(),String.valueOf(lista.getNumeroporta()),lista.getCodigopostal(),String.valueOf(lista.getContacto()),String.valueOf(lista.getCc())};
                    dtm.addRow(data);
                }
            }
        });
    }

    public JPanel getPanelCli(){
        return panelCli;
    }
}
