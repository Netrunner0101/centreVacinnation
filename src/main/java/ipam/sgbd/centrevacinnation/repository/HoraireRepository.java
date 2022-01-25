package ipam.sgbd.centrevacinnation.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.Horaire;

@Repository
@Transactional
public interface HoraireRepository extends CrudRepository<Horaire,Long> {
	
	// Changer l'id de personnel
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE horaire SET idPersonnel =?1 WHERE idHoraire = ?2",nativeQuery=true)
	void updateHorairePersonnelId(long idPersonnel, long idHoraire);
	
	// Changer l'id du centre de vaccination
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE horaire SET idCentre =?1 WHERE idHoraire = ?2",nativeQuery=true)
	void updateHoraireCentreId(long idCentre, long idHoraire);
	
}
