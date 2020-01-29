package servidor;

import dto.DTOUsuario;

public class Façade {

	public static DTOUsuario registrarUsuario(String email, int sisAutorizacion) {
		DTOUsuario resultado = new DTOUsuario(email, sisAutorizacion);
		//registro en bdd
		return resultado;
	}

	public static DTOUsuario inicioSesion(String email, int sisAutorizacion, String nombre) {
		
		
		return null;
	}
}
