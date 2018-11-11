package security;

import model.IEncrypt;

public class BCryptEncryptor implements IEncrypt {

	@Override
	public String encrypt(String senha, String salt) {
	    
		// Gera a senha hasheada utilizando o sal gerado
	    String senhaHasheada = BCrypt.hashpw(senha, salt);
		
	    return senhaHasheada;
	}

	@Override
	public String gerarSalt() {
	    // Gera um sal aleatório
	    String salGerado = BCrypt.gensalt();
		
	    return salGerado;
	}
}
