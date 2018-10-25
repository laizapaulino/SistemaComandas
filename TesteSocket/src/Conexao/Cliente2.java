/*
LEMBRETES: 
- O cliente e o servidor DEVEM ter o mesmo nome de pacote pra dar certo : Erro: Pacote.Pedidos; local class incompatible: stream classdesc serialVersionUID = 303364178763483147, local class serialVersionUID = -4836786963108185642
-
 */
package Conexao;
//EnviaObjCliente

import Entidade.*;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Laiza
 */
public class Cliente2 {

    /*public static void main(String[] args)
            throws UnknownHostException, IOException, InterruptedException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());//Serve pra mandar as coisas

        System.out.println("O cliente se conectou ao servidor!");

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        ///Pedidos a serem enviados para o servidor
        ArrayList<Consumo> p = new ArrayList<>();
        p.add(new Consumo("Lanche 2", ((float) 2.0)));
        Pedidos pedi = new Pedidos("1");
        pedi.setListaConsumo(p);
        Object a  = new fimComanda("1");
        //output.writeObject(pedi);//Aqui manda de vdd

        output.writeObject(a);

        //output.writeObject(ped2);
        //output.writeObject(ped3);
        //output.writeObject(ped4);
        //a = new fimComanda(2);
        //output.writeObject(a);
        saida.close();
        cliente.close();
    }*/
}
