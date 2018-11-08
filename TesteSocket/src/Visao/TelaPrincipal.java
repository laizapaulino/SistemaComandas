/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Laiza
 */
public class TelaPrincipal extends JFrame implements ActionListener, WindowListener {

    private ctrProd controleProd;

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JButton btnAtualiza = new JButton("Receber Atualizações do Servidor");
    private final JButton btnNovoPedido = new JButton("Novo Pedido");
    private final JButton btnVerComanda = new JButton("Ver Comandas Abertas");
    OQueFazerCliente cli;
    private JTextField tfIP = new JTextField(30);
    private final JButton btnConecta = new JButton("Conecta");

    private boolean status = false;

    public void HabilitaDesabilita() {
        this.btnNovoPedido.setEnabled(this.status);
        this.btnVerComanda.setEnabled(this.status);
    }

    public TelaPrincipal() {
        super("Sistema de Pedidos");

        super.setExtendedState((int) JFrame.TOP_ALIGNMENT);
        controleProd = new ctrProd();
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(200, 200, 200, 200),
                BorderFactory.createEmptyBorder()));
        painel.setBackground(Color.white);

        this.btnConecta.setSize(new Dimension(300, 25));
        btnConecta.setBackground(Color.lightGray);

        /* this.btnAtualiza.addActionListener(this);
        btnAtualiza.setSize(new Dimension(300, 25));
        btnAtualiza.setBackground(Color.lightGray);
         */
        this.btnNovoPedido.addActionListener(this);
        btnNovoPedido.setSize(new Dimension(300, 25));
        btnNovoPedido.setBackground(Color.lightGray);

        this.btnVerComanda.addActionListener(this);
        btnVerComanda.setSize(new Dimension(300, 25));
        btnVerComanda.setBackground(Color.lightGray);

        //this.btnListaPublicacoes.addActionListener(this);
        this.btnConecta.addActionListener(this);
        adicionarComponente(painel, new JLabel("IP:"), 0, 0, 1, 1);

        adicionarComponente(painel, this.tfIP, 1, 0, 1, 1);
        adicionarComponente(painel, this.btnConecta, 2, 0, 1, 1);

        /*adicionarComponente(painel, this.btnAtualiza, 0, 1, 1, 1);
         */
        adicionarComponente(painel, this.btnNovoPedido, 1, 2, 1, 1);
        adicionarComponente(painel, this.btnVerComanda, 1, 3, 1, 1);
        HabilitaDesabilita();
        super.add(painel);

        super.addWindowListener(this);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        this.setResizable(false);

    }

    private void adicionarComponente(JPanel painel, JComponent componente,
            int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        try {
            if (btn.equals(this.btnConecta)) {
                //System.out.println("Entrei\n\n");
                this.status = true;
                System.out.print(tfIP.getText());
                this.cli = new OQueFazerCliente(this.tfIP.getText());
                cli.atualiza(controleProd);
                cli.atualiza2(controleProd);
                // System.out.println(this.controleProd.retornaProdutos());
                this.HabilitaDesabilita();
                //System.out.println("Tamanho : "+this.controleProd.listaProdutos.size());

            } /*if (btn.equals(this.btnAtualiza)) {
                //System.out.println("Entrei\n\n");
                this.status = true;
                cli.atualiza(this.controleProd);
                cli.atualiza2(this.controleProd);
                // System.out.println(this.controleProd.retornaProdutos());
                this.HabilitaDesabilita();
                //System.out.println("Tamanho : "+this.controleProd.listaProdutos.size());

            }*/ else if (btn.equals(this.btnNovoPedido)) {
                new TelaNovoPedido(cli);
            } else if (btn.equals(this.btnVerComanda)) {
                new TelaVerComanda(cli);
            }
        } catch (Exception exc) {

        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        try {

        } catch (Exception exc) {

        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    public static void main(String h[]) {
        new TelaPrincipal();
        Date a = new Date();
        //System.out.print(a.getMonth());
    }
}
