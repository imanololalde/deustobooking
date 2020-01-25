package dto;

import java.util.ArrayList;
import java.util.Date;

import datos.Aeropuerto;

public class DTOVuelo {
	
private String codigoVuelo;
	
	private Date fecha;
	private int asientosDisponibles;
	private int asientosTotales;
	private String horaSalida;
	private String horaLlegada;
	private double precio;
	private ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
	
	public void addElement(Aeropuerto aeropuerto) {
		this.aeropuertos.add(aeropuerto);
	}
	
	public void removeElement(int index) {
		aeropuertos.remove(index);
	}
	
	public ArrayList<Aeropuerto> getAeropuerto() {
		return aeropuertos;
	}

	public void setAeropuerto(ArrayList<Aeropuerto> aeropuerto) {
		this.aeropuertos = aeropuerto;
	}

	public DTOVuelo(String codigoVuelo, Date fecha, int asientosDisponibles, int asientosTotales, String horaSalida,
			String horaLlegada, double precio, ArrayList<Aeropuerto> aeropuertos) {
		this.codigoVuelo = codigoVuelo;
		this.fecha = fecha;
		this.asientosDisponibles = asientosDisponibles;
		this.asientosTotales = asientosTotales;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.precio = precio;
		this.aeropuertos = aeropuertos;
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
