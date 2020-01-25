package assemblers;

import datos.ReservaVuelo;
import dto.DTOReserva;

public class AssemblerReserva {

	public static DTOReserva reservaAssembler(ReservaVuelo r) {
		return new DTOReserva(r.getCodigo(), r.getNumAsientos(), r.getImporte(), r.getFechaReserva(),
				r.getNumeroPasajeros(), r.getNombrePasajeros(), r.getUsuarios(), r.getVuelos());
	}

	public static ReservaVuelo usuarioDisassembler(DTOReserva r) {

		return new ReservaVuelo(r.getCodigo(), r.getNumAsientos(), r.getImporte(), r.getFechaReserva(),
				r.getNumeroPasajeros(), r.getNombrePasajeros(), r.getUsuarios(), r.getVuelos());
	}
}
