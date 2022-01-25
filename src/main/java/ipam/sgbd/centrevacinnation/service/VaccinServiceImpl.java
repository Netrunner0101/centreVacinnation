package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ipam.sgbd.centrevacinnation.model.Vaccin;
import ipam.sgbd.centrevacinnation.repository.VaccinRepository;

@Service
public class VaccinServiceImpl implements VaccinService {
	
	@Autowired VaccinRepository vaccinRepo;
	
	// Rechercher tous les vaccins 
	@Override
	public List<Vaccin> getAllVaccin() {
		return (List<Vaccin>) vaccinRepo.findAll();
	}
	
	// Rechercher Vaccin par ID
	@Override
	public Optional<Vaccin> getVaccinById(Long idVaccin) {
		return vaccinRepo.findById(idVaccin);
	}
	
	// Supprimer un vaccin
	@Override
	public void deleteVaccin(Long idVaccin) {
		vaccinRepo.deleteById(idVaccin);
	}
	
	// Créer un vaccin
	public Vaccin vaccinCreate(Vaccin vaccin) {
		return vaccinRepo.save(vaccin);
	}
	
	// Update un vaccin 
	public Vaccin vaccinUpdate(Vaccin vaccin, Long idVaccin) {
		Vaccin vaccinUpdate = vaccinRepo.findById(idVaccin).get();
		vaccinUpdate.setNom(vaccin.getNom());
		vaccinUpdate.setDuree(vaccin.getDuree());
		return vaccinRepo.save(vaccinUpdate);
	}
	
	// Update Vaccin centre id
	public void updateVaccinCentreId(long idCentre, long idVaccin) {
		vaccinRepo.updateVaccinCentreId(idCentre, idVaccin);
	}

}
