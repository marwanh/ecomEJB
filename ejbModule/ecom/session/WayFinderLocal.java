package ecom.session;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import ecom.entities.PredefinedJourney;

/**
 * Session Bean implementation class WayFinder
 */
@Local
public interface WayFinderLocal {
	public ArrayList<PredefinedJourney> WayFinderCovoiturage(float latdu,
			float londu, float latau, float lonau, Date departure);

	public boolean WayFinderTaxi(Date userdate, String duration);
}
