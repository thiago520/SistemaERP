/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bematech;
//
//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.NativeLibrary;
//
///**
// *
// * @author thiag
// */
//public class Bematech {
//        
//   
//
//    public static native int ConfiguraModeloImpressora(int modelo);
//    public static native int IniciaPorta(String porta);
//    public static native int FechaPorta();
//    public static native int FormataTX(String BufTras, int tipoletra, int italic, int sublin, int expand, int enfat);
//    public static native int ImprimeBitmap(String bitmap, int orientacao);
//    public static native int ComandoTX(String sTexto,int sComando);
//	public static native void BematechTX(String string);
//	public static native int AcionaGuilhotina(int i);
//	public static native int AtualizaFirmware(String arquivo);
//	public static native int Le_Status();
//	public static native int ImprimeCodigoBarrasCODABAR(String codigo);
//	public static native int ImprimeCodigoBarrasCODE128(String codigo);
//	public static native int ImprimeCodigoBarrasCODE39(String codigo);
//	public static native int ImprimeCodigoBarrasCODE93(String codigo);
//	public static native int ImprimeCodigoBarrasEAN13(String codigo);
//	public static native int ImprimeCodigoBarrasEAN8(String codigo);
//	public static native int ImprimeCodigoBarrasISBN(String codigo);
//	public static native int ImprimeCodigoBarrasPDF417(int NivelCorrecaoErros, int Altura, int Largura, int Colunas, String Codigo);
//	public static native int ImprimeCodigoBarrasUPCA(String codigo);
//	public static native int ConfiguraCodigoBarras(int Altura, int Largura, int PosicaoCaracteres, int Fonte, int Margem);
//	public static native int CaracterGrafico(String bufferCaracter, int tamanho );
//	public static native int LeituraStatusEstendido(byte[] bytestatus);
//	public static native int PrinterReset();
//        
//        
//        static
//	{
//		String OSName = System.getProperty("os.name");
//		OSName = OSName.toLowerCase();
//
//		if (OSName.contains("linux"))
//		{
//			System.loadLibrary("BemaFI64");
//		}
//		else
//		{
//			System.loadLibrary("BemaFI64");
//		}
//	}
//}