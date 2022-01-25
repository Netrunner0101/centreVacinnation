package ipam.sgbd.centrevacinnation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ipam.sgbd.centrevacinnation.model.SiegeCentre;

@Repository
@Transactional
public interface SiegeCentreRepository extends CrudRepository<SiegeCentre,Long> {

}
