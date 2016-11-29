package ecom.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TaxiReservation database table.
 * 
 */
@Entity
@NamedQuery(name="TaxiReservation.findAll", query="SELECT t FROM TaxiReservation t")
public class TaxiReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String arrivalCity;

	private String arrivalLocation;

	private String departureCity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDateTime;

	private String departureLocation;

	private String duration;

	private float price;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="reservedFor")
	private User user;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="car")
	private Car carBean;

	public TaxiReservation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArrivalCity() {
		return this.arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalLocation() {
		return this.arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getDepartureCity() {
		return this.departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public Date getDepartureDateTime() {
		return this.departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCarBean() {
		return this.carBean;
	}

	public void setCarBean(Car carBean) {
		this.carBean = carBean;
	}

}