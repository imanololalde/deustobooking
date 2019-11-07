package datos;

public class Usuario {

	private String nombre;
	private String nickname;
	private String email;
	
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