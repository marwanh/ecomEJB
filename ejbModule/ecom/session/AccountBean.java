package ecom.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ecom.entities.User;
import ecom.util.BCrypt;

/**
 * Session Bean implementation class WayFinder
 */
@Stateless
@LocalBean
public class AccountBean implements AccountBeanLocal {

	@PersistenceContext(unitName = "ecomEJB")
	private EntityManager emanager;

	/**
	 * Default constructor.
	 */
	public AccountBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User changeMail(int userId, String mail, String password) {
		User u = emanager.find(User.class, userId);

		if (BCrypt.checkpw(password, u.getPasswdHash())) {
			u.setEmail(mail);

			emanager.persist(u);

			emanager.flush();

			emanager.refresh(u);

			return u;
		} else {
			return null;
		}
	}

	@Override
	public User changePassword(int userId, String newpassword, String password) {
		User u = emanager.find(User.class, userId);

		if (BCrypt.checkpw(password, u.getPasswdHash())) {
			u.setPasswdHash(BCrypt.hashpw(newpassword, BCrypt.gensalt()));

			emanager.persist(u);

			emanager.flush();

			emanager.refresh(u);

			return u;
		} else {
			return null;
		}
	}

	@Override
	public User changePhone(int userId, String phone, String password) {
		User u = emanager.find(User.class, userId);

		if (BCrypt.checkpw(password, u.getPasswdHash())) {
			u.setPhone(phone);

			emanager.persist(u);

			emanager.flush();

			emanager.refresh(u);

			return u;
		} else {
			return null;
		}
	}
}
