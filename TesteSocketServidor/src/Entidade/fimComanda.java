/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package Entidade;

import java.io.Serializable;

/**
 *
 * @author Laiza
 */
public class fimComanda implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    String mesa;

    public fimComanda(String mesa) {
        this.mesa = mesa;
    }

    public String getMesa() {
        return mesa;
    }
    
    
    
}
