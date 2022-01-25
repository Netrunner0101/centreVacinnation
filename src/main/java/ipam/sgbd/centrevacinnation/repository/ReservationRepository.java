package ipam.sgbd.centrevacinnation.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.Reservation;

@Repository
@Transactional
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

	// Changer Vaccin.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE reservation SET idVaccin =?1 WHERE idReservation = ?2",nativeQuery=true)
	void changeVaccinReservation(long idVaccin, long idReservation);
	
	// Changer Patient.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE reservation SET idPatient =?1 WHERE idReservation = ?2",nativeQuery=true)
	void changeReservationPatientId(long idPatient, long idReservation);
		
	// Changer Centre de Vaccination.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE reservation SET idCentre =?1 WHERE idReservation = ?2",nativeQuery=true)
	void changeReservationCentreId(long idCentre, long idReservation);
	
}
