package ipam.sgbd.centrevacinnation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ipam.sgbd.centrevacinnation.model.Personnel;
import ipam.sgbd.centrevacinnation.repository.PersonnelRepository;
import ipam.sgbd.centrevacinnation.service.PersonnelServiceImpl;

@RestController
public class PersonnelController {

	@Autowired PersonnelServiceImpl personnelServ;
	@Autowired PersonnelRepository personnelRepo;
	
	//rechercher TOUTES personnel
	@GetMapping("/personnels")
	public List<Personnel> allPersonnels(){
		return (List<Personnel>) personnelServ.all();
	}
	
	//rechercher un personnel par id
	@GetMapping("/personnel/{id}")
	public Optional<Personnel> findPersonnelId(@PathVariable("id") Long idPersonnel ) {
		return personnelServ.findPersonnelById(idPersonnel);
	}
	
	//supprimer un personnel par id
	@DeleteMapping("/personnel/delete/{id}")
	void deletePersonnelById(@PathVariable("id") Long idPersonnel ) {
		personnelServ.deleteByIdPersonnel(idPersonnel);
	}
	
	// Probleme de creation
	
	//Creer un nouveau Personnel
	@PostMapping("/personnel/create")
	public Personnel createPersonnel(@RequestBody Personnel personnel) {
		try {
			return personnelServ.personnelCreate(personnel);
		}catch(Exception e) {
			return null;
		}
	}
	
	//Modifier un personnel 
	@PutMapping("/personnel/update/{id}")
	public Personnel personnelUpdate(@RequestBody Personnel personnel, @PathVariable("id") Long idPersonnel){
		return personnelServ.personnelUpdate(personnel, idPersonnel);
	}
	
	// Update le centre id 
	@PutMapping("personnel/{idPe}/centre/{idC}")
	public void changePersonnelCentreId(@PathVariable("idC")long idCentre,@PathVariable("idPe") long idPersonnel) {
		personnelServ.changePersonnelCentreId(idCentre,idPersonnel);
	}
	
	
}
