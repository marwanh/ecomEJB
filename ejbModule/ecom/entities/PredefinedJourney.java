package ecom.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PredefinedJourney database table.
 *
 */
@Entity
@Table(name = "PredefinedJourney")
@NamedQueries({
		@NamedQuery(name = "PredefinedJourney.findAll", query = "SELECT p FROM PredefinedJourney p"),
		@NamedQuery(name = "PredefinedJourney.findAllByDate", query = "SELECT p FROM PredefinedJourney p WHERE p.serviceEnd > :dateUser AND p.serviceEnd > :dateToday"),
		@NamedQuery(name = "PredefinedJourney.findById", query = "SELECT p FROM PredefinedJourney p WHERE p.id = :id") })
public class PredefinedJourney implements Serializable {
	private static final long serialVersionUID = 1L;

	private String arrivalCity;

	private String arrivalLocation;

	// bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name = "car")
	private Car carBean;

	@OneToMany(mappedBy = "journey")
	private List<CarpoolingReservation> carpoolingReservations;

	private String days;

	private String departureCity;

	private String departureLocation;

	private String departureTime;

	private String duration;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date serviceEnd;

	public PredefinedJourney() {
	}

	public CarpoolingReservation addCarpoolingReservation(
			CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().add(carpoolingReservation);
		carpoolingReservation.setJourney(this);

		return carpoolingReservation;
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

	public List<CarpoolingReservation> getCarpoolingReservations() {
		return this.carpoolingReservations;
	}

	public String getDays() {
		return this.days;
	}

	public String getDepartureCity() {
		return this.departureCity;
	}

	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public String getDepartureTime() {
		return this.departureTime;
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

	public Date getServiceEnd() {
		return this.serviceEnd;
	}

	public CarpoolingReservation removeCarpoolingReservation(
			CarpoolingReservation carpoolingReservation) {
		getCarpoolingReservations().remove(carpoolingReservation);
		carpoolingReservation.setJourney(null);

		return carpoolingReservation;
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

	public void setCarpoolingReservations(
			List<CarpoolingReservation> carpoolingReservations) {
		this.carpoolingReservations = carpoolingReservations;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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

	public void setServiceEnd(Date serviceEnd) {
		this.serviceEnd = serviceEnd;
	}

}