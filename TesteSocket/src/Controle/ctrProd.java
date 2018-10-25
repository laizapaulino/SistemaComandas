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
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Laiza
 */
public class ctrProd {

    final String nome = "produtos.ser";
    public ArrayList<Consumo> listaProdutos = new ArrayList<>();
    public ArrayList<String> listaIDComanda = new ArrayList<>();

    public ctrProd() {
        this.lerProdutos();
        this.lerComandas();
    }

    public int achaProduto(String nome) {
        int iterador = -1;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getNomeProduto().equals(nome)) {
                iterador = i;
                break;
            }
        }
        //System.out.print("  it: " + iterador);

        return iterador;
    }

    public void lerProdutos() {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            this.listaProdutos = (ArrayList<Consumo>) in.readObject();
            in.close();

        } catch (Exception ex) {
            this.listaProdutos = new ArrayList<>();
        }
    }

    public void lerComandas() {
        try {
            FileInputStream arquivo = new FileInputStream("idComandas.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            this.listaIDComanda = (ArrayList) in.readObject();
            System.out.print("COM "+this.listaIDComanda.size());
            in.close();

        } catch (Exception ex) {
            this.listaIDComanda = new ArrayList<>();
        }
    }

}
