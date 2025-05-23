
package acme.features.administrator.aircraft;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.aircraft.Aircraft;
import acme.entities.airlines.Airline;
import acme.entities.legs.Leg;

@Repository
public interface AdministratorAircraftRepository extends AbstractRepository {

	@Query("select a from Aircraft a")
	Collection<Aircraft> findAllAircrafts();

	@Query("select a from Aircraft a where a.id = :masterId")
	Aircraft findAircraftById(int masterId);

	@Query("select a from Airline a")
	Collection<Airline> findAllAirline();

	@Query("select l from Leg l where l.aircraft.id = :id")
	Collection<Leg> findLegsByAircraftId(int id);

}
