package com.extremelf.Forms;

import com.extremelf.BLL.*;
import com.extremelf.DAL.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

public class Cliente extends JFrame {
    private JPanel panelCli;
    private JPanel ClienteP;
    private JButton tanquesButton;
    private JButton manutencaoButton;
    private JButton clienteButton;
    private JButton fornecedorButton;
    private JButton funcionariosButton;
    private JButton encomendasButton;
    private JPanel panelbutt;
    private JButton Lotes;
    private JButton definicoes;
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
    private JPanel listarEncomendasCPanel;
    private JButton updateEncomenda;
    private JButton delEncomenda;
    private JButton refreshEncomenda;
    private JTable tableEncomendas;
    private JComboBox comboBoxNomeCliente;
    private JComboBox comboBoxFuncinario;
    private JTextField precototalEncomenda;
    private JButton submeterEncomenda;
    private JTextField DataEncomendaC;
    private JButton deleteTanque;
    private JButton refreshTanque;
    private JButton updateTanque;
    private JComboBox comboBoxIDfuncTanque;
    private JComboBox comboBoxIdAguaTanque;
    private JTextField fasetanque;
    private JTextField LoteInseridoTanque;
    private JTextField LitrosCubicosTanque;
    private JButton submitTanque;
    private JPanel criarTanque;
    private JPanel tabelaTanque;
    private JTable Tanquetable;
    private JPanel tableFuncionario;
    private JTable tablefuncionario;
    private JButton deleteFunc;
    private JButton refreshFunc;
    private JButton updateFunc;
    private JPanel criarfuncionario;
    private JComboBox comboBoxFuncCargo;
    private JTextField funcNome;
    private JTextField NomeRuaAddFunc;
    private JTextField numPortaAddFunc;
    private JComboBox codPOstalAddFunc;
    private JTextField contactoAddFunc;
    private JTextField CCAddFunc;
    private JButton submitFunc;
    DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
    DefaultTableModel dtmEncomendas = (DefaultTableModel) tableEncomendas.getModel();
    DefaultTableModel dtmTanque = (DefaultTableModel) Tanquetable.getModel();
    DefaultTableModel dtmFuncionario = (DefaultTableModel) tablefuncionario.getModel();
    DefaultComboBoxModel comboBoxCargoFuncionario =(DefaultComboBoxModel) comboBoxFuncCargo.getModel();
    DefaultComboBoxModel comboBoxCodPostalFuncionario = (DefaultComboBoxModel) codPOstalAddFunc.getModel();
    DefaultComboBoxModel comboBoxIDAguaTanque = (DefaultComboBoxModel) comboBoxIdAguaTanque.getModel();
    DefaultComboBoxModel comboBoxIDFuncionarioTanque = (DefaultComboBoxModel) comboBoxIDfuncTanque.getModel();
    DefaultComboBoxModel comboBoxNomeCLiente = (DefaultComboBoxModel) comboBoxNomeCliente.getModel();
    DefaultComboBoxModel comboBOxFuncionario = (DefaultComboBoxModel) comboBoxFuncinario.getModel();

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


        /*
        ------------------------------------Encomenda Relative--------------------------------------
         */


        List<ClienteEntity> listarclientesnome = ClienteBLL.readAll();
        for (ClienteEntity list : listarclientesnome){
            comboBoxNomeCLiente.addElement(list.getNome());
        }

        List<FuncionarioEntity> listarfuncionariosID = FuncionarioBLL.readAll();
        for (FuncionarioEntity list : listarfuncionariosID){
            comboBOxFuncionario.addElement(list.getIdfuncionario());
        }


        dtmEncomendas.addColumn("IdEncomenda");
        dtmEncomendas.addColumn("IdFuncionário");
        dtmEncomendas.addColumn("IdCliente");
        dtmEncomendas.addColumn("Data");
        dtmEncomendas.addColumn("Preço Total");



        submeterEncomenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (DataEncomendaC.getText()==null || precototalEncomenda.getText()==null){
                    DataEncomendaC.setText("Dados incompletos");
                    precototalEncomenda.setText("Dados incompletos");
                } else{
                    EncomendacEntity encc = new EncomendacEntity();
                    encc.setIdfuncionario(Long.valueOf(comboBOxFuncionario.getSelectedItem().toString()));
                    encc.setIdcliente(Long.valueOf(comboBoxNomeCliente.getSelectedItem().toString()));
                    encc.setData(Time.valueOf(DataEncomendaC.getText()));/*???????????????????????????????*/
                    encc.setPrecototal(Long.valueOf(precototalEncomenda.getText()));

                    EncomendaCBLL.create(encc);
                }
            }
        });

        delEncomenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableEncomendas.getSelectedRow();
                EncomendaCBLL.delete(EncomendaCBLL.readByIdEncomendaC(Integer.parseInt(String.valueOf(table1.getValueAt(row, 0)))));
                update();
            }
        });
        refreshEncomenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEncomenda();
            }
        });

        updateEncomenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = dtmEncomendas.getRowCount() -1; i >= 0; i--){
                    EncomendacEntity encomendaselecionada = EncomendaCBLL.readByIdEncomendaC(Integer.parseInt(String.valueOf(tableEncomendas.getValueAt(i, 0))));
                    Objects.requireNonNull(encomendaselecionada).setData(Time.valueOf(String.valueOf(tableEncomendas.getValueAt(i, 1))));
                    Objects.requireNonNull(encomendaselecionada).setPrecototal(Long.valueOf(String.valueOf(tableEncomendas.getValueAt(i, 2))));

                    EncomendaCBLL.update(encomendaselecionada);
                }
            }
        });

        /*
        --------------------------------------Tanque relative----------------------------------

      -----------------------------------------------------------------------------------------
         */
        List<AguaEntity> listaAgua = AguaBLL.readAll();
        for (AguaEntity list : listaAgua) {
            comboBoxIDAguaTanque.addElement(list.getIdagua());
        }
        List<FuncionarioEntity> listaFuncTanque = FuncionarioBLL.readAll();
        for (FuncionarioEntity list : listaFuncTanque) {
            comboBoxIDFuncionarioTanque.addElement(list.getIdfuncionario());
        }

        dtmTanque.addColumn("IdTanque");
        dtmTanque.addColumn("IdAgua");
        dtmTanque.addColumn("IdFuncionario");
        dtmTanque.addColumn("Fase Tanque");
        dtmTanque.addColumn("Lote Inserido");
        dtmTanque.addColumn("Litros Cúbicos");

        refreshTanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTanque();
            }
        });

        deleteTanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Tanquetable.getSelectedRow();
                TanqueBLL.delete(TanqueBLL.readByIdTanque(Integer.parseInt(String.valueOf(Tanquetable.getValueAt(row, 0)))));
                update();
            }
        });

        updateTanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = dtmTanque.getRowCount() -1; i >= 0; i--){
                    TanqueEntity tanqueselecionado = TanqueBLL.readByIdTanque(Integer.parseInt(String.valueOf(Tanquetable.getValueAt(i, 0))));
                    Objects.requireNonNull(tanqueselecionado).setFasetanque(String.valueOf(Tanquetable.getValueAt(i, 3)));
                    Objects.requireNonNull(tanqueselecionado).setLoteinserido(Long.valueOf(String.valueOf(Tanquetable.getValueAt(i, 4))));
                    Objects.requireNonNull(tanqueselecionado).setTamanholitroscubicos(Long.valueOf(String.valueOf(Tanquetable.getValueAt(i, 5))));
                    TanqueBLL.update(tanqueselecionado);
                }
            }
        });

        submitTanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (LoteInseridoTanque.getText()==null || fasetanque.getText()==null || LitrosCubicosTanque.getText()==null){
                    LoteInseridoTanque.setText("Dados incompletos");
                    fasetanque.setText("Dados incompletos");
                    precototalEncomenda.setText("Dados incompletos");
                } else{
                    TanqueEntity tank = new TanqueEntity();
                    tank.setIdagua(Long.valueOf(comboBoxIDAguaTanque.getSelectedItem().toString()));
                    tank.setIdfuncionario(Long.valueOf(comboBoxIDFuncionarioTanque.getSelectedItem().toString()));
                    tank.setFasetanque(String.valueOf(fasetanque.getText()));/*???????????????????????????????*/
                    tank.setLoteinserido(Long.valueOf(LoteInseridoTanque.getText()));
                    tank.setTamanholitroscubicos(Long.valueOf(LoteInseridoTanque.getText()));
                    TanqueBLL.create(tank);
                }
            }
        });

