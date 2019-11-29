package datos;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class TarjetaDeCredito extends tipoDePago{
	
	private long numeroTarjeta;
	private String nombreTitular;
	private Date fechaCaducidad;
	private int CCV;
	
	public TarjetaDeCredito() {
		
	}
	
	public long getNumero() {
		return numeroTarjeta;
	}
	
	public void setNumero(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
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
	
	public void setCCV(int ccv) {
		CCV = ccv;
	}
	
}
