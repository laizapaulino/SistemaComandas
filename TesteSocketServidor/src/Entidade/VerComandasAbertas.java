/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;

/**
 *
 * @author Laiza
 */
public class VerComandasAbertas implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    String mesa ;

    public VerComandasAbertas(String mesa) {
        this.mesa = mesa;
    }

    public String getMesa() {
        return mesa;
    }
    

}
