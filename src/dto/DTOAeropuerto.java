package dto;

public class DTOAeropuerto {	
	private String codigo;
	private String pais;
	private String ciudad;
	private String nombre;
	
	
	
	public DTOAeropuerto(String codigo, String pais, String ciudad, String nombre) {
		this.codigo = codigo;
		this.pais = pais;
		this.ciudad = ciudad;
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
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
