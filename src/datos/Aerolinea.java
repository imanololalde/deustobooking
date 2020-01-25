package datos;

public class Aerolinea {
	
	private String codigoAerolinea;
	private String nombre;
	
	public Aerolinea(String codigoAerolinea, String nombre) {
		this.codigoAerolinea = codigoAerolinea;
		this.nombre = nombre;
	}
	
	public String getCodigoAerolinea() {
		return codigoAerolinea;
	}
	
	public void setCodigoAerolinea(String codigoAerolinea) {
		this.codigoAerolinea = codigoAerolinea;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
