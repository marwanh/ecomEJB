package ecom.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import ecom.entities.Car;
import ecom.entities.CarpoolingReservation;
import ecom.entities.PredefinedJourney;
import ecom.entities.TaxiReservation;
import ecom.entities.User;

/**
 * Session Bean implementation class WayFinder
 */
@Stateless
@LocalBean
public class WayReservation implements WayReservationLocal {

	@PersistenceContext(unitName = "ecomEJB")
	private EntityManager emanager;

	/**
	 * Default constructor.
	 */
	public WayReservation() {
		// TODO Auto-generated constructor stub
	}

	// @Schedule(second = "*", minute = "*/1", hour = "*")
	// public void traiterTrenteSecondes() {
	// Query q = emanager.createNamedQuery("Admin.findAll");
	//
	// List<Admin> a = q.getResultList();
	// }

	@Override
	public boolean WayReservationCovoiturage(int idPredefinedJourney,
			int idUser, Date departure) {
		Query q = emanager
				.createNamedQuery("CarpoolingReservation.countByJourneyAndDate");

		q.setParameter("journeyId", idPredefinedJourney);
		q.setParameter("date", departure, TemporalType.DATE);

		int number = ((Number) q.getSingleResult()).intValue();

		q = emanager.createNamedQuery("PredefinedJourney.findById");

		q.setParameter("id", idPredefinedJourney);

		PredefinedJourney pj = (PredefinedJourney) q.getSingleResult();

		if (number < pj.getCarBean().getSeats()) {
			CarpoolingReservation cr = new CarpoolingReservation();

			cr.setDateReserved(new Date());
			cr.setDay(departure);
			cr.setJourney(emanager.find(PredefinedJourney.class,
					idPredefinedJourney));
			cr.setReservedSeats(1);
			cr.setUser(emanager.find(User.class, idUser));

			emanager.persist(cr);

			emanager.flush();

			emanager.refresh(cr);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean WayReservationTaxi(int idUser, String departureCity,
			String departureLocation, String arrivalCity,
			String arrivalLocation, Date departureDateTime, String duration,
			float price) {
		Query q = emanager.createNamedQuery("Car.findAllTaxi");

		List<Car> alc = q.getResultList();

		List<TaxiReservation> ltr;

		boolean b = false;
		boolean a;

		for (Car c : alc) {
			emanager.refresh(c);

			ltr = c.getTaxiReservations();

			System.out.println("Number of reservation : " + ltr.size());

			a = true;

			for (TaxiReservation tr : ltr) {
				if (departureDateTime.after(tr.getDepartureDateTime())
						&& departureDateTime.before(new Date(tr
								.getDepartureDateTime().getTime()
								+ (long) Double.parseDouble(tr.getDuration())
								* 60000))) {
					a = false;
					break;
				}

				if (new Date(departureDateTime.getTime()
						+ (long) Double.parseDouble(duration) * 60000).after(tr
						.getDepartureDateTime())
						&& new Date(departureDateTime.getTime()
								+ (long) Double.parseDouble(duration) * 60000)
								.before(new Date(tr.getDepartureDateTime()
										.getTime()
										+ (long) Double.parseDouble(tr
												.getDuration()) * 60000))) {
					a = false;
					break;
				}

				if (departureDateTime.equals(tr.getDepartureDateTime())
						|| departureDateTime.equals(new Date(tr
								.getDepartureDateTime().getTime()
								+ (long) Double.parseDouble(tr.getDuration())
								* 60000))) {
					a = false;
					break;
				}

				if (new Date(departureDateTime.getTime()
						+ (long) Double.parseDouble(duration) * 60000)
						.equals(tr.getDepartureDateTime())
						|| new Date(departureDateTime.getTime()
								+ (long) Double.parseDouble(duration) * 60000)
								.equals(new Date(tr.getDepartureDateTime()
										.getTime()
										+ (long) Double.parseDouble(tr
												.getDuration()) * 60000))) {
					a = false;
					break;
				}
			}

			if (a) {
				b = true;

				TaxiReservation trr = new TaxiReservation();

				trr.setDateReserved(new Date());
				trr.setArrivalCity(arrivalCity);
				trr.setArrivalLocation(arrivalLocation);
				trr.setCarBean(c);
				trr.setDepartureCity(departureCity);
				trr.setDepartureDateTime(departureDateTime);
				trr.setDepartureLocation(departureLocation);
				trr.setDuration(duration);
				trr.setPrice(price);
				trr.setUser(emanager.find(User.class, idUser));

				emanager.persist(trr);

				emanager.flush();

				emanager.refresh(trr);

				break;
			}
		}

		return b;
	}
}
