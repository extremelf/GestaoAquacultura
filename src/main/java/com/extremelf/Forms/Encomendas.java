package com.extremelf.Forms;

import com.extremelf.BLL.EncomendaCBLL;
import com.extremelf.DAL.EncomendacEntity;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Encomendas extends JFrame {
    private JPanel panelEnco;
    private JPanel panelbutt;
    private JButton refreshButton;
    private JButton button2;
    private JButton encomendasButton;
    private JButton funcionariosButton;
    private JButton fornecedorButton;
    private JButton clienteButton;
    private JButton manutençãoButton;
    private JButton tanquesButton;
    private JButton definiçõesButton;
    private JButton backButton;
    private JPanel info;
    private JButton confirmarButton;
    private JButton negarButton;
    private JTable Encomendas;
    private JPanel encomendasP;


    public Encomendas(){



        DefaultTableModel dtm = (DefaultTableModel) Encomendas.getModel();
        dtm.addColumn("IdEncomenda");
        dtm.addColumn("IdFuncionário");
        dtm.addColumn("IdCliente");
        dtm.addColumn("Data");
        dtm.addColumn("Preço Total");


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start back = new start();
                setVisible(false);
                back.setVisible(true);


            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = dtm.getRowCount()-1 ; i >= 0; i--){
                    dtm.removeRow(i);
                }
                List<EncomendacEntity> encomendaC = EncomendaCBLL.readAll();

               for(EncomendacEntity lista : encomendaC){
                   String [] data = {String.valueOf(lista.getIdencomendac()), String.valueOf(lista.getIdfuncionario()), String.valueOf(lista.getIdcliente()), String.valueOf(lista.getData()), String.valueOf(lista.getPrecototal())
                   };
                   dtm.addRow(data);
               }

            }
        });




    }

    public JPanel getPanelEnco() {
        return panelEnco;
    }
}
