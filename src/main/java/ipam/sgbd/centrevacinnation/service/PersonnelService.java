package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import ipam.sgbd.centrevacinnation.model.Personnel;

public interface PersonnelService {
	
	List<Personnel> all();
	Optional<Personnel> findPersonnelById(Long idPersonnel);
	void deleteByIdPersonnel(Long idPersonnel);
	
}
