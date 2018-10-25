/*
LEMBRETES: 
- O cliente e o servidor DEVEM ter o mesmo nome de pacote pra dar certo
-
 */
package Conexao;
//EnviaObjetos

import Entidade.*;
import Controle.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laiza
 */
public class Servidor extends Thread {
    //Implementar fechada da mesa pra salvar em alguma coisa

    private static Socket socket;// = new Socket(12345);
    private static ctrComandas controleComanda;
    private static ctrConsumo controleConsumo;

    public Servidor() {
    }

    public Servidor(Socket socket) {
        this.socket = socket;
    }
    
    public void iniciaServidor() throws InterruptedException{
        controleComanda = new ctrComandas();

        try {
            ServerSocket serverSocket = new ServerSocket(12345); //Cria um server socket para aguardar requisições dos clientes
            while (true) {
                System.out.println("Aguardando conexões...");
                socket = serverSocket.accept(); //Fica aguardando pedidos de conexão
                System.out.println("Conectou-se...");

                (new Servidor(socket)).start(); //Inicia a thread que tratará do cliente

            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    

    @Override
    public void run() {
        try {
            //Obtém os streams de entrada e saída
            //DataInputStream in = new DataInputStream(socket.getInputStream());
            ObjectInputStream input = null;
            input = new ObjectInputStream(socket.getInputStream());

            Object lido = input.readObject();
            controleConsumo = new ctrConsumo();
            if (lido instanceof Pedidos) {
                controleComanda.adicionarPedido(((Pedidos) lido).getMesa(), ((Pedidos) lido));
                System.out.print("Envio de Pedidos\n");

            } else if (lido instanceof fimComanda) {
                System.out.print("Fechar a comanda/mesa\n");
                controleComanda.fecharComanda((fimComanda) lido);

            } else if (lido instanceof VerComandasAbertas) {
                System.out.print("Ver pedidos da comanda/mesa\n");
                Socket Mandar = new Socket(socket.getInetAddress().getHostAddress(), 23456);
                ObjectOutputStream outro = new ObjectOutputStream(Mandar.getOutputStream());//Serve pra mandar as coisas
                String x = controleComanda.verUmaComandaAberta(((VerComandasAbertas) lido).getMesa());
                outro.writeObject(x);
                outro.close();
            } else if (lido instanceof String && ((String) lido).equals("Atualiza")) {//Nao deu certo
                
                controleConsumo.lerProdutos();
                System.out.print("Atualiza Cliente\n");
                Socket Mandar = new Socket(socket.getInetAddress().getHostAddress(), 34567);
                ObjectOutputStream outro = new ObjectOutputStream(Mandar.getOutputStream());//Serve pra mandar as coisas
                
                outro.writeObject(controleConsumo.listaProdutos);
                Mandar.close();
                outro.close();
            }
            else if (lido instanceof String && ((String) lido).equals("Atualiza Comanda")) {//Nao deu certo
                controleComanda.lerID();
                System.out.print("Atualiza Comanda\n");
                Socket Mandar = new Socket(socket.getInetAddress().getHostAddress(), 34567);
                ObjectOutputStream outro = new ObjectOutputStream(Mandar.getOutputStream());//Serve pra mandar as coisas
                System.out.println("Quantia de comandas: "+controleComanda.idComandas.size());
                outro.writeObject(controleComanda.idComandas);
                Mandar.close();
                outro.close();
            }
            
            //System.out.print("sai\n");
            //input.close();//.reset();
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.toString() + "\n" + ex.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        controleComanda = new ctrComandas();

        try {
            ServerSocket serverSocket = new ServerSocket(12345); //Cria um server socket para aguardar requisições dos clientes
            while (true) {
                System.out.println("Aguardando conexões...");
                socket = serverSocket.accept(); //Fica aguardando pedidos de conexão
                System.out.println("Conectou-se...");

                (new Servidor(socket)).start(); //Inicia a thread que tratará do cliente

            }
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
