package Entidade;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laiza
 */
public class Consumo implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    private String nomeProduto;
    private float Valor;

    

    public Consumo(String nomeProduto, float Valor) {
        this.nomeProduto = nomeProduto;
        this.Valor = Valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    @Override
    public String toString() {
        return "Nome Produto: " + nomeProduto + ", Valor: " + Valor;
    }

}
