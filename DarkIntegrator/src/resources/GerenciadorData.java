package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

	public Date ConvertDate( String data ) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
		return df.parse( data );

	}

	public Date dateAtual() throws ParseException {
		Date dateAtual = new Date();
		return dateAtual;
	}
}
