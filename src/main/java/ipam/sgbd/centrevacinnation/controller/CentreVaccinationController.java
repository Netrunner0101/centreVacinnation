package ipam.sgbd.centrevacinnation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;
import ipam.sgbd.centrevacinnation.service.CentreVaccinationServiceImpl;

@RestController
public class CentreVaccinationController {
	
	@Autowired CentreVaccinationServiceImpl centreVaccinationServ;
	
	//Tous les centres
	@GetMapping("/centres")
	public Iterable<CentreVaccination> allCentre(){
		return centreVaccinationServ.allCentres();
	}
	
	//Centre par id
	@GetMapping("/centre/{id}")
	public Optional<CentreVaccination> centreId(@PathVariable("id") long idCentre){
		return centreVaccinationServ.centreById(idCentre);
	}
	
	// Supprimer un centre
	@DeleteMapping("/centre/delete/{id}")
	public void deleteCentre(@PathVariable("id") long idCentre) {
		centreVaccinationServ.centreById(idCentre);
	}
	
	//Creer un centre vaccination
	@PostMapping("/centre/create")
	public CentreVaccination createCentre(@RequestBody CentreVaccination centre) {
		return centreVaccinationServ.createCentre(centre);
	}

	// Update information d'un centre
	@PatchMapping("/centre/update/{id}")
	public CentreVaccination updateCentre(@RequestBody CentreVaccination centre,@PathVariable("id") Long idCentre) {
		return centreVaccinationServ.updateCentre(centre, idCentre);
	}
	
	// Update Siege ID d'un centre de vacination
	@PatchMapping("/centre/{idC}/siege/{idS}")
	public void updateCentreSiegeId(@PathVariable("idS") Long idSiege,@PathVariable("idC") Long idCentre) {
		centreVaccinationServ.changeCentreSiegeId(idSiege, idCentre);
	}
	
}
