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
public class TelaPrincipal extends JFrame implements ActionListener, WindowListener {

    Servidor servidor;
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JButton btnFazerPagamento = new JButton("Fazer Pagamento");
    private final JButton btnVerComanda = new JButton("Ver Comandas Abertas");
    private final JButton btnVerProdutos = new JButton("Ver Produtos Cadastrados");
    private final JButton btnComandas = new JButton("Cadastrar ID Comandas");

    private boolean status = true;

    public void HabilitaDesabilita() {
        this.btnFazerPagamento.setEnabled(this.status);
        this.btnVerComanda.setEnabled(this.status);
    }

    public TelaPrincipal() {
        super("Sistema de Pedidos");
        super.setExtendedState((int) JFrame.TOP_ALIGNMENT);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(200, 200, 200, 200),
                BorderFactory.createEmptyBorder()));
        painel.setBackground(Color.white);

        this.btnFazerPagamento.addActionListener(this);
        btnFazerPagamento.setSize(new Dimension(300, 25));
        btnFazerPagamento.setBackground(Color.lightGray);

        this.btnVerComanda.addActionListener(this);
        btnVerComanda.setSize(new Dimension(300, 25));
        btnVerComanda.setBackground(Color.lightGray);

        btnVerProdutos.addActionListener(this);
        btnVerProdutos.setSize(new Dimension(300, 25));
        btnVerProdutos.setBackground(Color.lightGray);

        btnComandas.addActionListener(this);
        btnComandas.setSize(new Dimension(300, 25));
        btnComandas.setBackground(Color.lightGray);
        //this.btnListaPublicacoes.addActionListener(this);
        // adicionarComponente(painel, this.btnLiga, 0, 0, 1, 1);
        adicionarComponente(painel, this.btnFazerPagamento, 0, 1, 1, 1);
        adicionarComponente(painel, this.btnVerComanda, 0, 2, 1, 1);
        adicionarComponente(painel, this.btnVerProdutos, 0, 3, 1, 1);
        adicionarComponente(painel, this.btnComandas, 0, 4, 1, 1);

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
            if (btn.equals(this.btnFazerPagamento)) {
                new TelaFazerPagamento();

            } else if (btn.equals(this.btnVerComanda)) {//Outra pagina mostrando as abertas e as fechadas
                new TelaVerTodasComanda();

            } else if (btn.equals(this.btnVerProdutos)) {//Outra pagina mostrando as abertas e as fechadas               
                new TelaVerProdutos();

            } else if (btn.equals(this.btnComandas)) {//Outra pagina mostrando as abertas e as fechadas               
                new TelaCadastrarComandas();
            }
        } catch (Exception exc) {

        }
    }

    @Override
    public void windowOpened(WindowEvent we
    ) {
    }

    @Override
    public void windowClosing(WindowEvent we
    ) {
        try {

        } catch (Exception exc) {

        }
    }

    @Override
    public void windowClosed(WindowEvent we
    ) {
    }

    @Override
    public void windowIconified(WindowEvent we
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent we
    ) {
    }

    @Override
    public void windowActivated(WindowEvent we
    ) {
    }

    @Override
    public void windowDeactivated(WindowEvent we
    ) {
    }

    public static void main(String h[]) {
        new TelaPrincipal();
        //System.out.print(a.getMonth());
    }
}
