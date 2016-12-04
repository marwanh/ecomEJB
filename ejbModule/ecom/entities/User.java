package ecom.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the User database table.
 *
 */
@Entity
@Table(name = "User")
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email LIKE :userEmail") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date accountCreationDate;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	// bi-directional many-to-one association to CarpoolingReservation
	@OneToMany(mappedBy = "user")
	private List<CarpoolingReservation> carpoolingReservations;

	private String city;

	private String country;

	private String email;

	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String lastName;

	private String passwdHash;

	private String phone;

	// bi-directional many-to-one association to TaxiReservation
	@OneToMany(mappedBy = "user")
	private List<TaxiReservation> taxiReservations;

	private String zip;

	public User() {
	}

	public CarpoolingReservation addCarpoolingReservation(
			CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().add(carpoolingReservation);
		carpoolingReservation.setUser(this);

		return carpoolingReservation;
	}

	public TaxiReservation addTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().add(taxiReservation);
		taxiReservation.setUser(this);

		return taxiReservation;
	}

	public Date getAccountCreationDate() {
		return this.accountCreationDate;
	}

	public String getAddress() {
		return this.address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public List<CarpoolingReservation> getCarpoolingReservations() {
		return this.carpoolingReservations;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
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

	public List<TaxiReservation> getTaxiReservations() {
		return this.taxiReservations;
	}

	public String getZip() {
		return this.zip;
	}

	public CarpoolingReservation removeCarpoolingReservation(
			CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().remove(carpoolingReservation);
		carpoolingReservation.setUser(null);

		return carpoolingReservation;
	}

	public TaxiReservation removeTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().remove(taxiReservation);
		taxiReservation.setUser(null);

		return taxiReservation;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setCarpoolingReservations(
			List<CarpoolingReservation> carpoolingReservations) {
		this.carpoolingReservations = carpoolingReservations;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public void setTaxiReservations(List<TaxiReservation> taxiReservations) {
		this.taxiReservations = taxiReservations;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}