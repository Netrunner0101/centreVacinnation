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

import ipam.sgbd.centrevacinnation.model.Vaccin;
import ipam.sgbd.centrevacinnation.repository.VaccinRepository;
import ipam.sgbd.centrevacinnation.service.VaccinServiceImpl;

@RestController
public class VaccinController {
	
	@Autowired VaccinServiceImpl vaccinServ;
	@Autowired VaccinRepository vaccinRepo;
	
	// Voir tous les vaccins
	@GetMapping("/vaccins")
	public List<Vaccin> getAllVaccins(){
		return vaccinServ.getAllVaccin();
	}
	
	// Voir le vaccin par ID
	@GetMapping("/vaccin/{id}")
	public Optional<Vaccin> getVaccinById(@PathVariable(name="id") long idVaccin){
		return vaccinServ.getVaccinById(idVaccin);
	}
	
	// Supprimer un vaccin
	@DeleteMapping("/vaccin/delete/{id}")
	void deleteVaccin(@PathVariable("id") long idVaccin) {
		vaccinServ.deleteVaccin(idVaccin);
	}
	
	// Creer un nouveau Vaccin
	@PostMapping("/vaccin/create")
	public Vaccin createVaccin(@RequestBody Vaccin vaccin) {
		try {
			return vaccinRepo.save(vaccin);
		}catch(Exception e) {
			return null;
		}
	}
	
	// Update le vaccin
	@PutMapping("/vaccin/update/{id}")
	public Vaccin vaccin(@RequestBody Vaccin vaccin,@PathVariable("id") Long idVaccin) {
		return vaccinServ.vaccinUpdate(vaccin, idVaccin);
	}
	
	// Update Vaccin centre Id
	@PutMapping("/vaccin/{idV}/centre/{idC}")
	public void updateVaccinCentreId(@PathVariable("idC") long idCentre, @PathVariable("idV") long idVaccin) {
		vaccinServ.updateVaccinCentreId(idCentre, idVaccin);
	}
	
}
