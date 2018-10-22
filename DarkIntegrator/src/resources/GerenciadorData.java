package resources;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerenciadorData {

	private static GerenciadorData instance;

	public static GerenciadorData getInstance() {
		return instance == null ? instance = new GerenciadorData() : instance;
	}

	public String dataAtual() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "HH:mm dd/MM/yyyy" );
		LocalDateTime localDate = LocalDateTime.now();
		String dataAtual = dtf.format( localDate );
		return dataAtual;
	}

	public Date strToDate( String s ) {
		SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd" );//formato de entrada
		java.sql.Date data = new Date( new java.util.Date().getTime() );
		if ( s != null && !s.isEmpty() ) {
			try {
				java.util.Date d = sdf1.parse( s );
				sdf1.applyPattern( "dd/MM/yyyy" );//formato de saída
				java.sql.Date dataFinal = new Date( d.getTime() );
				return dataFinal;
			} catch ( ParseException e ) {
				e.printStackTrace();
			}

		}
		return data;//nunca ocorre
	}

	public java.util.Date dateAtual() throws ParseException {
		java.util.Date dateAtual = new java.util.Date();
		return dateAtual;
	}
}
