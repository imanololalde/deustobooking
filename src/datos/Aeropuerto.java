package datos;

import java.util.Random;

public class Aeropuerto {

	private String codigo;
	private String nombre;
	
	public Aeropuerto(String nombre) {
		Random cod = new Random();
		this.codigo = String.valueOf(cod.nextDouble());
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
