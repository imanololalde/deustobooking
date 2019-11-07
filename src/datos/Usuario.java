package datos;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String nickname;
	private String nombre;
	private String email;
	private String apellidos;
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Usuario(String nombre, String nickname, String email) {
		this.nombre = nombre;
		this.nickname = nickname;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		char valor;

		for(char i = 0; i < email.length(); i++) {
			valor = email.charAt(i);
			if(valor == '@' && i == 0){
				System.out.println("El correo esta mal");
				break;
			}
			this.email = email;
		}
	}
}
