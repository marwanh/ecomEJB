package ecom.session;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import ecom.entities.User;

@Stateful
public class Connexion {

	private boolean connected = false;
	private User user = null;

	public Connexion() {
	}

	public Connexion(User user) {
		connected = true;
		this.user = user;
	}

	@Remove
	public void clientDisconnect() {
		disconnect();
	}

	public void connect() {
		this.connected = true;
	}

	public void disconnect() {
		this.connected = false;
	}

	public boolean getConnected() {
		return this.connected;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
