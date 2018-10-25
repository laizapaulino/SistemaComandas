/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import Conexao.Servidor;

/**
 *
 * @author Laiza
 */
public class TelaLiga extends JFrame implements ActionListener, WindowListener {

    Servidor servidor;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JButton btnLiga = new JButton("Ligar Servidor");
    private final JButton btnFazerPagamento = new JButton("Adicionar");
    private final JButton btnVerComanda = new JButton("Ver Comandas Abertas");
    private final JButton btnVerProdutos = new JButton("Ver Produtos Cadastrados");

    private boolean status = false;

    public void HabilitaDesabilita() {
        this.btnFazerPagamento.setEnabled(this.status);
        this.btnVerComanda.setEnabled(this.status);
    }

    public TelaLiga() {
        super.setExtendedState((int) JFrame.TOP_ALIGNMENT);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(200, 200, 200, 200),
                BorderFactory.createEmptyBorder()));
        painel.setBackground(Color.white);

        this.btnLiga.addActionListener(this);
        btnLiga.setSize(new Dimension(300, 25));
        btnLiga.setBackground(Color.lightGray);

        adicionarComponente(painel, this.btnLiga, 0, 0, 1, 1);

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
            if (btn.equals(this.btnLiga)) {
                servidor = new Servidor();//O servidor faz com que nada além dele seja executado
                servidor.iniciaServidor();
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
        new TelaLiga();
        //System.out.print(a.getMonth());
    }
}
