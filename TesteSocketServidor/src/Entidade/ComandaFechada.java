/*
Essa classe serve pra não confundir com o que está aberto
 */
package Entidade;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Laiza
 */
public class ComandaFechada extends Comanda implements Serializable {

    private Date data;
    private int impostosOuAcrescimos;
    private double Total;
    private String metodoDePagamento;

    public ComandaFechada(String mesa, Date data, ArrayList<Consumo> consumido, String metodoDePagamento) {
        super.mesa = mesa;
        this.data = data;
        super.consumido = consumido;
        this.impostosOuAcrescimos = 0;
        for (int i = 0; i < consumido.size(); i++) {
            Total += consumido.get(i).getValor();
        }

        this.metodoDePagamento = metodoDePagamento;
    }


    

    public int getImpostosOuAcrescimos() {
        return impostosOuAcrescimos;
    }

    public double getTotal() {
        return Total;
    }

    public void setMetodoDePagamento(String metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return "\nDia: " + data.getDay() + "/" + data.getMonth() + "/" + data.getYear() + " - " + data.getHours() + ":" + data.getMinutes() + ":" + data.getSeconds()
                + "\nMesa: " + mesa
                + "\nConsumo:\n" + this.getProdutos()
                + "\nTOTAL: " + df.format(Total)
                + "\nMetodo De Pagamento: " + metodoDePagamento;
    }

}
