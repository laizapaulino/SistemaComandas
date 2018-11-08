/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidade.*;
import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Laiza
 */
public class OQueFazerCliente {
    private String IP;

    public OQueFazerCliente(String IP) {
        this.IP = IP;
    }
    
    public void mandarPedido(String mesa, ArrayList<Consumo> lista) throws IOException {
        Socket cliente = new Socket(IP, 12345);
        ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());//Serve pra mandar as coisas
        Pedidos pedido = new Pedidos(mesa);
        pedido.setListaConsumo(lista);
        output.writeObject(pedido);
        output.reset();
        cliente.close();
        //System.out.println(cliente.isClosed() + "  Show 1");
    }

    public void fecharComanda(String mesa) throws IOException {
        Socket cliente = new Socket(this.IP, 12345);

        ObjectOutputStream outro = new ObjectOutputStream(cliente.getOutputStream());//Serve pra mandar as coisas
        fimComanda fim = new fimComanda(mesa);
        outro.writeObject(fim);
        cliente.close();//.close();
        
        System.out.println("Show 2");
//        outro.reset();
    }

    public String verComanda(String mesa) throws IOException, ClassNotFoundException {
        Socket cliente = new Socket(this.IP, 12345);
        ObjectOutputStream outro = new ObjectOutputStream(cliente.getOutputStream());
        outro.writeObject(new VerComandasAbertas(mesa));

        Socket quemEnviou;
        String x;
        try (ServerSocket recebe = new ServerSocket(23456) ///Erro
                ) {
            quemEnviou = recebe.accept();
            ObjectInputStream input = new ObjectInputStream(quemEnviou.getInputStream());
            Object lido = input.readObject();// = input.readObject(); //Fica esperando algo chegar
            x = "";
            if (lido instanceof String) {
                x = ((String) lido);
            }
        }
        quemEnviou.close();
        return x;

    }

    public void atualiza(ctrProd prod) throws IOException, ClassNotFoundException, Exception {
        Socket cliente = new Socket(this.IP, 12345);
        ObjectOutputStream outro = new ObjectOutputStream(cliente.getOutputStream());
        outro.writeObject("Atualiza");//Manda pedido de atualiza

        Socket quemEnviou;
        ServerSocket recebe = new ServerSocket(34567);

        quemEnviou = recebe.accept();
        ObjectInputStream input = new ObjectInputStream(quemEnviou.getInputStream());
        Object lido = input.readObject();// = input.readObject(); //Fica esperando algo chegar

        if (lido instanceof ArrayList) {

            prod.listaProdutos = (ArrayList<Consumo>) lido;
            //System.out.println(prod.retornaProdutos());
            input.close();
            recebe.close();
            try {//Serializa
                FileOutputStream arquivo = new FileOutputStream(prod.nome);
                ObjectOutputStream out = new ObjectOutputStream(arquivo);
                out.writeObject(prod.listaProdutos);
                out.flush();
                out.close();
                arquivo.close();
                //System.out.print(prod.listaProdutos.size());
            } catch (Exception exc) {
                throw new Exception("Arquivo não encontrado!");
            }
        } else {
            input.close();
            recebe.close();
        }

        quemEnviou.close();
    }
    
     public void atualiza2(ctrProd controle) throws IOException, ClassNotFoundException, Exception {
        Socket cliente = new Socket(this.IP, 12345);
        ObjectOutputStream outro = new ObjectOutputStream(cliente.getOutputStream());
        outro.writeObject("Atualiza Comanda");//Manda requisição para receber as comandas que existem
        
       
        Socket quemEnviou;
        ServerSocket recebe = new ServerSocket(34567);

        quemEnviou = recebe.accept();
        ObjectInputStream input = new ObjectInputStream(quemEnviou.getInputStream());
        Object lido = input.readObject();// = input.readObject(); //Fica esperando algo chegar

        if (lido instanceof ArrayList) {

            controle.listaIDComanda = (ArrayList<String>) lido;
            System.out.println("a:"+((ArrayList<String>) lido).size());
            input.close();
            recebe.close();
            try {//Serializa
                FileOutputStream arquivo = new FileOutputStream("idComandas.ser");
                ObjectOutputStream out = new ObjectOutputStream(arquivo);
                out.writeObject(controle.listaIDComanda);
                
                out.flush();
                out.close();
                arquivo.close();
            } catch (Exception exc) {
                throw new Exception("Arquivo não encontrado!");
            }
        } else {
            input.close();
            recebe.close();
        }

        quemEnviou.close();
    }


    /* public static void main(String a[]) throws IOException {
        OQueFazerCliente cl = new OQueFazerCliente();
        ArrayList<Consumo> p = new ArrayList<>();
        p.add(new Consumo("Lanche 2", ((float) 2.0)));
        
        //cl.mandarPedido(1, p);
        
        
        
        cl.fecharComanda(1);
    }*/
}
