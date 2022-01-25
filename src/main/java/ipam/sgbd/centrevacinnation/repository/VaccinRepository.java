package ipam.sgbd.centrevacinnation.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.Vaccin;

@Repository
@Transactional
public interface VaccinRepository extends CrudRepository<Vaccin,Long>{
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE vaccin SET idCentre =?1 WHERE idVaccin = ?2",nativeQuery=true)
	void updateVaccinCentreId(long idCentre, long idVaccin);
}
