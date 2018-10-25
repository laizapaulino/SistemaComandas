/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package Visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Laiza
 */
public class TelaEditarComanda extends JFrame implements ActionListener {

    private final JPanel painel = new JPanel(new GridBagLayout());

    private final JComboBox cbProdComanda = new JComboBox();
    private final JTextField tfEditar = new JTextField(30);
    private final JButton btnVai = new JButton("Selecionar");

    private final JButton btnFecharComanda = new JButton("Fechar Comanda");
    private final JButton btnEditarComanda = new JButton("Editar Comanda");

    public TelaEditarComanda(int nComanda) {

        //tfCampoTitulo.setEditable(false);
        //tfCampoISBN.setEditable(false);
        painel.setBackground(Color.white);
        adicionarComponente(painel, new JLabel("Numero da Comanda: "+ nComanda), 0, 0, 1, 1);
        //adicionarComponente(painel, new JLabel("" + nComanda), 1, 0, 1, 1);
        adicionarComponente(painel, new JLabel("Produtos Comanda"), 0, 1, 1, 1);
        adicionarComponente(painel, this.cbProdComanda, 0, 2, 1, 1);
        adicionarComponente(painel, this.btnVai, 1, 2, 1, 1);
        adicionarComponente(painel, new JLabel("Modificações"), 0, 3, 1, 1);
        adicionarComponente(painel, this.tfEditar, 0, 4, 1, 1);
        adicionarComponente(painel, this.btnEditarComanda, 1, 4, 1, 1);

        btnVai.addActionListener(this);
        btnVai.setBackground(Color.LIGHT_GRAY);
        btnFecharComanda.addActionListener(this);
        btnFecharComanda.setBackground(Color.LIGHT_GRAY);
        btnEditarComanda.addActionListener(this);
        btnEditarComanda.setBackground(Color.LIGHT_GRAY);

        super.add(painel);
        super.pack();
        this.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public void actionPerformed(ActionEvent ae) {

    }

    /*public static void main(String args[]) {
        new TelaEditarComanda(1);
    }*/
}
