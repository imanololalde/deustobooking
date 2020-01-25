package assemblers;

import datos.Aerolinea;
import dto.DTOAerolinea;

public class AssemblerAerolinea {

	public static DTOAerolinea aeropuertoAssembler(Aerolinea a) {
		return new DTOAerolinea(a.getCodigoAerolinea(), a.getNombre());
	}

	public static Aerolinea usuarioDisassembler(DTOAerolinea a) {

		return new Aerolinea(a.getCodigoAerolinea(), a.getNombre());
	}
}
