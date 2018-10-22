package model;

public class Motorista {

	enum TipoCNH {
		B, C;
	}

	private String id;

	private String nome;

	private String dataNasc;

	private String endereco;

	private TipoCNH tipoCNH;

	private boolean disponivel;

	private String CNH;

	public Motorista( String nome, String dataNasc, String endereco, char tipoCNH, String cNH, boolean validacao ) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.setTipoCNH( tipoCNH );
		this.CNH = cNH;
		this.setDisponivel( validacao );
	}

	public String getId() {
		return this.id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc( String dataNasc ) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco( String endereco ) {
		this.endereco = endereco;
	}

	public TipoCNH getTipoCNH() {
		return this.tipoCNH;
	}

	public void setTipoCNH( char tipoCNH ) {
		if ( tipoCNH == 'B' ) {
			this.tipoCNH = TipoCNH.B;
		} else if ( tipoCNH == 'C' ) {
			this.tipoCNH = TipoCNH.C;
		}
	}

	public String getCNH() {
		return this.CNH;
	}

	public void setCNH( String CNH ) {
		this.CNH = CNH;
	}

	public boolean isDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel( boolean disponibilidade ) {
		this.disponivel = disponibilidade;
	}

	@Override
	public String toString() {
		String motorista = "nome:" + this.nome + ",dataNasc:" + this.dataNasc + ",endereco:" + this.endereco + ",tipoCNH:" + this.tipoCNH + ",CNH:" + this.CNH;
		return motorista;
	}
}
