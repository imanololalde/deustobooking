package datos;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ReservaVuelo {
	
	@PrimaryKey
	private String codigo;

	private int numAsientos;
	private double importe;
	private Date fechaReserva;
	private int numeroPasajeros;
	private String[] nombrePasajeros;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	
	public void addVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);
	}
	
	public void removeVuelo(int index) {
		vuelos.remove(index);
	}
	
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void removeUsuario(int index) {
		usuarios.remove(index);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public ReservaVuelo() {
		
	}
	
	public int getNumAsientos() {
		return numAsientos;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}

	public void setNumeroPasajeros(int numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}

	public String[] getNombrePasajeros() {
		return nombrePasajeros;
	}

	public void setNombrePasajeros(String[] nombrePasajeros) {
		this.nombrePasajeros = nombrePasajeros;
	}
	
}
