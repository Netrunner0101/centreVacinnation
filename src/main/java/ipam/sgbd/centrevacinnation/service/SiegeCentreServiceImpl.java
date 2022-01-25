package ipam.sgbd.centrevacinnation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;
import ipam.sgbd.centrevacinnation.model.Patient;
import ipam.sgbd.centrevacinnation.model.SiegeCentre;
import ipam.sgbd.centrevacinnation.repository.CentreVaccinationRepository;
import ipam.sgbd.centrevacinnation.repository.PatientRepository;
import ipam.sgbd.centrevacinnation.repository.SiegeCentreRepository;

@Service
public class SiegeCentreServiceImpl implements SiegeCentreService {
	
	@Autowired SiegeCentreRepository siegeCentreRepo;
	
	@Autowired PatientRepository patientRepo;
	
	@Autowired CentreVaccinationRepository centreVaccinationRepo;
	
	// NE MARCHE PAS ?? Voir Probleme
	public Iterable<SiegeCentre> infoSiege() {
		return siegeCentreRepo.findAll();
	}
	
	// 1 Tous les patients 
	public List<Patient> allPatients(){
		return (List<Patient>) patientRepo.findAll() ;
	}
	
	// 2 Tous les centres
	public List<CentreVaccination> allCentres(){
		return (List<CentreVaccination>) centreVaccinationRepo.findAll();
	}
	
	// 3 Creer un nouveau siege
	public SiegeCentre siegeCreation(SiegeCentre siege) {
		return siegeCentreRepo.save(siege);
	}
	
	// 4 Update siege
	public SiegeCentre siegeUpdate(SiegeCentre siege, long idSiege) {
		SiegeCentre sUpdated = siegeCentreRepo.findById(idSiege).get();
		sUpdated.setNom(siege.getNom());
		sUpdated.setAdresse(siege.getAdresse());
		return siegeCentreRepo.save(siege);
	}
	
	// 5 Supprimer un siege
	public void deleteSiege(long idSiege) {
		siegeCentreRepo.deleteById(idSiege);
	}
	
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}




	
}
