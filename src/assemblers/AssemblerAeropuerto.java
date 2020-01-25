package assemblers;

import datos.Aeropuerto;
import dto.DTOAeropuerto;

public class AssemblerAeropuerto {

	public static DTOAeropuerto aeropuertoAssembler(Aeropuerto a) {
		return new DTOAeropuerto(a.getCodigo(), a.getPais(), a.getCiudad(), a.getNombre());
	}

	public static Aeropuerto usuarioDisassembler(DTOAeropuerto a) {

		return new Aeropuerto(a.getCodigo(), a.getPais(), a.getCiudad(), a.getNombre());
	}
}
