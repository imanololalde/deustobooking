package datos;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String nombre;
	private String email;
	private int sisAutorizacion;
	
	

	public Usuario(String nombre, String email, int sisAutorizacion) {
		this.nombre = nombre;
		this.email = email;
		this.sisAutorizacion = sisAutorizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSisAutorizacion() {
		return sisAutorizacion;
	}

	public void setSisAutorizacion(int sisAutorizacion) {
		this.sisAutorizacion = sisAutorizacion;
	}
	
}
