package ecom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Car database table.
 *
 */
@Entity
@Table(name = "Car")
@NamedQueries({
		@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
		@NamedQuery(name = "Car.findAllTaxi", query = "SELECT c FROM Car c WHERE c.taxi = 1"),
		@NamedQuery(name = "Car.findAllCarpooling", query = "SELECT c FROM Car c WHERE c.taxi = 0") })
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean available;

	private String currentLocation;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String immatriculation;

	// bi-directional many-to-one association to PredefinedJourney
	@OneToMany(mappedBy = "carBean")
	private List<PredefinedJourney> predefinedJourneys;

	private int seats;

	private boolean taxi;

	// bi-directional many-to-one association to TaxiReservation
	@OneToMany(mappedBy = "carBean")
	private List<TaxiReservation> taxiReservations;

	public Car() {
	}

	public PredefinedJourney addPredefinedJourney(
			PredefinedJourney predefinedJourney) {
		getPredefinedJourneys().add(predefinedJourney);
		predefinedJourney.setCarBean(this);

		return predefinedJourney;
	}

	public TaxiReservation addTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().add(taxiReservation);
		taxiReservation.setCarBean(this);

		return taxiReservation;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public String getCurrentLocation() {
		return this.currentLocation;
	}

	public int getId() {
		return this.id;
	}

	public String getImmatriculation() {
		return this.immatriculation;
	}

	public List<PredefinedJourney> getPredefinedJourneys() {
		return this.predefinedJourneys;
	}

	public int getSeats() {
		return this.seats;
	}

	public boolean getTaxi() {
		return this.taxi;
	}

	public List<TaxiReservation> getTaxiReservations() {
		return this.taxiReservations;
	}

	public PredefinedJourney removePredefinedJourney(
			PredefinedJourney predefinedJourney) {
		getPredefinedJourneys().remove(predefinedJourney);
		predefinedJourney.setCarBean(null);

		return predefinedJourney;
	}

	public TaxiReservation removeTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().remove(taxiReservation);
		taxiReservation.setCarBean(null);

		return taxiReservation;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public void setPredefinedJourneys(List<PredefinedJourney> predefinedJourneys) {
		this.predefinedJourneys = predefinedJourneys;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setTaxi(boolean taxi) {
		this.taxi = taxi;
	}

	public void setTaxiReservations(List<TaxiReservation> taxiReservations) {
		this.taxiReservations = taxiReservations;
	}

}