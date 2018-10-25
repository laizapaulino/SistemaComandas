/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Entidade.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Laiza
 */
public abstract class Comanda implements Serializable{

    String mesa;
    ArrayList<Consumo> consumido;

    public String getMesa() {
        return mesa;
    }

   

    public ArrayList<Consumo> getConsumido() {
        return consumido;
    }

    public String getProdutos() {
        String x = "";
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        for (int i = 0; i < consumido.size(); i++) {
            x += consumido.get(i).getNomeProduto() + "      " + df.format(consumido.get(i).getValor()) + "\n";
        }

        return x;
    }

  

}
