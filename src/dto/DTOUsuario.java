package dto;

public class DTOUsuario {

	private int sisAutorizacion;
	private String nombre;
	
	
	public DTOUsuario(String nombre, int sisAutorizacion) {
		
		this.nombre = nombre;
		this.sisAutorizacion = sisAutorizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSisAutorizacion() {
		return sisAutorizacion;
	}

	public void setSisAutorizacion(int sisAutorizacion) {
		this.sisAutorizacion = sisAutorizacion;
	}
	
	
}
