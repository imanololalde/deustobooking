package datos;

import java.util.Date;

public class TransaccionDePago {
	
	
	private Date FechaPago;
	private String CodigoConfirmacion;
	
	public TransaccionDePago() {

	}

	public Date getFechaPago() {
		return FechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		FechaPago = fechaPago;
	}

	public String getCodigoConfirmacion() {
		return CodigoConfirmacion;
	}

	public void setCodigoConfirmacion(String codigoConfirmacion) {
		CodigoConfirmacion = codigoConfirmacion;
	}
}
