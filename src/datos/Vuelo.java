package datos;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {

	@PrimaryKey
	private String codigoVuelo;
	private Date fecha;
	private int asientosDisponibles;
	private int asientosTotales;
	private String horaSalida;
	private String horaLlegada;
	private double precio;
	
	
	public Vuelo(String codigoVuelo, Aeropuerto salida, Aeropuerto destino) {
		this.codigoVuelo = codigoVuelo;
	}


	public String getCodigoVuelo() {
		return codigoVuelo;
	}


	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}


	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}


	public int getAsientosTotales() {
		return asientosTotales;
	}


	public void setAsientosTotales(int asientosTotales) {
		this.asientosTotales = asientosTotales;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public String getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
