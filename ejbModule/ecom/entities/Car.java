package ecom.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte available;

	private String currentLocation;

	private String immatriculation;

	private int seats;

	private byte taxi;

	//bi-directional many-to-one association to PredefinedJourney
	@OneToMany(mappedBy="carBean")
	private List<PredefinedJourney> predefinedJourneys;

	//bi-directional many-to-one association to TaxiReservation
	@OneToMany(mappedBy="carBean")
	private List<TaxiReservation> taxiReservations;

	public Car() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAvailable() {
		return this.available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}

	public String getCurrentLocation() {
		return this.currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getImmatriculation() {
		return this.immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public byte getTaxi() {
		return this.taxi;
	}

	public void setTaxi(byte taxi) {
		this.taxi = taxi;
	}

	public List<PredefinedJourney> getPredefinedJourneys() {
		return this.predefinedJourneys;
	}

	public void setPredefinedJourneys(List<PredefinedJourney> predefinedJourneys) {
		this.predefinedJourneys = predefinedJourneys;
	}

	public PredefinedJourney addPredefinedJourney(PredefinedJourney predefinedJourney) {
		getPredefinedJourneys().add(predefinedJourney);
		predefinedJourney.setCarBean(this);

		return predefinedJourney;
	}

	public PredefinedJourney removePredefinedJourney(PredefinedJourney predefinedJourney) {
		getPredefinedJourneys().remove(predefinedJourney);
		predefinedJourney.setCarBean(null);

		return predefinedJourney;
	}

	public List<TaxiReservation> getTaxiReservations() {
		return this.taxiReservations;
	}

	public void setTaxiReservations(List<TaxiReservation> taxiReservations) {
		this.taxiReservations = taxiReservations;
	}

	public TaxiReservation addTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().add(taxiReservation);
		taxiReservation.setCarBean(this);

		return taxiReservation;
	}

	public TaxiReservation removeTaxiReservation(TaxiReservation taxiReservation) {
		getTaxiReservations().remove(taxiReservation);
		taxiReservation.setCarBean(null);

		return taxiReservation;
	}

}