package datos;

import java.util.ArrayList;
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
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;

	public Vuelo(String codigoVuelo, Date fecha, int asientosDisponibles, int asientosTotales, String horaSalida,
			String horaLlegada, double precio, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino) {
		this.codigoVuelo = codigoVuelo;
		this.fecha = fecha;
		this.asientosDisponibles = asientosDisponibles;
		this.asientosTotales = asientosTotales;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.precio = precio;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
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
