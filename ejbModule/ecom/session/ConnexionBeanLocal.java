package ecom.session;

import java.util.Date;

import javax.ejb.Local;

import ecom.entities.User;

@Local
public interface ConnexionBeanLocal {
	public User ConnectClient(String mail, String pwd);

	public User CreateUser(String address, String firstName, String lastName,
			Date birthDate, String city, String country, String email,
			String pwd, String phone, String zip);
}
