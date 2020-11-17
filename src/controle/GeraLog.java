/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author thiag
 */
public class GeraLog {
    
    public void gravaErro(String erro,String classe) {
        File arquivoTxt = new File("Log.txt");

        if(!arquivoTxt.exists()) {
            try{   //Cria o arquivo
                arquivoTxt.createNewFile();
                System.out.println("Arquivo criado");

                //salva o arquivo
                FileWriter  writer = new FileWriter(arquivoTxt);
                writer.write("["+ new Date() + "][" + InetAddress.getLocalHost().getHostName() + "]");
                writer.write(" Erro: " + erro + " Classe: " + classe);                               

                writer.close();
                System.out.println("Arquivo salvado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileReader reader = new FileReader(arquivoTxt);
                BufferedReader br = new BufferedReader(reader);
                String linha = br.readLine();
                FileWriter  writer = new FileWriter(arquivoTxt);

                while(linha != null) {
                    writer.write(linha+"\n");
                    br.readLine();
                    linha = br.readLine();
                }

                br.close();
                reader.close();

                writer.write("["+ new Date() + "][" + InetAddress.getLocalHost().getHostName() + "]");
                writer.write(" Erro: " + erro + " Classe: " + classe);                                               
                writer.close();
                System.out.println("Arquivo salvado");
            } catch(IOException err) {
                err.printStackTrace();
            }
        }
    }   
}
