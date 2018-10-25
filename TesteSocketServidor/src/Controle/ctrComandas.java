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

/**
 *
 * @author Laiza
 */
public class ctrComandas {

    ArrayList<ComandaAberta> comandas = new ArrayList<>();
    ArrayList<ComandaFechada> comFechadas = new ArrayList<>();
    public ArrayList<String> idComandas = new ArrayList<>();

    String nomeAberta = "comandas_abertas.ser";
    String nomeFechada = "comandas_fechadas.ser";
    String nomeID = "idComandas.ser";

    public ctrComandas() {
        this.lerAberta();
        this.lerFechada();
        this.lerID();

    }

    public ArrayList<ComandaFechada> getComFechadas() {
        return comFechadas;
    }

    public void adicionarPedido(String mesa, Pedidos pedido) throws Exception {
        boolean achei = false;

        for (int i = 0; i < comandas.size(); i++) {//Verifica se já há uma comanda aberta daquela mesa
            if (comandas.get(i).getMesa().equals(pedido.getMesa())) {
                achei = true;
                for (int j = 0; j < pedido.getListaConsumo().size(); j++) {
                    comandas.get(i).addConsumo(pedido.listaConsumo.get(j));
                }
                break;
            }
        }

        if (achei == false) {
            comandas.add(new ComandaAberta(pedido.getMesa(), pedido.listaConsumo));
        }

        //System.out.println("Tamanho: "+this.comandas.size()+"\n"+this.comandas.get(0).getProdutos()
        //      +"\n"+this.verComandasAbertas());
        this.serializarAberta();

    }

    public void adicionarComanda(String id) throws Exception {
        this.idComandas.add(id);
        this.idComandas.sort(null);
        this.serializarID();
    }

    public void excluirComanda(String id) {
        for (int i =0;i< this.idComandas.size();i++){
            if(idComandas.get(i).equals(id)){
                this.idComandas.remove(i);
            }
        }
    }
    
    public void fecharComanda(fimComanda fechada) throws Exception {
        for (int i = 0; i < comandas.size(); i++) {
            if (comandas.get(i).getMesa().equals(fechada.getMesa())) {
                comFechadas.add(new ComandaFechada(comandas.get(i).getMesa(),
                        new Date(), comandas.get(i).getConsumido(), "")
                );//Registra a comanda fechada
                comandas.remove(i);//Libera a mesa pra ser aberta uma nova comanda 
                this.serializarAberta();
                this.serializarFechada();
                break;
            }
        }
    }

    public void finalizarComanda(String mesa, String Pagamento) throws Exception {
        for (int i = 0; i < comFechadas.size(); i++) {
            if (comFechadas.get(i).getMesa().equals(mesa)) {
                comFechadas.get(i).setMetodoDePagamento(Pagamento);//Registra a comanda fechada

                this.serializarFechada();
                break;
            }
        }
    }

    public String verUmaComandaAberta(String mesa) {
        String x = "Comanda\n----------------------------\n";

        for (int i = 0; i < comandas.size(); i++) {
            if (comandas.get(i).getMesa().equals(mesa)) {
                x += comandas.get(i).toString() + "\n";
                break;
            }
        }
        return x;
    }

    public String verUmaComandaAFechar(String mesa) {
        String x = "Comanda\n----------------------------\n";

        for (int i = 0; i < this.comFechadas.size(); i++) {
            if (comFechadas.get(i).getMesa().equals(mesa)) {
                x += comFechadas.get(i).toString() + "\n";
                break;
            }
        }
        return x;
    }

    public int getUmaComandaAFechar(String mesa) {

        for (int i = 0; i < this.comFechadas.size(); i++) {
            if (comFechadas.get(i).getMesa().equals(mesa) && comFechadas.get(i).getMetodoDePagamento().equals("")) {
                return i;
            }
        }
        return -1;
    }

    public String verComandasAbertas() {
        String x = "Comandas Abertas\n----------------------------------------";
        //this.lerAberta();
        for (int i = 0; i < comandas.size(); i++) {
            x += comandas.get(i).toString() + "\n";
            //System.out.println("Mesa: " + comandas.get(i).getMesa() + "\nConsumo:\n" + comandas.get(i).getProdutos());
        }
        //System.out.println(x);
        return x;
    }

    public String verComandasFechadas() {
        String x = "Comandas Fechadas\n----------------------------\n";
        this.lerFechada();

        for (int i = 0; i < comFechadas.size(); i++) {
            if (comFechadas.get(i).getMetodoDePagamento().equals("")) {
                x += comFechadas.get(i).toString() + "\n";
            }
        }
        return x;
    }

    public String verComandasFinalizadas() {
        String x = "Comandas Finalizadas\n----------------------------\n";
        this.lerFechada();

        for (int i = 0; i < comFechadas.size(); i++) {
            if (comFechadas.get(i).getMetodoDePagamento() != "") {

                if (!comFechadas.get(i).getMetodoDePagamento().equals("")) {
                    x += comFechadas.get(i).toString() + "\n";
                }
            }
        }
        return x;
    }

    public void serializarAberta() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeAberta);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);

            out.writeObject(this.comandas);

            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo não encontrado!");
        }
    }

    public void serializarFechada() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeFechada);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);

            out.writeObject(this.comFechadas);

            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo não encontrado!");
        }
    }

    public void serializarID() throws Exception {
        try {
            FileOutputStream arquivo = new FileOutputStream(this.nomeID);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(this.idComandas);
            out.flush();
            out.close();
            arquivo.close();
            //System.out.print("alou2\n");
        } catch (Exception exc) {
            throw new Exception("Arquivo não encontrado!");
        }
    }

    /*public void lerProdutos(String nome) {
        try {
            FileInputStream arquivo = new FileInputStream(nome);
            ObjectInputStream in = new ObjectInputStream(arquivo);
            if (nome.equals("comandas_abertas.ser")) {
                this.comandas = (ArrayList<ComandaAberta>) in.readObject();
            } else if (nome.equals("comandas_fechadas.ser")) {
                this.comFechadas = (ArrayList<ComandaFechada>) in.readObject();
            }

            in.close();
            System.out.print("alou\n");

        } catch (Exception ex) {
            if (nome.equals("comandas_abertas.ser")) {
                this.comandas = new ArrayList<>();
            } else if (nome.equals("comandas_fechadas.ser")) {
                this.comFechadas = new ArrayList<>();
            }
        }
    }*/
    public void lerAberta() {
        try {
            FileInputStream arquivo = new FileInputStream(nomeAberta);
            ObjectInputStream in = new ObjectInputStream(arquivo);

            this.comandas = (ArrayList<ComandaAberta>) in.readObject();

            in.close();
            arquivo.close();
            System.out.print("Serializa\n");
        } catch (Exception ex) {
            this.comandas = new ArrayList<>();
        }
    }

    public void lerFechada() {
        try {
            FileInputStream arquivo = new FileInputStream(nomeFechada);
            ObjectInputStream in = new ObjectInputStream(arquivo);

            this.comFechadas = (ArrayList<ComandaFechada>) in.readObject();

            in.close();
            arquivo.close();
            //System.out.print("Serializa\n");

        } catch (Exception ex) {

            this.comFechadas = new ArrayList<>();

        }
    }
    
    public void lerID() {
        try {
            FileInputStream arquivo = new FileInputStream(this.nomeID);
            ObjectInputStream in = new ObjectInputStream(arquivo);

            this.idComandas = (ArrayList<String>) in.readObject();

            in.close();
            arquivo.close();
            //System.out.print("Serializa\n");

        } catch (Exception ex) {

            this.comFechadas = new ArrayList<>();

        }
    }

}
