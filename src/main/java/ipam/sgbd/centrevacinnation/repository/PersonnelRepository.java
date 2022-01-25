package ipam.sgbd.centrevacinnation.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.Personnel;

@Repository
@Transactional
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE personnel SET idCentre =?1 WHERE idPersonnel = ?2",nativeQuery=true)
	void changePersonnelCentreId(long idCentre, long idPersonnel);

}
