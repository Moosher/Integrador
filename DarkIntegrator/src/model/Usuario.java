package model;

public class Usuario {

	private String id;
	
	private String login;

	private String senha;

	public Usuario( String login, String senha ) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin( String login ) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha( String senha ) {
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
