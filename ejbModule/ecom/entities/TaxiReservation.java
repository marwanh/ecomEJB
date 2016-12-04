package ecom.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TaxiReservation database table.
 *
 */
@Entity
@Table(name = "TaxiReservation")
@NamedQuery(name = "TaxiReservation.findAll", query = "SELECT t FROM TaxiReservation t")
public class TaxiReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String arrivalCity;

	private String arrivalLocation;

	// bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name = "car")
	private Car carBean;

	private String departureCity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDateTime;

	private String departureLocation;

	private String duration;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private float price;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "reservedFor")
	private User user;

	public TaxiReservation() {
	}

	public String getArrivalCity() {
		return this.arrivalCity;
	}

	public String getArrivalLocation() {
		return this.arrivalLocation;
	}

	public Car getCarBean() {
		return this.carBean;
	}

	public String getDepartureCity() {
		return this.departureCity;
	}

	public Date getDepartureDateTime() {
		return this.departureDateTime;
	}

	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public String getDuration() {
		return this.duration;
	}

	public int getId() {
		return this.id;
	}

	public float getPrice() {
		return this.price;
	}

	public User getUser() {
		return this.user;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public void setCarBean(Car carBean) {
		this.carBean = carBean;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setUser(User user) {
		this.user = user;
	}

}