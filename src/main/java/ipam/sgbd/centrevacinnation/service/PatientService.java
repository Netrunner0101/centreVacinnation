package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.Patient;

@Service
public interface PatientService {
	
	List<Patient> getAllPatients();
	Optional<Patient> getPatientById(Long idPatient);
	Patient addPatient(Patient patient);
	void delete(Long idPatient);
	
}
