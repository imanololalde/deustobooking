package datos;


public class Aeropuerto {

	private String codigo;
	private String nombre;
	
	public Aeropuerto(String nombre, String codigo) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
