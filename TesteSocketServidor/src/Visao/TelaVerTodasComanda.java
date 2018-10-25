/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controle.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laiza
 */
public class TelaVerTodasComanda extends JFrame implements ActionListener {

    ctrComandas com;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private JTextArea resultado = new JTextArea(20, 40);
    private final JComboBox cbComandas = new JComboBox();
    private final JButton btnVai = new JButton("Selecionar");
    private final JButton btnFecharComanda = new JButton("Fechar Comanda");
    private final JButton btnEditarComanda = new JButton("Editar Comanda");

    public TelaVerTodasComanda() {
        com = new ctrComandas();
        //tfCampoTitulo.setEditable(false);
        //tfCampoISBN.setEditable(false);
        resultado.setEditable(false);
        cbComandas.addItem("Abertas");//Adicionar comandas abertas
        cbComandas.addItem("Fechadas");//Adicionar comandas abertas
        cbComandas.addItem("Finalizadas");//Adicionar comandas abertas

        cbComandas.setBackground(Color.white);
        painel.setBackground(Color.white);
        adicionarComponente(painel, new JLabel("Numero da Mesa/Comanda:"), 0, 1, 1, 1);
        adicionarComponente(painel, this.cbComandas, 0, 2, 1, 1);
        adicionarComponente(painel, this.btnVai, 1, 2, 1, 1);
        //adicionarComponente(painel, this.btnFecharComanda, 1, 7, 1, 1);
        //adicionarComponente(painel, this.btnEditarComanda, 1, 8, 1, 1);

        btnVai.addActionListener(this);
        btnVai.setBackground(Color.LIGHT_GRAY);
        btnFecharComanda.addActionListener(this);
        btnFecharComanda.setBackground(Color.LIGHT_GRAY);

        btnEditarComanda.addActionListener(this);
        btnEditarComanda.setBackground(Color.LIGHT_GRAY);
        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, new JLabel("Lista publicações cadastradas"), 0, 2, 1, 1);
        adicionarComponente(painel, scroll, 1, 6, 1, 1);

        super.add(painel);
        super.pack();
        this.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
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
        JButton botao = (JButton) e.getSource();
        if (botao.equals(this.btnEditarComanda)) {

        }
        if (botao.equals(this.btnVai)) {
            if (this.cbComandas.getSelectedItem().equals("Abertas")) {
                resultado.setText(com.verComandasAbertas());
            }
            if (this.cbComandas.getSelectedItem().equals("Fechadas")) {
                resultado.setText(com.verComandasFechadas());
            }
            if (this.cbComandas.getSelectedItem().equals("Finalizadas")) {
                resultado.setText(com.verComandasFinalizadas());
            }
        }

    }

    public static void main(String args[]) {
        new TelaVerTodasComanda();
    }
}
