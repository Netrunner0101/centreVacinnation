package ipam.sgbd.centrevacinnation.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.Patient;
import ipam.sgbd.centrevacinnation.repository.PatientRepository;
import ipam.sgbd.centrevacinnation.repository.ReservationRepository;


@Service
public class PatientServiceImpl implements PatientService  {
	
	@Autowired PatientRepository patientRepository;
	@Autowired ReservationRepository reservationRepo;
	
	// Retourner tout les patients
	public List<Patient> getAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}
	
	// Retourner patient en fonction de son Id
	public Optional<Patient> getPatientById(Long idPatient) {
		return patientRepository.findById(idPatient);
	}
	
	
	// Supprimer le patient grace à id
	public void delete(Long idPatient) {
		patientRepository.deleteById(idPatient);;
	}

	// ajouter un patient
	public Patient addPatient(Patient patient) {
		return  patientRepository.save(patient);
	}
	
	// Update un patient 
	public Patient updatePatient(Patient patient,long idPatient) {
		Patient UpdatePatient = patientRepository.findById(idPatient).get();
		UpdatePatient.setNom(patient.getNom());
		UpdatePatient.setPrenom(patient.getPrenom());
		UpdatePatient.setAge(patient.getAge());
		UpdatePatient.setAdresse(patient.getAdresse());
		UpdatePatient.setDateNaissance(patient.getDateNaissance());
		UpdatePatient.setEmail(patient.getEmail());
		UpdatePatient.setNumeroNational(patient.getNumeroNational());
		return patientRepository.save(UpdatePatient);
	}
	
	// Changer l'id du centre vaccination
	public void changeCentreV(long idCentre, long idPatient){
		patientRepository.changePatientCentrevaccinationId(idCentre, idPatient);
	}
	
	// Changer l'id du centre vaccination
	public void changeReservation(long idReservation, long idPatient){
		patientRepository.changePatientReservationId(idReservation, idPatient);
	}
	
	// Changer l'id du Siege
	public void changeSiege(long idSiege, long idPatient) {
		patientRepository.changePatientSiegeId(idSiege, idPatient);
	};
	
//	// 1er facon
//	// Retrouver la reservation(id) du patient
//	public List<Object[]> getPatientReservation(long idPatient){
//		return patientRepository.getPatientReservation(idPatient);
//	}
//	
}
