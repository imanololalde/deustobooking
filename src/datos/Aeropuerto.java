package datos;

public class Aeropuerto {
	
	private String codigo;
	private String pais;
	private String ciudad;
	private String nombre;
	
	public String getPais() {
		return pais;
	}
	
	public Aeropuerto(String nombre, String codigo) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
