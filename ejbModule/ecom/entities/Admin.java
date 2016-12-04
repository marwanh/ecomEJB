package ecom.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the Admin database table.
 *
 */
@Entity
@Table(name = "Admin")
@NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String lastName;

	private String passwdHash;

	private String phone;

	private String username;

	public Admin() {
	}

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public int getId() {
		return this.id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getPasswdHash() {
		return this.passwdHash;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPasswdHash(String passwdHash) {
		this.passwdHash = passwdHash;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}