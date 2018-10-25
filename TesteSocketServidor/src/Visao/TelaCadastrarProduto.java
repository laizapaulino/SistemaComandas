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
public class TelaCadastrarProduto extends JFrame implements ActionListener {
//Por a parte das listagem em um botão que leva para uma janela de consukltas gerais

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfPed1 = new JTextField(30);
    private final JTextField tfPed2 = new JTextField(30);
    private final JTextField tfPed3 = new JTextField(30);
    private final JTextField tfPed4 = new JTextField(30);

    private final JTextField tfVal1 = new JTextField(5);
    private final JTextField tfVal2 = new JTextField(5);
    private final JTextField tfVal3 = new JTextField(5);
    private final JTextField tfVal4 = new JTextField(5);

    private ctrConsumo controle;
    private final JButton btnMais = new JButton("Mais Pedidos");
    private final JButton btCadastra = new JButton("Cadastrar Produto");
    private ArrayList<Consumo> p = new ArrayList<>();

    public TelaCadastrarProduto(ctrConsumo controle) {
        super("Cadastrar Produto");
        this.controle = controle;
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 45, 50, 45),
                BorderFactory.createEmptyBorder()));

        adicionarComponente(painel, new JLabel("Valor"), 1, 2, 1, 1);
        adicionarComponente(painel, new JLabel("Produtos a serem cadastrados"), 0, 2, 1, 1);
        //adicionarComponente(painel, tfNome, 1, 1, 1, 1);

        adicionarComponente(painel, tfPed1, 0, 3, 1, 1);
        adicionarComponente(painel, tfPed2, 0, 4, 1, 1);
        adicionarComponente(painel, tfPed3, 0, 5, 1, 1);
        adicionarComponente(painel, tfPed4, 0, 6, 1, 1);

        adicionarComponente(painel, tfVal1, 1, 3, 1, 1);
        adicionarComponente(painel, tfVal2, 1, 4, 1, 1);
        adicionarComponente(painel, tfVal3, 1, 5, 1, 1);
        adicionarComponente(painel, tfVal4, 1, 6, 1, 1);

        btCadastra.addActionListener(this);
        btCadastra.setBackground(Color.LIGHT_GRAY);
        adicionarComponente(painel, btCadastra, 0, 10, 1, 1);

        super.add(painel);
        super.pack();
        // super.setSize(1000, 500);
        this.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);

    }

    public void limpaTF() {
        tfPed1.setText("");
        tfPed2.setText("");
        tfPed3.setText("");
        tfPed4.setText("");

        tfVal1.setText("");
        tfVal2.setText("");
        tfVal3.setText("");
        tfVal4.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        JButton botao = (JButton) e.getSource();
        if (botao.equals(this.btCadastra)) {
            Consumo c;
            float x;
            if (tfPed1.getText().length() > 0) {
                x = Float.parseFloat(this.tfVal1.getText());
                try {
                    controle.adicionaProduto(new Consumo(tfPed1.getText(), x));
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (tfPed2.getText().length() > 0) {
                x = Float.parseFloat(this.tfVal2.getText());
                try {
                    controle.adicionaProduto(new Consumo(tfPed2.getText(), x));
                    //num = Integer.parseInt(qt2.getText());
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (tfPed3.getText().length() > 0) {
                x = Float.parseFloat(this.tfVal3.getText());
                try {
                    controle.adicionaProduto(new Consumo(tfPed3.getText(), x));
                    //num = Integer.parseInt(qt3.getText());
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (tfPed4.getText().length() > 0) {
                x = Float.parseFloat(this.tfVal4.getText());
                try {
                    controle.adicionaProduto(new Consumo(tfPed4.getText(), x));
                    //num = Integer.parseInt(qt4.getText());
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            this.limpaTF();

        }

        if (botao.equals(this.btnMais)) {

        }

    }

    public void adicionarComponente(JPanel painel, JComponent componente, int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 5, 10, 10);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }

    /*public static void main(String a[]) {
        new TelaCadastrarProduto(new ctrConsumo());
    }*/

}
