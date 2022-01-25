package ipam.sgbd.centrevacinnation.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;

@Repository
@Transactional
public interface CentreVaccinationRepository extends CrudRepository<CentreVaccination,Long> {
	
	// Changer l'id Siege.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE centreVaccination SET idSiege =?1 WHERE idCentre = ?2",nativeQuery=true)
	void changeCentreSiegeId(long idSiege, long idCentre);
	
	// Changer l'id Patient.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE centreVaccination SET idPatient =?1 WHERE idCentre = ?2",nativeQuery=true)
	void changeCentrePatientId(long idPatient, long idCentre);
	
	// Changer l'id Reservation.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE centreVaccination SET idReservation =?1 WHERE idCentre = ?2",nativeQuery=true)
	void changeCentreReservationId(long idReservation, long idCentre);
	
}
