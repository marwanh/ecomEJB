package ecom.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CarpoolingReservation database table.
 *
 */
@Entity
@Table(name = "CarpoolingReservation")
@NamedQueries({
		@NamedQuery(name = "CarpoolingReservation.findAll", query = "SELECT c FROM CarpoolingReservation c"),
		@NamedQuery(name = "CarpoolingReservation.countByJourneyAndDate", query = "SELECT COUNT(c) FROM CarpoolingReservation c WHERE c.journey.id = :journeyId AND c.day = :date"),
		@NamedQuery(name = "CarpoolingReservation.findByUserId", query = "SELECT c FROM CarpoolingReservation c WHERE c.user.id = :userId ORDER BY c.dateReserved DESC") })
public class CarpoolingReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReserved;

	@Temporal(TemporalType.DATE)
	private Date day;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "journey")
	private PredefinedJourney journey;

	private int reservedSeats;

	// bi-directional many-to-one association to User
	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "reservedFor")
	private User user;

	public CarpoolingReservation() {
	}

	public Date getDateReserved() {
		return this.dateReserved;
	}

	public Date getDay() {
		return this.day;
	}

	public int getId() {
		return this.id;
	}

	public PredefinedJourney getJourney() {
		return this.journey;
	}

	public int getReservedSeats() {
		return this.reservedSeats;
	}

	public User getUser() {
		return this.user;
	}

	public void setDateReserved(Date dateReserved) {
		this.dateReserved = dateReserved;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setJourney(PredefinedJourney journey) {
		this.journey = journey;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public void setUser(User user) {
		this.user = user;
	}

}