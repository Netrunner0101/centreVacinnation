package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import ipam.sgbd.centrevacinnation.model.Vaccin;

public interface VaccinService {
	
	List<Vaccin> getAllVaccin();
	Optional<Vaccin>  getVaccinById(Long idVaccin);
	void deleteVaccin(Long idVaccin);
	
}
