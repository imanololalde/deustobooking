package datos;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class TarjetaDeCredito extends tipoDePago{
	
	private long numero;
	private String nombreTitular;
	private Date fechaCaducidad;
	private int CCV;
	
	

	public TarjetaDeCredito(long numero, String nombreTitular, Date fechaCaducidad, int CCV) {
		super();
		this.numero = numero;
		this.nombreTitular = nombreTitular;
		this.fechaCaducidad = fechaCaducidad;
		this.CCV = CCV;
	}
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getCCV() {
		return CCV;
	}
	public void setCCV(int cCV) {
		CCV = cCV;
	}
}
