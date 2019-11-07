package datos;

import java.util.Date;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ReservaVuelo {
	
	@PrimaryKey
	private String codigo;
	@NotPersistent
	private int num_asientos;
	private double importe;
	@NotPersistent
	private Date fechaReserva;
	private int numeroPasajeros;
	@NotPersistent
	private String[] nombrePasajeros;
	
	
	
	public ReservaVuelo(Usuario u, Vuelo v, int num_asientos, double importe) {
		
	}
	
	public int getNum_asientos() {
		return num_asientos;
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

	public void setNum_asientos(int num_asientos) {
		this.num_asientos = num_asientos;
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
