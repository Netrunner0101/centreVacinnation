package ipam.sgbd.centrevacinnation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ipam.sgbd.centrevacinnation.model.CentreVaccination;
import ipam.sgbd.centrevacinnation.model.Patient;
import ipam.sgbd.centrevacinnation.model.SiegeCentre;
import ipam.sgbd.centrevacinnation.service.SiegeCentreServiceImpl;

@RestController
public class SiegeCentreController {
	
	@Autowired
	SiegeCentreServiceImpl siegeCentreServ;
	
	// 1 Recherche le siege
	@GetMapping("/siege/info")
	public Iterable<SiegeCentre> info() {
		return siegeCentreServ.infoSiege();
	}
	
	// 2 rechercher tous les patients
	@GetMapping("/siege/patients")
	public List<Patient> AllPatient(){
		return siegeCentreServ.allPatients();
	}
	
	// 3 rechercher tous les centres
	@GetMapping("/siege/centres")
	public List<CentreVaccination> AllCentre(){
		return siegeCentreServ.allCentres();
	}
	
	// 4 ajouter un patient au centre
	@PostMapping("/siege/addpatient")
	public Patient addPatient(@RequestBody Patient patient) {
		try {
			return siegeCentreServ.addPatient(patient);
		}
		catch(Exception e) {
			return null ;
		}
	}
	
	// 5  Creer un nouveau siege
	@PostMapping("/siege/create")
	public SiegeCentre siegeCreation(SiegeCentre siege) {
		return siegeCentreServ.siegeCreation(siege);
	}
	
	// 6  Update le siege
	@PutMapping("/siege/update/{id}")
	public SiegeCentre siegeCreation(@RequestBody SiegeCentre siege, @PathVariable("id") long idSiege) {
		return siegeCentreServ.siegeUpdate(siege, idSiege);
	}
	
	// 7 Supprimer un siege
	@DeleteMapping("/siege/delete/{id}")
	public void deleteSiege(@PathVariable("id") long idSiege) {
		siegeCentreServ.deleteSiege(idSiege);
	}
}
