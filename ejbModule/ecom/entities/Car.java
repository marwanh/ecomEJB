package ecom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Car database table.
 *
 */
@Entity
@Table(name = "Car")
@NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte available;

	private String currentLocation;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String immatriculation;

	// bi-directional many-to-one association to PredefinedJourney
	@OneToMany(mappedBy = "carBean")
	private List<PredefinedJourney> predefinedJourneys;

	private int seats;

	private byte taxi;

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

	public byte getAvailable() {
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

	public byte getTaxi() {
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

	public void setAvailable(byte available) {
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

	public void setTaxi(byte taxi) {
		this.taxi = taxi;
	}

	public void setTaxiReservations(List<TaxiReservation> taxiReservations) {
		this.taxiReservations = taxiReservations;
	}

}