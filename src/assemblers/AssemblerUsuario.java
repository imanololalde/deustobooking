package assemblers;

import datos.Usuario;
import dto.DTOUsuario;

public class AssemblerUsuario {
	
	public static DTOUsuario usuarioAssembler(Usuario u) {
		return new DTOUsuario(u.getNombre(),u.getSisAutorizacion());
	}
	
	public static Usuario usuarioDisassembler(DTOUsuario u) {
		return new Usuario(u.getNombre(),null,u.getSisAutorizacion());
	}
}
