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

import ipam.sgbd.centrevacinnation.model.Horaire;
import ipam.sgbd.centrevacinnation.service.HoraireServiceImpl;

@RestController
public class HoraireController {
	
	@Autowired HoraireServiceImpl horaireServ;
	
	// Rechercher tous les horaires.
	@GetMapping("/horaires")
	public List<Horaire> allHoraires(){
		return horaireServ.allHoraires();
	}
	
	// Horaire par id 
	@GetMapping("/horaire/{id}")
	public Optional<Horaire> horaireId(long idHoraire) {
		return horaireServ.horaireId(idHoraire);
	}
	
	// Creer un horaire
	@PostMapping("/horaire/create")
	public Horaire createHoraire(@RequestBody Horaire horaire) {
		return horaireServ.newHoraire(horaire);
	}
	
	// Update un horaire
	@PutMapping("/horaire/update/{id}")
	public Horaire createHoraire(@RequestBody Horaire horaire,@PathVariable("id") long idHoraire) {
		return horaireServ.updateHoraire(horaire, idHoraire);
	}
	
	// Delete un horaire id
	@DeleteMapping("/horaire/delete/{id}")
	public void deleteHoraire(@PathVariable("id") long idHoraire) {
		horaireServ.deleteHoraire(idHoraire);
	}
	
	// Modifier le id personnel pour un horaire 
	@PutMapping("/horaire/{idH}/update/personnel/{idP}")
	public void updateHorairePersonnelId(@RequestBody Horaire horaire,@PathVariable("idH") long idHoraire,@PathVariable("idP") long idPersonnel) {
		horaireServ.updateHorairePersonnelId(idPersonnel, idHoraire);
	}
	
	// Modifier le id d'un centre de vaccination pour un horaire 
	@PutMapping("/horaire/{idH}/update/centreVaccin/{idC}")
	public void updateHoraireCentreId(@RequestBody Horaire horaire,@PathVariable("idH") long idHoraire,@PathVariable("idC") long idCentre) {
		horaireServ.updateHoraireCentreId(idCentre, idHoraire);
	}
	
	
}
