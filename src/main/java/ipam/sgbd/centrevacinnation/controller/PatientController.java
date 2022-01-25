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

import ipam.sgbd.centrevacinnation.model.Patient;
import ipam.sgbd.centrevacinnation.repository.PatientRepository;
import ipam.sgbd.centrevacinnation.repository.ReservationRepository;
import ipam.sgbd.centrevacinnation.service.PatientServiceImpl;


@RestController
public class PatientController {

	@Autowired PatientServiceImpl patientServiceImpl;
	@Autowired PatientRepository patientRepo;
	@Autowired ReservationRepository reservationRepo;
	
	//rechercher la liste de tous les patients 
	@GetMapping("/patients")
	public Iterable<Patient> getAllPatients() {
		return (List<Patient>) patientServiceImpl.getAllPatients();
	}
	
	//rechercher un patient avec son id
	@GetMapping("/patient/{id}")
	public Optional<Patient> getPatientById(@PathVariable("id")Long idPatient) {
		return patientServiceImpl.getPatientById(idPatient);
	}
	
	//supprimer un patient
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatient(@PathVariable("id") Long idPatient) {
		patientServiceImpl.delete(idPatient);
	}
	
	//ajouter un patient
	@PostMapping("/patient/create")
	public Patient addPatient(@RequestBody Patient patient ) {
		try {
			return patientServiceImpl.addPatient(patient);
		}
		catch(Exception e){
			return null;
		}
	}
	
	// Mettre a jour un patient
	@PutMapping("/patient/update/{id}")
	Patient patient(@RequestBody Patient patient, @PathVariable long idPatient) {
		return patientServiceImpl.updatePatient(patient, idPatient);
	}
	
	// Update id Centre 
	@PutMapping("/patient/{idP}/changeCentre/{idC}")
	public void updateCentreId(@PathVariable("idC") long idCentre,@PathVariable("idP") long idPatient){
		patientServiceImpl.changeCentreV(idCentre, idPatient);
	}
	
	// Update id Reservation
	@PutMapping("/patient/{idP}/changeReservation/{idR}")
	public void updateReservationId(@PathVariable("idR") long idReservation,@PathVariable("idP") long idPatient){
		patientServiceImpl.changeReservation(idReservation, idPatient);
	}
	
	// Update id Siege
	@PutMapping("/patient/{idP}/changeSiege/{idS}")
	public void updateSiegeId(@PathVariable("idS") long idSiege,@PathVariable("idP") long idPatient){
		patientServiceImpl.changeSiege(idSiege, idPatient);
	}
	
//	// A vérifier
//	// Retrouver la reservation(id) du patient
//	@GetMapping("/patient/reservation/{id}")
//	public List<Object[]> getPatientReservation(@PathVariable("id")Long idPatient) {
//		return patientServiceImpl.getPatientReservation(idPatient);
//	}
//	
}
