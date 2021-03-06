/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.Normalizer;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;
// Essa classe é a responsavel pela impressao. Ela detecta a impressora  
// instalada, recebe o texto e o imprime.  
public final class Impressao {       
        
	// variavel estatica porque será utilizada por inumeras threads
	private static PrintService impressora;
	public Impressao() {
		detectaImpressoras();
	}
	// O metodo verifica se existe impressora conectada e a
	// define como padrao.
	public void detectaImpressoras() {
		try {
			DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
			PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
			for (PrintService p : ps) {
				if(p.getName()!=null && p.getName().contains("MP-4200")){ //MP-4200
					System.out.println("Impressora Selecionada: " + p.getName());
					System.out.println("Impressora encontrada: " + p.getName());
					impressora = p;                                        
				}	
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
        
	public synchronized boolean imprime(String texto) {
		// se nao existir impressora, entao avisa usuario
		// senao imprime texto
                String textoSemAcento = removeAcento(texto);
		if (impressora == null) {
			String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n reinicie o programa.";
			System.out.println(msg);
                        JOptionPane.showMessageDialog(null, msg);                        
		} else {
			try {
				DocPrintJob dpj = impressora.createPrintJob();
				InputStream stream = new ByteArrayInputStream(textoSemAcento.getBytes());
				DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
				Doc doc = new SimpleDoc(stream, flavor, null);
				dpj.print(doc, null);                                
                                return true;
			} catch (PrintException e) {
			}
		}
		return false;
	}
        
        public void acionarGuilhotina(){
               imprime(""+(char)27+(char)109);
        }
        
        public static String removeAcento(String str) {            
            str = Normalizer.normalize(str, Normalizer.Form.NFD);
            str = str.replaceAll("[^\\p{ASCII}]", "");
            return str;               
        }
        
        public void qrCode() {
            String recebeQR = "00020126580014br.gov.bcb.pix0123sac@sabortrivial.com.br0209PIX EMAIL520400005303986540612.505802BR5910----------6007MARINGA62090505Email6304107";
            String qr = new String(new char[]{0x1B, '-', 1})  
                    + new String(new byte[]{27, 97, 1})  
                    + new String(new byte[]{29, 40, 107, 3, 0, 49, 67, 5})  
                    + new String(new byte[]{29, 40, 107, 3, 0, 49, 69, 49})  
                    + new String(new byte[]{29, 40, 107, 'b', 'c', 49, 80, 48})  
                    + recebeQR
                    + new String(new char[]{29, 40, 107, 3, 0, 49, 81, 48, 12});
            
            imprime(qr);
        }
        
}