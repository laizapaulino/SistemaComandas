/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Laiza
 */

///FAZER VERIFICAÇÂO SE EXISTE ALGUMA MESA JA
///VETOR DE COMANDA

public class ComandaAberta extends Comanda implements Serializable{

    public ComandaAberta(String mesa, ArrayList<Consumo> consumido) {
        super.mesa = mesa;
        super.consumido = consumido;
    }
    public void addConsumo(Consumo produto) {
        this.consumido.add(produto);
    }
    

    public void setMesa(String mesa) {///Verificar antes se a mesa não esta ocupada antes de trocar
        this.mesa = mesa;
    }

    
    
    public void setConsumido(ArrayList<Consumo> consumido) {
        this.consumido = consumido;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return 
                "\nMesa: " + mesa
                + "\nConsumo:\n" + this.getProdutos();
    }
    
    
    
    

}
