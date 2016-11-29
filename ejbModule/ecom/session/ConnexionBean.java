package ecom.session;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ecom.entities.User;
import ecom.util.BCrypt;

/**
 * Session Bean implementation class ConnexionBean
 */
@Stateless
@LocalBean
public class ConnexionBean implements ConnexionBeanLocal {

	@PersistenceContext(unitName = "ecomEJB")
	private EntityManager emanager;

	/**
	 * Default constructor.
	 */
	public ConnexionBean() {
		// TODO Auto-generated constructor stub
	}

	public User ConnectClient(String mail, String pwd) {
		Query q = emanager.createNamedQuery("User.findByEmail");

		q.setParameter("userEmail", mail);

		User u = (User) q.getSingleResult();

		if (u != null && BCrypt.checkpw(pwd, u.getPasswdHash())) {
			u.setCarpoolingReservations(null);
			u.setTaxiReservations(null);
			u.setPasswdHash("");
			return u;
		} else {
			return null;
		}
	}

	public User CreateUser(String address, String firstName, String lastName,
			Date birthDate, String city, String country, String email,
			String pwd, String phone, String zip) {
		Query q = emanager.createNamedQuery("User.findByEmail");

		q.setParameter("userEmail", email);

		User ures = (User) q.getSingleResult();

		if (ures == null) {
			User u = new User();

			u.setAccountCreationDate(new Date());
			u.setAddress(address);
			u.setBirthDate(birthDate);
			u.setCity(city);
			u.setCountry(country);
			u.setEmail(email);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setPasswdHash(BCrypt.hashpw(pwd, BCrypt.gensalt()));
			u.setPhone(phone);
			u.setZip(zip);

			emanager.persist(u);

			ures = ConnectClient(email, pwd);

			ures.setCarpoolingReservations(null);
			ures.setTaxiReservations(null);
			ures.setPasswdHash("");

			return ures;
		} else {
			return null;
		}

	}

}
