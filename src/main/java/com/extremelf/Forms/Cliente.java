package com.extremelf.Forms;

import com.extremelf.BLL.*;
import com.extremelf.DAL.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
    private JPanel Encomendas;
    private JPanel Tanques;
    private JPanel Definicoes;
    private JButton refreshButtonFornecedor;
    private JButton updateButtonFornecedor;
    private JButton deleteButtonFornecedor;
    private JButton submeterButtonFornecedor;
    private JTextField NomeFornecedor;
    private JTextField RuaFornecedor;
    private JTextField numeroPortaFornecedor;
    private JComboBox codigoPostalFornecedor;
    private JTextField contactoFornecedor;
    private JPanel AdicionarFornecedor;
    private JTable tabelaFornecedores;
    private JPanel Manutencao;
    private JComboBox tipodeAvariaManutencao;
    private JComboBox funcionarioManutencao;
    private JComboBox tanqueManutencao;
    private JTextField dataManutencao;
    private JTextField descricaoManutencao;
    private JButton refreshButtonManutencao;
    private JButton deleteButtonManutencao;
    private JButton submeterManutencao;
    private JTable table3;
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
    private JTable tabelaLotes;
    private JButton refreshButtonLotes;
    private JButton deleteButtonLotes;
    private JButton updateButtonLotes;
    private JTable table5;
    private JButton refreshButton1;
    private JButton deleteButton1;
    private JButton updateButton1;
    private JTable tabelaManutencao;
    private JButton submeterLotes;
    private JComboBox comboboxEspecieLotes;
    private JComboBox comboboxFuncionarioLotes;
    private JComboBox comboboxClienteLotes;
    private JSpinner quantidadeLotes;

    DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
    DefaultTableModel tabelaFornecedoresModel = (DefaultTableModel) tabelaFornecedores.getModel();
    DefaultTableModel tabelaManutencaoModel = (DefaultTableModel) tabelaManutencao.getModel();
    DefaultTableModel tabelaLotesModel = (DefaultTableModel) tabelaLotes.getModel();


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


       
        tabelaFornecedoresModel.addColumn("Id");
        tabelaFornecedoresModel.addColumn("Nome");
        tabelaFornecedoresModel.addColumn("Rua");
        tabelaFornecedoresModel.addColumn("Numero da Porta");
        tabelaFornecedoresModel.addColumn("Codigo Postal");
        tabelaFornecedoresModel.addColumn("Contacto");

        tabelaManutencaoModel.addColumn("Id Tipo de Avaria");
        tabelaManutencaoModel.addColumn("Id Tanque");
        tabelaManutencaoModel.addColumn("Id Funcionario");
        tabelaManutencaoModel.addColumn("Data");
        tabelaManutencaoModel.addColumn("Descrição");

        tabelaLotesModel.addColumn("Id");
        tabelaLotesModel.addColumn("Especie");
        tabelaLotesModel.addColumn("Funcionario");
        tabelaLotesModel.addColumn("Cliente");
        tabelaLotesModel.addColumn("Quantidade");


        //Ler listas para combobox--------------------------------------------------------------------------
        List<CodpostalEntity> listaCodigoPostal = CodpostalBLL.readAll();
        List<EspecieEntity> listaEspecies = EspecieBLL.readAll();
        List<TanqueEntity> listaTanques = TanqueBLL.readAll();
        List<FuncionarioEntity> listaFuncionarios = FuncionarioBLL.readAll();
        List<TipoDeAvariaEntity> listaDeAvarias = TipoDeAvariaBLL.readAll();
        List<ClienteEntity> listaClientes = ClienteBLL.readAll();
        //--------------------------------------------------------------------------------------------------

        //Models de combobox--------------------------------------------------------------------------------
        DefaultComboBoxModel boxTanque = (DefaultComboBoxModel) tanqueManutencao.getModel();
        DefaultComboBoxModel boxFuncionario = (DefaultComboBoxModel) funcionarioManutencao.getModel();
        DefaultComboBoxModel boxTipoDeAvaria = (DefaultComboBoxModel) tipodeAvariaManutencao.getModel();
        DefaultComboBoxModel combobox = (DefaultComboBoxModel) ComboBox.getModel();
        DefaultComboBoxModel comboboxFornecedor = (DefaultComboBoxModel) codigoPostalFornecedor.getModel();
        DefaultComboBoxModel comboboxEspecieLote = (DefaultComboBoxModel) comboboxEspecieLotes.getModel();
        DefaultComboBoxModel comboboxFunncionarioLote = (DefaultComboBoxModel) comboboxFuncionarioLotes.getModel();
        DefaultComboBoxModel comboboxClienteLote = (DefaultComboBoxModel) comboboxClienteLotes.getModel();

        //--------------------------------------------------------------------------------------------------

        //Adicionar CodigosPostais aos respetivos ComboBox -------------------------------------------------

        for (CodpostalEntity list : listaCodigoPostal) {
            combobox.addElement(list.getCodigopostal());
            comboboxFornecedor.addElement(list.getCodigopostal());
        }
        //--------------------------------------------------------------------------------------------------


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


        //Adicionar combobox Lotes--------------------------------------------------------------------------
        for(EspecieEntity lista: listaEspecies){
            comboboxEspecieLote.addElement(lista.getIdespecie());
        }
        for(ClienteEntity lista: listaClientes){
            comboboxClienteLote.addElement(lista.getIdcliente());
        }
        for(FuncionarioEntity lista: listaFuncionarios){
            comboboxFunncionarioLote.addElement(lista.getIdfuncionario());
        }
        //--------------------------------------------------------------------------------------------------

        //Adicionar Combobox -------------------------------------------------------------------------------


        for(TanqueEntity lista: listaTanques){
            boxTanque.addElement(lista.getIdtanque());
        }
        for(FuncionarioEntity lista: listaFuncionarios){
            boxFuncionario.addElement(lista.getIdfuncionario());
        }
        for(TipoDeAvariaEntity lista: listaDeAvarias){
            boxTipoDeAvaria.addElement(lista.getIdtipodeavaria());
        }
        //--------------------------------------------------------------------------------------------------

        //Botões de alterar Painel -----------------------------------------
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
        fornecedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1,"Card4");
            }
        });
        manutencaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1,"Card5");
            }
        });
        encomendasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card6");
            }
        });
        tanquesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card7");
            }
        });
        definicoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(Cards1, "Card8");
            }
        });
        //-------------------------------------------------------------------

        //Botões Clientes ----------------------------------------------------------------------------------
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
                    novoCli.setCodigopostal(String.valueOf(ComboBox.getSelectedItem()));
                    novoCli.setContacto(Long.valueOf(textField5.getText()));
                    novoCli.setCc(Long.valueOf(textField6.getText()));

                    ClienteBLL.create(novoCli);
                }
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateListaClientes();
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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table1.getSelectedRow();
                ClienteBLL.delete(ClienteBLL.readById(Integer.parseInt(String.valueOf(table1.getValueAt(row, 0)))));
                updateListaClientes();
            }
        });
        //--------------------------------------------------------------------------------------------------

        //Botões Fornecedor -------------------------------------------------------------------------------
        submeterButtonFornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(NomeFornecedor.getText() == null || numeroPortaFornecedor.getText() == null || RuaFornecedor.getText() == null || contactoFornecedor.getText() == null){
                    NomeFornecedor.setText("Dados incompletos");
                    numeroPortaFornecedor.setText("Dados incompletos");
                    RuaFornecedor.setText("Dados incompletos");
                    contactoFornecedor.setText("Dados incompletos");
                }
                else{
                    FornecedorEntity novoFornecedor = new FornecedorEntity();
                    novoFornecedor.setNomeempresafornecedor(NomeFornecedor.getText());
                    novoFornecedor.setNumeroporta(Long.valueOf(numeroPortaFornecedor.getText()));
                    novoFornecedor.setNomerua(RuaFornecedor.getText());
                    novoFornecedor.setCodigopostal(String.valueOf(codigoPostalFornecedor.getSelectedItem()));
                    novoFornecedor.setContacto(Long.valueOf(contactoFornecedor.getText()));
                    FornecedorBLL.create(novoFornecedor);
                }
                updateListaFornecedores();
            }
        });
        refreshButtonFornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateListaFornecedores();
            }
        });
        updateButtonFornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = tabelaFornecedoresModel.getRowCount() - 1; i>=0;i--){
                    FornecedorEntity forSelecionado = FornecedorBLL.readById(Integer.parseInt(String.valueOf(tabelaFornecedores.getValueAt(i,0))));
                    Objects.requireNonNull(forSelecionado).setNomeempresafornecedor(String.valueOf(tabelaFornecedores.getValueAt(i,1)));
                    Objects.requireNonNull(forSelecionado).setNomerua(String.valueOf(tabelaFornecedores.getValueAt(i,2)));
                    Objects.requireNonNull(forSelecionado).setNumeroporta(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,3))));
                    Objects.requireNonNull(forSelecionado).setCodigopostal(String.valueOf(tabelaFornecedores.getValueAt(i,4)));
                    Objects.requireNonNull(forSelecionado).setContacto(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,5))));
                    FornecedorBLL.update(forSelecionado);
                }
            }
        });
        deleteButtonFornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tabelaFornecedores.getSelectedRow();
                FornecedorBLL.delete(FornecedorBLL.readById(Integer.parseInt(String.valueOf(tabelaFornecedores.getValueAt(row,0)))));
                updateListaFornecedores();
            }
        });
        //--------------------------------------------------------------------------------------------------

        //Botões Manutenção---------------------------------------------------------------------------------
        submeterManutencao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(tipodeAvariaManutencao.getSelectedItem() == null || tanqueManutencao.getSelectedItem() == null || funcionarioManutencao.getSelectedItem() == null || dataManutencao.getText() == null || descricaoManutencao.getText() == null){

                }
                else{
                    ReportaavariaEntity novaManutencao = new ReportaavariaEntity();

                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                    Time atual = null;
                    try {
                        atual = new Time(formatter.parse(dataManutencao.getText()).getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    novaManutencao.setIdtipodeavaria(Long.parseLong(tipodeAvariaManutencao.getSelectedItem().toString()));
                    novaManutencao.setIdfuncionario(Long.parseLong(funcionarioManutencao.getSelectedItem().toString()));
                    novaManutencao.setIdtanque(Long.parseLong(tanqueManutencao.getSelectedItem().toString()));
                    novaManutencao.setData(atual);
                    novaManutencao.setDescricao(descricaoManutencao.getText());
                }
            }
        });
        refreshButtonManutencao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateListaManutencao();
            }
        });


        encomendasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(Cards1, "Card6");
            }
        });

        updateButton.addActionListener(new ActionListener() {

        deleteButtonManutencao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tabelaManutencao.getSelectedRow();
                ReportaAvariaBLL.delete(ReportaAvariaBLL.readById(((Integer) tabelaManutencao.getValueAt(row,0)), ((Integer) tabelaManutencao.getValueAt(row,1)), ((Integer) tabelaManutencao.getValueAt(row,2))));
                updateListaManutencao();
            }
        });
        //--------------------------------------------------------------------------------------------------

        //Botões Lotes--------------------------------------------------------------------------------------
        submeterLotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            if(comboboxClienteLotes.getSelectedItem().toString()==null || comboboxEspecieLotes.getSelectedItem().toString() == null || comboboxFuncionarioLotes.getSelectedItem().toString() == null || quantidadeLotes == null){

            }
            else{
                LoteEntity novoLote = new LoteEntity();
                novoLote.setIdcliente(Long.valueOf(comboboxClienteLotes.getSelectedItem().toString()));
                novoLote.setIdespecie(Long.valueOf(comboboxEspecieLotes.getSelectedItem().toString()));
                novoLote.setIdfuncionario(Long.valueOf(comboboxFuncionarioLotes.getSelectedItem().toString()));
                novoLote.setQuantidade(Long.valueOf(quantidadeLotes.getValue().toString()));
                LoteBLL.create(novoLote);
                updateListaLotes();
            }
            }
        });
        refreshButtonLotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateListaLotes();
            }
        });
        updateButtonLotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = tabelaLotesModel.getRowCount()-1; i>=0;i--){
                    LoteEntity loteupdate = LoteBLL.readById(Integer.parseInt(String.valueOf(tabelaFornecedores.getValueAt(i,0))));
                    Objects.requireNonNull(loteupdate).setIdespecie(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,1))));
                    Objects.requireNonNull(loteupdate).setIdfuncionario(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,2))));
                    Objects.requireNonNull(loteupdate).setIdcliente(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,3))));
                    Objects.requireNonNull(loteupdate).setQuantidade(Long.valueOf(String.valueOf(tabelaFornecedores.getValueAt(i,4))));
                    LoteBLL.update(loteupdate);
                }
                updateListaLotes();
            }
        });
        deleteButtonLotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tabelaLotes.getSelectedRow();
                LoteBLL.delete(LoteBLL.readById(Integer.parseInt(String.valueOf(tabelaLotes.getValueAt(row,0)))));
                updateListaLotes();
            }
        });
        //--------------------------------------------------------------------------------------------------
    }

    private void updateListaLotes(){
        for(int i = tabelaLotesModel.getRowCount() - 1; i>= 0; i--){
            tabelaLotesModel.removeRow(i);
        }
        List<LoteEntity> listaLotes = LoteBLL.readAll();

        for(LoteEntity lista: listaLotes){
            String[] data = {String.valueOf(lista.getIdlote()),String.valueOf(lista.getIdespecie()),String.valueOf(lista.getIdfuncionario()),String.valueOf(lista.getIdcliente()),String.valueOf(lista.getQuantidade())};
            tabelaLotesModel.addRow(data);
        }


    }

    private void updateListaManutencao(){
        for(int i = tabelaManutencaoModel.getRowCount() - 1; i>=0; i--){
            tabelaManutencaoModel.removeRow(i);
        }

        List<ReportaavariaEntity> listaManutencao = ReportaAvariaBLL.readAll();

        for(ReportaavariaEntity lista: listaManutencao){
            String[] data = {String.valueOf(lista.getIdtipodeavaria()),String.valueOf(lista.getIdtanque()),String.valueOf(lista.getIdfuncionario()),lista.getData().toString(),lista.getDescricao()};
            tabelaManutencaoModel.addRow(data);
        }
    }

    private void updateListaFornecedores(){
        for (int i = tabelaFornecedoresModel.getRowCount()-1; i >= 0; i--){
            tabelaFornecedoresModel.removeRow(i);
        }

        List<FornecedorEntity> listaFornecedores = FornecedorBLL.readAll();

        for(FornecedorEntity lista: listaFornecedores){
            String[] data = {String.valueOf(lista.getIdfornecedor()),lista.getNomeempresafornecedor(), lista.getNomerua(),String.valueOf(lista.getNumeroporta()), lista.getCodigopostal(),String.valueOf(lista.getContacto())};
            tabelaFornecedoresModel.addRow(data);
        }
    }



    private void updateListaClientes(){
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
