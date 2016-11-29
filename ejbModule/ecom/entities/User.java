package ecom.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email LIKE :userEmail") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date accountCreationDate;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private String city;

	private String country;

	private String email;

	private String firstName;

	private String lastName;

	private String passwdHash;

	private String phone;

	private String zip;

	// bi-directional many-to-one association to CarpoolingReservation
	@OneToMany(mappedBy = "user")
	private List<CarpoolingReservation> carpoolingReservations;

	// bi-directional many-to-one association to TaxiReservation
	@OneToMany(mappedBy = "user")
	private List<TaxiReservation> taxiReservations;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAccountCreationDate() {
		return this.accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasswdHash() {
		return this.passwdHash;
	}

	public void setPasswdHash(String passwdHash) {
		this.passwdHash = passwdHash;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<CarpoolingReservation> getCarpoolingReservations() {
		return this.carpoolingReservations;
	}

	public void setCarpoolingReservations(List<CarpoolingReservation> carpoolingReservations) {
		this.carpoolingReservations = carpoolingReservations;
	}

	public CarpoolingReservation addCarpoolingReservation(CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().add(carpoolingReservation);
		carpoolingReservation.setUser(this);

		return carpoolingReservation;
	}

	public CarpoolingReservation removeCarpoolingReservation(CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().remove(carpoolingReservation);
		carpoolingReservation.setUser(null);

		return carpoolingReservation;
	}

	public List<TaxiReservation> getTaxiReservations() {
		return this.taxiReservations;
	}

	public void setTaxiReservations(List<TaxiReservation> taxiReservations) {
		this.taxiReservations = taxiReservations;
	}

	public TaxiReservation addTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().add(taxiReservation);
		taxiReservation.setUser(this);

		return taxiReservation;
	}

	public TaxiReservation removeTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().remove(taxiReservation);
		taxiReservation.setUser(null);

		return taxiReservation;
	}

}