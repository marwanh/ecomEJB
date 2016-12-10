package ecom.session;

import java.util.Date;

import javax.ejb.Local;

/**
 * Session Bean implementation class WayFinder
 */
@Local
public interface WayReservationLocal {
	public boolean WayReservationCovoiturage(int idPredefinedJourney,
			int idUser, Date departure);

	public boolean WayReservationTaxi(int idUser, String departureCity,
			String departureLocation, String arrivalCity,
			String arrivalLocation, Date departureDateTime, String duration,
			float price);
}
