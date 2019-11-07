package datos;

import java.util.Random;

public class ReservaVuelo {

	private int num_asiento;
	private double importe;
	private String codigo;
	
	public ReservaVuelo(Usuario u, Vuelo v, int num_asiento, double importe) {
		Random cod = new Random();
		this.codigo = String.valueOf(cod.nextDouble());
		this.importe = importe;
		this.num_asiento = num_asiento;
	}
	
	public int getNum_asiento() {
		return num_asiento;
	}

	public void setNum_asiento(int num_asiento) {
		this.num_asiento = num_asiento;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String ReservaToString() {
		String reserva = "Codigo: "+ codigo + " Importe: " + String.valueOf(importe) + " Numero de asiento: " +String.valueOf(num_asiento);
		return reserva;
	}
}
