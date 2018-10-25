/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controle.OQueFazerCliente;
import Entidade.Consumo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Laiza
 */
public class TelaNovoPedido extends JFrame implements ActionListener {
//Por a parte das listagem em um botão que leva para uma janela de consukltas gerais

    private final JPanel painel = new JPanel(new GridBagLayout());
    private JTextField tfPed1;
    private JTextField tfPed2;
    private JTextField tfPed3;
    private JTextField tfPed4;
    private JTextField tfStatus = new JTextField(10);
    private final JComboBox cbComanda = new JComboBox();
    private JTextArea resultado = new JTextArea(20, 40);

    private final JButton btnMais = new JButton("Mais Pedidos");
    private final JButton btEnviarPedido = new JButton("Enviar Pedido");
    private ArrayList<Consumo> p = new ArrayList<>();
    ArrayList<String> lista;
    ctrProd controle = new ctrProd();
    

    String ax = "";

    public TelaNovoPedido() {
        super("Novo Pedido");
        this.inicializaArray();
        this.inicializaText();
        this.inicializaCombo();
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 45, 30, 45),
                BorderFactory.createEmptyBorder()));
        JScrollPane scroll2 = new JScrollPane(painel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        resultado.setEditable(false);

        //this.cbComanda.addItem("1");
        //this.cbStatus.addItem("Pós-graduação");
        //this.cbStatus.addItem("Professor");

        /*adicionarComponente(painel, new JLabel("Código"), 0, 0, 1, 1);
        adicionarComponente(painel, tfCodigo, 1, 0, 1, 1);*/
        adicionarComponente(painel, new JLabel("Pedidos"), 0, 2, 1, 1);
        //adicionarComponente(painel, tfNome, 1, 1, 1, 1);

        adicionarComponente(painel, tfPed1, 0, 3, 1, 1);
        adicionarComponente(painel, tfPed2, 0, 4, 1, 1);
        adicionarComponente(painel, tfPed3, 0, 5, 1, 1);
        adicionarComponente(painel, tfPed4, 0, 6, 1, 1);
        adicionarComponente(painel, new JLabel("Mesa/Comanda"), 0, 0, 1, 1);
        adicionarComponente(painel, cbComanda, 0, 1, 1, -90);//Não deve ser um campo de texto

        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, scroll, 0, 9, 1, 1);//Não deve ser um campo de texto

        btnMais.addActionListener(this);
        btnMais.setBackground(Color.LIGHT_GRAY);
        adicionarComponente(painel, btnMais, 0, 8, 1, 3);

        //painel.add(this.btnMais);
        //this.btnMais.setSize(new Dimension(200, 25));
        //this.btnMais.setLocation(0, 350);
        //painel.add(this.btEnviarPedido);
        //this.btEnviarPedido.setSize(new Dimension(200, 25));
        //this.btEnviarPedido.setLocation(0, 380);
        btEnviarPedido.addActionListener(this);
        btEnviarPedido.setBackground(Color.LIGHT_GRAY);
        adicionarComponente(painel, btEnviarPedido, 0, 10, 1, 3);

        super.add(painel);
        super.pack();
        // super.setSize(1000, 500);
        this.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);

    }

    public void inicializaText() {
        tfPed1 = new Java2sAutoTextField(lista);
        tfPed2 = new Java2sAutoTextField(lista);
        tfPed3 = new Java2sAutoTextField(lista);
        tfPed4 = new Java2sAutoTextField(lista);
        tfPed1.setEditable(true);
        tfPed2.setEditable(true);
        tfPed3.setEditable(true);
        tfPed4.setEditable(true);

        this.tfPed1.setText("");
        this.tfPed2.setText("");
        this.tfPed3.setText("");
        this.tfPed4.setText("");

    }

    public void inicializaCombo() {//Coloca as comandas cadastradas no combo
        controle.lerComandas();
        for (int i = 0; i < controle.listaIDComanda.size(); i++) {
            this.cbComanda.addItem("" + controle.listaIDComanda.get(i));
        }
    }

    public void inicializaArray() {
        lista = new ArrayList<>();
        for (int i = 0; i < controle.listaProdutos.size(); i++) {
            lista.add(controle.listaProdutos.get(i).getNomeProduto());
        }
    }

    public String pegaTextoSeTiver(ArrayList<Consumo> listaPedidos) {
        int num;
        ctrProd c = new ctrProd();
        String x = "";
        int y;
        if (tfPed1.getText().length() > 0) {

            y = c.achaProduto(tfPed1.getText());

            if (y > -1) {
                x += tfPed1.getText() + "\n";
                //System.out.println("Tamanho lista: " + c.listaProdutos.size());
                listaPedidos.add(new Consumo(tfPed1.getText(), c.listaProdutos.get(y).getValor()));
            }

        }
        if (tfPed2.getText().length() > 0) {
            y = c.achaProduto(tfPed1.getText());
            if (y > -1) {
                x += tfPed2.getText() + "\n";
                listaPedidos.add(new Consumo(tfPed2.getText(), c.listaProdutos.get(y).getValor()));
            }
            //num = Integer.parseInt(qt2.getText());

        }
        if (tfPed3.getText().length() > 0) {
            y = c.achaProduto(tfPed1.getText());
            if (y > -1) {
                x += tfPed3.getText() + "\n";
                listaPedidos.add(new Consumo(tfPed3.getText(), c.listaProdutos.get(y).getValor()));
            }
            //num = Integer.parseInt(qt3.getText());

        }
        if (tfPed4.getText().length() > 0) {
            y = c.achaProduto(tfPed1.getText());
            if (y > -1) {
                x += tfPed4.getText() + "\n";
                listaPedidos.add(new Consumo(tfPed4.getText(), c.listaProdutos.get(y).getValor()));
            }
            //num = Integer.parseInt(qt4.getText());

        }

        return x;
    }

    public void limpaTF() {
        tfPed1.setText("");
        tfPed2.setText("");
        tfPed3.setText("");
        tfPed4.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        JButton botao = (JButton) e.getSource();
        if (botao.equals(this.btEnviarPedido)) {
            OQueFazerCliente cl = new OQueFazerCliente();
            ax += this.pegaTextoSeTiver(p);
            try {
                cl.mandarPedido((String) cbComanda.getSelectedItem(), p);
            } catch (IOException ex) {
                Logger.getLogger(TelaNovoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.limpaTF();
            this.resultado.setText(ax);
            this.dispose();
        }
        if (botao.equals(this.btnMais)) {

            ax += this.pegaTextoSeTiver(p);
            this.resultado.setText(ax);
            this.limpaTF();

        }

    }

    public void adicionarComponente(JPanel painel, JComponent componente, int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 100, 5, 100);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }

    /*public static void main(String a[]) {
        new TelaNovoPedido();
    }*/
}
