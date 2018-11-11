package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String username;
	private String senha;
	private String salt;
	
	public Usuario(int id, String nome, String sobrenome, String username, String senha, String salt) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.senha = senha;
		this.salt = salt;
		
	}
	
	public Usuario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}	
}