/*
------------------------------------------------------------------------------------------------
 */

        /*
--------------------------------------Funcionário Relative-----------------------------------------------------------------------
         */

        List<CargoEntity> listaCargos = CargoBLL.readAll();
        for (CargoEntity list : listaCargos) {
            comboBoxCargoFuncionario.addElement(list.getDescricao());
        }

        dtmFuncionario.addColumn("IdFuncionario");
        dtmFuncionario.addColumn("Nome");
        dtmFuncionario.addColumn("IdCargo");
        dtmFuncionario.addColumn("Codigo Postal");
        dtmFuncionario.addColumn("Nome Rua");
        dtmFuncionario.addColumn("Numero Porta");
        dtmFuncionario.addColumn("Contacto");
        dtmFuncionario.addColumn("CC");

        refreshFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFuncionario();
            }
        });

        deleteFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablefuncionario.getSelectedRow();
                FuncionarioBLL.delete(FuncionarioBLL.readById(Integer.parseInt(String.valueOf(tablefuncionario.getValueAt(row, 0)))));
                update();
            }
        });

        updateFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = dtmFuncionario.getRowCount() -1; i >= 0; i--){
                    FuncionarioEntity funcionarioselecionado = FuncionarioBLL.readById(Integer.parseInt(String.valueOf(tablefuncionario.getValueAt(i, 0))));
                    Objects.requireNonNull(funcionarioselecionado).setNome(String.valueOf(tablefuncionario.getValueAt(i, 1)));
                    Objects.requireNonNull(funcionarioselecionado).setIdcargo(Long.valueOf(String.valueOf(tablefuncionario.getValueAt(i, 2))));
                    Objects.requireNonNull(funcionarioselecionado).setCodigopostal(String.valueOf(tablefuncionario.getValueAt(i, 3)));
                    Objects.requireNonNull(funcionarioselecionado).setNomerua(String.valueOf(tablefuncionario.getValueAt(i, 4)));
                    Objects.requireNonNull(funcionarioselecionado).setNumeroporta(Long.valueOf(String.valueOf(tablefuncionario.getValueAt(i, 5))));
                    Objects.requireNonNull(funcionarioselecionado).setContacto(Long.valueOf(String.valueOf(tablefuncionario.getValueAt(i, 6))));
                    Objects.requireNonNull(funcionarioselecionado).setCc(Long.valueOf(String.valueOf(tablefuncionario.getValueAt(i, 7))));
                    FuncionarioBLL.update(funcionarioselecionado);
                }
            }
        });

        submitFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (funcNome.getText()==null || NomeRuaAddFunc.getText()==null || numPortaAddFunc.getText()==null || contactoAddFunc.getText()==null || CCAddFunc.getText()==null){
                    funcNome.setText("Dados incompletos");
                    NomeRuaAddFunc.setText("Dados incompletos");
                    numPortaAddFunc.setText("Dados incompletos");
                    contactoAddFunc.setText("Dados incompletos");
                    CCAddFunc.setText("Dados incompletos");
                } else{
                    FuncionarioEntity newfunc = new FuncionarioEntity();
                    newfunc.setIdcargo(Long.valueOf(comboBoxFuncCargo.getSelectedItem().toString()));
                    newfunc.setCodigopostal(String.valueOf(codPOstalAddFunc.getSelectedItem().toString()));
                    newfunc.setNome(String.valueOf(funcNome.getText()));/*???????????????????????????????*/
                    newfunc.setNomerua(String.valueOf(NomeRuaAddFunc.getText()));
                    newfunc.setNumeroporta(Long.valueOf(numPortaAddFunc.getText()));
                    newfunc.setContacto(Long.valueOf(contactoAddFunc.getText()));
                    newfunc.setCc(Long.valueOf(CCAddFunc.getText()));
                    FuncionarioBLL.create(newfunc);
                }
            }
        });




/*
--------------------------------------------------------------------------------------------------------------------------------
 */


        definicoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        encomendasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(Cards1, "Card6");
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
    private void updateEncomenda(){
        for(int i = dtmEncomendas.getRowCount()-1 ; i >= 0; i--){
            dtmEncomendas.removeRow(i);
        }
        List<EncomendacEntity> encomendaC = EncomendaCBLL.readAll();

        for(EncomendacEntity lista : encomendaC){
            String [] data = {String.valueOf(lista.getIdencomendac()), String.valueOf(lista.getIdfuncionario()), String.valueOf(lista.getIdcliente()), String.valueOf(lista.getData()), String.valueOf(lista.getPrecototal())
            };
            dtmEncomendas.addRow(data);
        }
    }
    private void updateTanque(){

        for(int i = dtmTanque.getRowCount()-1 ; i >= 0; i--){
            dtmTanque.removeRow(i);
        }
        List<TanqueEntity> tanque = TanqueBLL.readAll();

        for(TanqueEntity lista : tanque){
            String [] data = {String.valueOf(lista.getIdtanque()), String.valueOf(lista.getIdagua()), String.valueOf(lista.getIdfuncionario()), String.valueOf(lista.getFasetanque()), String.valueOf(lista.getLoteinserido()), String.valueOf(lista.getTamanholitroscubicos())
            };
            dtmTanque.addRow(data);
        }

    }
    private void updateFuncionario(){

        for(int i = dtmFuncionario.getRowCount()-1 ; i >= 0; i--){
            dtmFuncionario.removeRow(i);
        }
        List<FuncionarioEntity> funcionario = FuncionarioBLL.readAll();

        for(FuncionarioEntity lista : funcionario){
            String [] data = {String.valueOf(lista.getIdfuncionario()), String.valueOf(lista.getNome()), String.valueOf(lista.getIdcargo()),
                    String.valueOf(lista.getCodigopostal()), String.valueOf(lista.getNomerua()),
                    String.valueOf(lista.getNumeroporta()), String.valueOf(lista.getContacto()),String.valueOf(lista.getCc())
            };
            dtmFuncionario.addRow(data);
        }

    }



    public JPanel getPanelCli() {
        return panelCli;
    }


}
