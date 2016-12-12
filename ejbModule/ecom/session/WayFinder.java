package ecom.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import ecom.entities.Car;
import ecom.entities.PredefinedJourney;
import ecom.entities.TaxiReservation;
import ecom.util.Util;

/**
 * Session Bean implementation class WayFinder
 */
@Stateless
@LocalBean
public class WayFinder implements WayFinderLocal {

	@PersistenceContext(unitName = "ecomEJB")
	private EntityManager emanager;

	/**
	 * Default constructor.
	 */
	public WayFinder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PredefinedJourney> WayFinderCovoiturage(float latdu,
			float londu, float latau, float lonau, Date departure) {
		Query q = emanager.createNamedQuery("PredefinedJourney.findAllByDate");

		q.setParameter("dateUser", departure, TemporalType.DATE);
		q.setParameter("dateToday", new Date(), TemporalType.DATE);

		List<PredefinedJourney> alp = q.getResultList();

		ArrayList<PredefinedJourney> res = new ArrayList<PredefinedJourney>();

		String[] s;
		String day = Integer.toString(departure.getDay());
		System.out.println("JOUR : " + day);

		for (PredefinedJourney pj : alp) {
			s = pj.getDepartureLocation().split(";");

			float latd = new Float(s[0]);
			float lond = new Float(s[1]);

			s = pj.getArrivalLocation().split(";");

			float lata = new Float(s[0]);
			float lona = new Float(s[1]);

			System.out.println("LONGUEUR DEPART "
					+ Util.coorToDist(latd, lond, latdu, londu));
			System.out.println("LONGUEUR ARRIVEE "
					+ Util.coorToDist(lata, lona, latau, lonau));
			System.out.println("DAYS " + pj.getDays());

			if (Util.coorToDist(latd, lond, latdu, londu) <= 5000
					&& Util.coorToDist(lata, lona, latau, lonau) <= 5000
					&& pj.getDays().contains(day)) {
				System.out.println("VILL : " + pj.getDepartureCity()
						+ " HEURE : " + pj.getDepartureTime());

				q = emanager
						.createNamedQuery("CarpoolingReservation.countByJourneyAndDate");

				q.setParameter("journeyId", pj.getId());
				q.setParameter("date", departure, TemporalType.DATE);

				int number = ((Number) q.getSingleResult()).intValue();

				if (number < pj.getCarBean().getSeats()) {
					res.add(pj);
				}
			}
		}

		return res;
	}

	@Override
	public boolean WayFinderTaxi(Date departureDateTime, String duration) {
		Query q = emanager.createNamedQuery("Car.findAllTaxi");

		List<Car> alc = q.getResultList();

		List<TaxiReservation> ltr;

		boolean b = false;
		boolean a;

		for (Car c : alc) {
			emanager.refresh(c);
			ltr = c.getTaxiReservations();

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
				break;
			}
		}

		return b;
	}
}
