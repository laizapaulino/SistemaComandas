/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Laiza
 */
public class TelaFazerPagamento extends JFrame implements ActionListener {

    ctrComandas com;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private JTextArea resultado = new JTextArea(20, 40);
    private final JComboBox cbComandas = new JComboBox();
    private final JButton btnVai = new JButton("Selecionar");
    private final JButton btnFecharComanda = new JButton("Fechar Comanda");
    private final JComboBox cbPagamento = new JComboBox();

    public TelaFazerPagamento() {
        com = new ctrComandas();
        resultado.setEditable(false);
        this.setCombo();

        cbPagamento.addItem("Dinheiro");//Adicionar tipos de pagamentos
        cbPagamento.addItem("Cartao");
        cbPagamento.addItem("Dinheiro e Cartão");

        cbComandas.setBackground(Color.white);
        painel.setBackground(Color.white);
        adicionarComponente(painel, new JLabel("Numero da Mesa/Comanda:"), 0, 1, 1, 1);
        adicionarComponente(painel, this.cbComandas, 0, 2, 1, 1);
        adicionarComponente(painel, this.btnVai, 1, 2, 1, 1);
        adicionarComponente(painel, this.cbPagamento, 1, 7, 1, 1);
        adicionarComponente(painel, this.btnFecharComanda, 1, 8, 1, 1);

        btnVai.addActionListener(this);
        btnVai.setBackground(Color.LIGHT_GRAY);
        btnFecharComanda.addActionListener(this);
        btnFecharComanda.setBackground(Color.LIGHT_GRAY);
        this.cbComandas.addItem("");
        JScrollPane scroll = new JScrollPane(resultado,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        adicionarComponente(painel, new JLabel("Comandas a serem fechadas"), 0, 2, 1, 1);
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

    public void setCombo() {
        for (int i = 0; i < com.getComFechadas().size(); i++) {
            if (com.getComFechadas().get(i).getMetodoDePagamento().equals("")) {
                String x = com.getComFechadas().get(i).getMesa();
                this.cbComandas.addItem("" + x);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        if (botao.equals(this.btnVai)) {
//            if ((String) this.cbComandas.getSelectedItem() == "") {
            //            JOptionPane.showMessageDialog(null, "Mesa/Comanda inválida, tente novamente");
            //          } else {

            String mesa = (String) this.cbComandas.getSelectedItem();
            this.resultado.setText(com.verUmaComandaAFechar(mesa));
//            }

        }
        if (botao.equals(this.btnFecharComanda)) {

            if ((String) this.cbComandas.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Mesa/Comanda inválida, tente novamente");
            } else {
                int fechar = this.com.getUmaComandaAFechar((String) this.cbComandas.getSelectedItem());
                this.com.getComFechadas().get(fechar).setMetodoDePagamento((String) cbPagamento.getSelectedItem());

                try {
                    this.com.serializarFechada();
                } catch (Exception ex) {
                    Logger.getLogger(TelaFazerPagamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
                JOptionPane.showMessageDialog(null, "Mesa/Comanda fechada com sucesso");

            }
        }
    }

    /*public static void main(String args[]) {
        new TelaFazerPagamento();
    }*/
}
