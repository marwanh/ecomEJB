package ecom.session;

import javax.ejb.Local;

import ecom.entities.User;

/**
 * Session Bean implementation class WayFinder
 */
@Local
public interface AccountBeanLocal {
	public User changeMail(int userId, String mail, String password);

	public User changePassword(int userId, String newpassword, String password);

	public User changePhone(int userId, String phone, String password);
}
