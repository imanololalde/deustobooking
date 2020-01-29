package dao;

import java.util.List;

import datos.ReservaVuelo;
import datos.Usuario;

public interface IDeustoBookingDAO {
	public void registrarUsuario(Usuario u);
	public void guardarReserva(ReservaVuelo reservation);
	public Usuario getUsuario(String nombre);
	public List<ReservaVuelo> getReserva(Usuario u);
}
