package assemblers;

import datos.Vuelo;
import dto.DTOVuelo;

public class AssemblerVuelo {

	public static DTOVuelo vueloAssembler(Vuelo v) {
		return new DTOVuelo(v.getCodigoVuelo(), v.getFecha(), v.getAsientosDisponibles(), v.getAsientosTotales(),
				v.getHoraSalida(), v.getHoraLlegada(), v.getPrecio(), v.getAeropuertoOrigen(), v.getAeropuertoDestino());
	}

	public static Vuelo usuarioDisassembler(DTOVuelo v) {

		return new Vuelo(v.getCodigoVuelo(), v.getFecha(), v.getAsientosDisponibles(), v.getAsientosTotales(),
				v.getHoraSalida(), v.getHoraLlegada(), v.getPrecio(), v.getAeropuertoOrigen(), v.getAeropuertoDestino());
	}
}
