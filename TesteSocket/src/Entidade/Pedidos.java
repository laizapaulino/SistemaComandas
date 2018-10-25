/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Laiza
 */
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String mesa;
     public ArrayList<Consumo>  listaConsumo= new ArrayList<>();

    public Pedidos(String mesa) {
        this.mesa = mesa;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public void setListaConsumo(ArrayList<Consumo> listaConsumo) {
        this.listaConsumo = listaConsumo;
    }
    

    public ArrayList<Consumo> getListaConsumo() {
        return listaConsumo;
    }

    public void addListaConsumo(Consumo produto) {
        this.listaConsumo.add(produto);
    }

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i< listaConsumo.size();i++){
            x += listaConsumo.get(i).toString()+"\n";
        }
        return "Pedidos:" + "\nMesa: " + mesa + "\nListaConsumo: " + x + "\n";
    }
    
    
    
    
}

