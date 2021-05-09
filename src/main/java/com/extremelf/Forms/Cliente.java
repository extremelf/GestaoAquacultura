package com.extremelf.Forms;

import com.extremelf.BLL.*;
import com.extremelf.DAL.*;
import org.jdesktop.swingx.JXMapKit;

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

    public JPanel getPanelCli() {
        return panelCli;
    }
}
