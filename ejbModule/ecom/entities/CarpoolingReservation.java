package ecom.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CarpoolingReservation database table.
 * 
 */
@Entity
@NamedQuery(name="CarpoolingReservation.findAll", query="SELECT c FROM CarpoolingReservation c")
public class CarpoolingReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReserved;

	@Temporal(TemporalType.DATE)
	private Date day;

	private int reservedSeats;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="reservedFor")
	private User user;

	public CarpoolingReservation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReserved() {
		return this.dateReserved;
	}

	public void setDateReserved(Date dateReserved) {
		this.dateReserved = dateReserved;
	}

	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getReservedSeats() {
		return this.reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}