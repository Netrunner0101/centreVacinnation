package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;
import ipam.sgbd.centrevacinnation.repository.CentreVaccinationRepository;

@Service
public class CentreVaccinationServiceImpl implements CentreVaccinationService {
	
	@Autowired CentreVaccinationRepository centreVaccinationRepo;
	
	// Demande toutes les centres
	@Override
	public List<CentreVaccination> allCentres() {
		return (List<CentreVaccination>) centreVaccinationRepo.findAll() ;
	}
	
	// Demande centres par id
	@Override
	public Optional<CentreVaccination> centreById(Long idCentre) {
		return centreVaccinationRepo.findById(idCentre);
	}
	
	//Supprimer centre par id
	@Override
	public void deleteCentreById(Long idCentre) {
		centreVaccinationRepo.deleteById(idCentre);
	}
	
	// Creer un nouveau Centre 
	public CentreVaccination createCentre(CentreVaccination centre) {
		try {
			return centreVaccinationRepo.save(centre);
		}catch(Exception e) {
			return null;
		}
	}
	
	// Mettre à jour le centre Vaccination
	public CentreVaccination updateCentre(CentreVaccination centre,Long idCentre) {
		CentreVaccination centreUpdated = centreVaccinationRepo.findById(idCentre).get();
		centreUpdated.setNom(centre.getNom());
		centreUpdated.setEmail(centre.getEmail());
		centreUpdated.setAdresse(centre.getAdresse());
		return centreVaccinationRepo.save(centre);
	}
	
	// Changer l'id Siege.
	public void changeCentreSiegeId(long idSiege, long idCentre) {
		centreVaccinationRepo.changeCentreSiegeId(idSiege, idCentre);
	};
	
	// Pas dans controller
	// Changer l'id Patient.
	public void changeCentrePatientId(long idPatient, long idCentre) {
		centreVaccinationRepo.changeCentrePatientId(idPatient, idCentre);
	};
	
	// Pas dans controller
	// Changer l'id Reservation.
	public void changeCentreReservationId(long idReservation, long idCentre) {
		centreVaccinationRepo.changeCentreReservationId(idReservation, idCentre);
	}
	
}
