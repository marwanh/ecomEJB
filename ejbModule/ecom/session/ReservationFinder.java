package ecom.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ecom.entities.CarpoolingReservation;
import ecom.entities.TaxiReservation;

/**
 * Session Bean implementation class WayFinder
 */
@Stateless
@LocalBean
public class ReservationFinder implements ReservationFinderLocal {

	@PersistenceContext(unitName = "ecomEJB")
	private EntityManager emanager;

	/**
	 * Default constructor.
	 */
	public ReservationFinder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CarpoolingReservation> getCarpoolingReservation(int idUser) {
		Query q = emanager
				.createNamedQuery("CarpoolingReservation.findByUserId");

		q.setParameter("userId", idUser);

		List<CarpoolingReservation> lcr = q.getResultList();

		return lcr;
	}

	@Override
	public List<TaxiReservation> getTaxiReservation(int idUser) {
		Query q = emanager.createNamedQuery("TaxiReservation.findByUserId");

		q.setParameter("userId", idUser);

		List<TaxiReservation> ltr = q.getResultList();

		return ltr;
	}
}
