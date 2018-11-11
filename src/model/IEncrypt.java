package model;

public interface IEncrypt {
	
	//Gera o hash da senha
	public String encrypt(String senha, String salt);

	public String gerarSalt();
}
