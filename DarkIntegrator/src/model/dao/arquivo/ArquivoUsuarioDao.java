package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

import model.Usuario;
import model.dao.UsuarioDao;
import resources.AppConsts;

public class ArquivoUsuarioDao implements UsuarioDao {

	Map<String, String> usuarios;

	public ArquivoUsuarioDao() {
		if (this.usuarios == null) {
			this.usuarios = new HashMap();
			this.usuarios.put("fernando", "fernando");
		}
	}

	@Override
	public void adicionarUsuario(String nome, String senha) {

		if (this.usuarios.get(nome) == null) {
			this.usuarios.put(nome, senha);
			try {
				this.salvarArquivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Usuario(nome, senha);
		}
	}

	@Override
	public Map<String, String> getUsuarios() {
		return this.usuarios;
	}

	@Override
	public boolean validacao(String login, String senha) {

		Set<String> chaves = this.usuarios.keySet();

		for (String chave : chaves) {
			this.usuarios.get(chave);
			if (login.equals(chave) && senha.equals(this.usuarios.get(chave))) {
				return true;
			}

		}

		return false;
	}

	@Override
	public void removerUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstUsuario = gson.toJson(this.usuarios);

		try {
			lstJson = new FileWriter(AppConsts.CAMINHO_USUARIO, false);
			lstJson.write(lstUsuario);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File(AppConsts.CAMINHO_USUARIO);
		if (file.exists()) {
			BufferedReader lstUsuario = null;
			Gson gson = new Gson();
			try {
				lstUsuario = new BufferedReader(new FileReader(AppConsts.CAMINHO_USUARIO));
				Usuario[] usuarioArray = gson.fromJson(lstUsuario, Usuario[].class);
				this.usuarios.clear();
				// TODO Fernando..
				// usuarios.addAll(Arrays.asList(usuarioArray));

			} finally {
				lstUsuario.close();
			}
		} else {
			this.salvarArquivo();
		}
	}

}
