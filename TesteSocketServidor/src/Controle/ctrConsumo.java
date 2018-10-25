/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidade.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class ctrConsumo {

    String nome = "produtos.ser";
    public ArrayList<Consumo> listaProdutos = new ArrayList<>();

    public ctrConsumo() {
        this.lerProdutos();
    }

    public void adicionaProduto(Consumo c) throws Exception {
        int tem = this.achaProduto(c.getNomeProduto());
        if (tem == -1) {
            listaProdutos.add(c);
            this.serializar();
            JOptionPane.showMessageDialog(null, "Deu certo");

        } else {
            JOptionPane.showMessageDialog(null, "Produto: " + c.getNomeProduto() + "\nJÁ EXISTE");
        }
    }

    public int achaProduto(String nome) {
        int iterador = -1;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getNomeProduto().equals(nome)) {
                iterador = i;
                break;
            }
        }
        System.out.print("Tam: " + listaProdutos.size() + "  it: " + iterador);

        return iterador;
    }

    public String retornaProdutos() {
        String x = "Produtos Cadastrados\n------------------------------\n";
        for (int i = 0; i < listaProdutos.size(); i++) {
            x += listaProdutos.get(i).toString();
        }
        return x;
    }

    public int excluiProduto(String nome) throws Exception {

        //Achar livro
        int it = this.achaProduto(nome);
        if (it > -1) {
            Consumo prod = listaProdutos.get(it);
            JOptionPane.showMessageDialog(null, "Produto: " + listaProdutos.get(it).getNomeProduto() + "\nFoi excluido");
            listaProdutos.remove(it);
            this.serializar();

            JOptionPane.showMessageDialog(null, "Success");

            return 0;

        }
        JOptionPane.showMessageDialog(null, "Não foi possivel localizar o produto");
        return 1;

    }

    public void serializar() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nome);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(this.listaProdutos);
            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo não encontrado!");
        }
    }

    public void lerProdutos() {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            this.listaProdutos = (ArrayList<Consumo>) in.readObject();
            in.close();
            System.out.print("alou\n");

        } catch (Exception ex) {
            this.listaProdutos = new ArrayList<>();
        }
    }
}
