package ipam.sgbd.centrevacinnation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.Patient;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient,Long> {

	// Changer l'id Siege.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE patient SET idSiege =?1 WHERE idPatient = ?2",nativeQuery=true)
	void changePatientSiegeId(long idSiege, long idPatient);
		
	// Changer l'id Centre Vacinnation.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE patient SET idCentre =?1 WHERE idPatient = ?2",nativeQuery=true)
	void changePatientCentrevaccinationId(long idCentreVacinnation, long idPatient);
	
	// Changer l'id réservation.
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE patient SET idReservation =?1 WHERE idPatient = ?2",nativeQuery=true)
	void changePatientReservationId(long idReservation, long idPatient);
	
	// 1er facon sa marche
	// Retrouver la reservation(id) du patient
	// Trouve toujours pas le probleme
	@Query(value="SELECT DateReservation,TimeReservation FROM reservation as r JOIN patient as p ON r.idPatient = p.idPatient WHERE p.idPatient =?1",nativeQuery=true)
	List<Object[]> getPatientReservation(long idPatient);
	
}
