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
public class TelaCadastrarComandas extends JFrame implements ActionListener {
//Por a parte das listagem em um botão que leva para uma janela de consukltas gerais

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfPed1 = new JTextField(30);
    private JTextArea textTodosID = new JTextArea();
    private ctrComandas controle = new ctrComandas();
    private final JButton btCadastra = new JButton("Cadastrar comanda/mesa");
    ctrComandas c = new ctrComandas();

    public TelaCadastrarComandas() {
        super("Cadastrar Produto");
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(50, 45, 50, 45),
                BorderFactory.createEmptyBorder()));

        adicionarComponente(painel, new JLabel("Cadastro de Comanda/Mesa"), 0, 2, 1, 1);
        //adicionarComponente(painel, tfNome, 1, 1, 1, 1);

        adicionarComponente(painel, tfPed1, 0, 3, 1, 1);

        btCadastra.addActionListener(this);
        btCadastra.setBackground(Color.LIGHT_GRAY);
        adicionarComponente(painel, btCadastra, 0, 10, 1, 1);

        this.textTodosID.setEditable(false);
        this.textTodosID.setText(c.toStringID());
        adicionarComponente(painel, this.textTodosID, 0, 11, 1, 1);

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
    }

    public void actionPerformed(ActionEvent e) {

        JButton botao = (JButton) e.getSource();
        if (botao.equals(this.btCadastra)) {
            if (tfPed1.getText().length() > 0) {
                try {
                    c.adicionarComanda((String) tfPed1.getText());
                    c.serializarID();
                    this.textTodosID.setText(c.toStringID());
                    System.out.println("Cadastra comanda, ha: " + c.idComandas.size());
                    this.limpaTF();
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastrarComandas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
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
        new TelaCadastrarComandas(new ctrComandas());
    }*/
}
