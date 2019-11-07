package datos;

import java.util.Date;
import java.util.Random;

public class Vuelo {

	private String codigo;
	private Date fecha;
	private double precio;
	
	public Vuelo(double precio, Aeropuerto salida, Aeropuerto destino) {
		Random cod = new Random();
		this.codigo = String.valueOf(cod.nextDouble());
		this.fecha = new Date();
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
