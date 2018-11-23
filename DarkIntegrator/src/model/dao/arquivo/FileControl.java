package model.dao.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import resources.AppConsts;

public class FileControl {

    private static final FileControl INSTANCE = new FileControl();

    public static FileControl getInstance() {
	return INSTANCE;
    }

    private FileControl() {
    }

    public void imprimirRecibo( String nomeRemetente, String enderecoRemetente, String nomeDestinatario, String enderecoDestinatario, String dataDeposito, double peso, String codLocalizador )
	    throws IOException {
	BufferedWriter bw = null;
	try {
	    bw = new BufferedWriter( new FileWriter( new File( AppConsts.CAMINHO_RECIBO ) ) );

	    bw.write( "Transportadora Entrega Rápida" );
	    bw.newLine();
	    bw.write( "Recibo " );
	    bw.newLine();
	    bw.write( "Código localizador: " + codLocalizador );
	    bw.newLine();
	    bw.write( "Nome do remetente: " + nomeRemetente );
	    bw.newLine();
	    bw.write( "Endereço do remetente: " + enderecoRemetente );
	    bw.newLine();
	    bw.write( "Nome do destinatário: " + nomeDestinatario );
	    bw.newLine();
	    bw.write( "Endereço do destinatário: " + enderecoDestinatario );
	    bw.newLine();
	    bw.write( "Data de depósito do objeto na empresa: " + dataDeposito );
	    bw.newLine();
	    bw.write( "Peso do objeto:" + peso );

	} catch ( IOException e ) {
	    e.printStackTrace();
	} finally {
	    bw.close();
	}
    }

    public String gerarId() {
	Date date = new Date();
	long idlongo = date.getTime();
	String id = String.valueOf( idlongo );
	id = id.substring( id.length() - 7 );
	return id;
    }

}
