package login;

import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

import model.IEncrypt;
import model.Usuario;
import persistence.UsuarioDAO;
import security.BCrypt;
import security.BCryptEncryptor;


public class Main {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		int opt;
		
		System.out.println("Escolha uma das opções abaixo");
		
		do {
			System.out.println("[1] - Cadastrar usuário");
			System.out.println("[2] - Logar na página");
			System.out.println("[0] - Sair");
			opt = scanner.nextInt();
			
			switch (opt) {
			case 1:
				Usuario usuario = new Usuario();
				System.out.println("Cadastro de usuário");
				System.out.println();
				scanner.nextLine();
				System.out.println("Digite seu nome de usuario");
				usuario.setUsername(scanner.nextLine());
				try {
					Usuario usuarioPesquisa = UsuarioDAO.getByUsername(usuario.getUsername());
					
					if (usuarioPesquisa != null) {
						System.out.println("Já existe um usuario com esse username");
					} else {
						System.out.println("Digite seu nome");
						usuario.setNome(scanner.nextLine());
						System.out.println("Digite seu sobrenome");
						usuario.setSobrenome(scanner.nextLine());
						System.out.println("Digite sua senha");
						IEncrypt bcrypt = new BCryptEncryptor();
						String salt = bcrypt.gerarSalt();
						String stringHasheada = bcrypt.encrypt(scanner.nextLine(), salt);
						usuario.setSenha(stringHasheada);
						usuario.setSalt(salt);
						UsuarioDAO.insert(usuario);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//recebe senha, transforma em hash, e adiciona o salt
				break;
			case 2:
				System.out.println("Login");
				System.out.println();
				scanner.nextLine();
				System.out.println("Digite seu nome de usuário");
				String nome = scanner.nextLine();
				System.out.println("Digite sua senha");
				String senha = scanner.nextLine();
				
				try {

					Usuario usuarioPesquisa = UsuarioDAO.getByUsername(nome);
					if(usuarioPesquisa != null) {
						IEncrypt bcrypt = new BCryptEncryptor();
						String senhaHasheada = bcrypt.encrypt(senha, usuarioPesquisa.getSalt());
						if (senhaHasheada.equals(usuarioPesquisa.getSenha())) {
							System.out.println("Nome: " + usuarioPesquisa.getNome());
							System.out.println("Sobrenome: " + usuarioPesquisa.getSobrenome());
//							System.out.println(usuario.getCpf());
							System.out.println();
						} else {
							//Quando a senha está incorreta
							System.out.println("Dados de entrada incorretos");
						}
						
					} else {
						//Quando usuario não existe
						System.out.println("Dados de entrada incorretos");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 0:
				System.out.println("Saindo...");
				System.out.println();
				System.exit(0);
				break;
				
			default:
				System.out.println("Opção invalida!");
				System.out.println();
			}
		} while (opt != 0);
	}
}
