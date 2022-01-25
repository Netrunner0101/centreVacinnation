package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.Horaire;
import ipam.sgbd.centrevacinnation.repository.HoraireRepository;

@Service
public class HoraireServiceImpl implements HoraireService {

	@Autowired HoraireRepository horaireRepo;
	
	// All Horaires
	public List<Horaire> allHoraires(){
		return (List<Horaire>) horaireRepo.findAll();
	}
	
	// Horaire by id
	public Optional<Horaire> horaireId(long idHoraire) {
		return horaireRepo.findById(idHoraire);
	}
	
	// Create new horaire
	public Horaire newHoraire(Horaire horaire) {
		return horaireRepo.save(horaire);
	}
	
	// Update horaire
	public Horaire updateHoraire(Horaire horaire, long idHoraire) {
		Horaire hUpdated = horaireRepo.findById(idHoraire).get();
		hUpdated.setDateHoraire(horaire.getDateHoraire());
		hUpdated.setHoraireDebut(horaire.getHoraireDebut());
		hUpdated.setHoraireFin(horaire.getHoraireFin());
		return horaireRepo.save(hUpdated);
	}
	
	//Delete Horaire
	public void deleteHoraire(long idHoraire) {
		horaireRepo.deleteById(idHoraire);
	}
	
	// Modifier le id personnel
	public void updateHorairePersonnelId(long idPersonnel, long idHoraire) {
		horaireRepo.updateHorairePersonnelId(idPersonnel, idHoraire);
	}
	
	//Modifier l'id du centre
	public void updateHoraireCentreId(long idCentre, long idHoraire) {
		horaireRepo.updateHoraireCentreId(idCentre, idHoraire);
	}
	
}
