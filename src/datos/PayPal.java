package datos;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class PayPal extends tipoDePago{
	
	private String email;

	public PayPal() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
