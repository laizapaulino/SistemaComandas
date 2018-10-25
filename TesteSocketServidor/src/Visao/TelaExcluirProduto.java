/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

/**
 *
 * @author Laiza
 */
import Controle.ctrConsumo;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TelaExcluirProduto extends JFrame implements ActionListener {

    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfPed1 = new JTextField(30);
    private final JButton btnExcluirProduto = new JButton("Excluir Produto");
    ctrConsumo prod;

    public TelaExcluirProduto(ctrConsumo prod) {
        this.prod = prod;

        btnExcluirProduto.addActionListener(this);
        btnExcluirProduto.setBackground(Color.LIGHT_GRAY);
        adicionarComponente(painel, this.btnExcluirProduto, 0, 8, 1, 1);
        adicionarComponente(painel, this.tfPed1, 0, 7, 1, 1);
        adicionarComponente(painel, new JLabel("Digite o nome do Produto a ser excluido"), 0, 6, 1, 1);

        super.add(painel);
        super.pack();
        // super.setSize(1000, 500);
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
public void limpaTF() {
        tfPed1.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();

        if (botao.equals(this.btnExcluirProduto)){
            try {
                prod.excluiProduto(tfPed1.getText());
                this.limpaTF();
            } catch (Exception ex) {
                Logger.getLogger(TelaExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
