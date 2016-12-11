package ecom.session;

import java.util.List;

import javax.ejb.Local;

import ecom.entities.CarpoolingReservation;
import ecom.entities.TaxiReservation;

/**
 * Session Bean implementation class WayFinder
 */
@Local
public interface ReservationFinderLocal {
	public List<CarpoolingReservation> getCarpoolingReservation(int idUser);

	public List<TaxiReservation> getTaxiReservation(int idUser);
}
