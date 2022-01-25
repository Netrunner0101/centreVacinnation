package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;

public interface CentreVaccinationService {

	List<CentreVaccination> allCentres();
	Optional<CentreVaccination> centreById(Long idCentre);
	void deleteCentreById(Long idCentre);
	
}
