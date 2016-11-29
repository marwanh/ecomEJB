package ecom.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PredefinedJourney database table.
 * 
 */
@Entity
@NamedQuery(name="PredefinedJourney.findAll", query="SELECT p FROM PredefinedJourney p")
public class PredefinedJourney implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String arrivalCity;

	private String arrivalLocation;

	private String days;

	private String departureCity;

	private String departureLocation;

	private String departureTime;

	private String duration;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date serviceEnd;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="car")
	private Car carBean;

	public PredefinedJourney() {
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

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getDepartureCity() {
		return this.departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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

	public Date getServiceEnd() {
		return this.serviceEnd;
	}

	public void setServiceEnd(Date serviceEnd) {
		this.serviceEnd = serviceEnd;
	}

	public Car getCarBean() {
		return this.carBean;
	}

	public void setCarBean(Car carBean) {
		this.carBean = carBean;
	}

}