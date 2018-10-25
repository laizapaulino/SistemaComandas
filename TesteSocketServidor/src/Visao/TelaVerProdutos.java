/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ctrConsumo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Laiza
 */
public class TelaVerProdutos extends JFrame implements ActionListener {

    private final JPanel painel = new JPanel(new GridBagLayout());
    private JTextArea resultado = new JTextArea(20, 40);
    private final JButton btnCadastrarProdutos = new JButton("Cadastrar Produtos");
    private final JButton btnExcluirProduto = new JButton("Excluir Produto");
    private final JButton btnAtualiza = new JButton("Atualiza");

    ctrConsumo prod;

    public TelaVerProdutos() {
        resultado.setEditable(false);

        prod = new ctrConsumo();
        resultado.setText(prod.retornaProdutos());
        btnCadastrarProdutos.addActionListener(this);
        btnCadastrarProdutos.setBackground(Color.LIGHT_GRAY);

        btnExcluirProduto.addActionListener(this);
        btnExcluirProduto.setBackground(Color.LIGHT_GRAY);

        btnAtualiza.addActionListener(this);
        btnAtualiza.setBackground(Color.LIGHT_GRAY);
        
        adicionarComponente(painel, new JLabel("Lista de Produtos Cadastrados"), 1, 2, 1, 1);
        adicionarComponente(painel, this.btnCadastrarProdutos, 1, 7, 1, 1);
        adicionarComponente(painel, this.btnExcluirProduto, 1, 8, 1, 1);
        adicionarComponente(painel, this.btnAtualiza, 1, 9, 1, 1);

        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painel.setBackground(Color.white);
        adicionarComponente(painel, scroll, 1, 6, 1, 1);

        super.add(painel);
        super.pack();
        this.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
        //System.out.println(this.prod.);
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
        if (botao.equals(this.btnCadastrarProdutos)) {
            new TelaCadastrarProduto(prod);

        }
        if (botao.equals(this.btnExcluirProduto)) {
            new TelaExcluirProduto(prod);

        }
        if (botao.equals(this.btnAtualiza)) {
            resultado.setText(prod.retornaProdutos());

        }
    }

   /* public static void main(String a[]) {
        
        new TelaVerProdutos();
    }*/

}
