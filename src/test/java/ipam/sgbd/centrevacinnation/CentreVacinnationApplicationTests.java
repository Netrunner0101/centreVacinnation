package ipam.sgbd.centrevacinnation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ipam.sgbd.centrevacinnation.model.Patient;
import ipam.sgbd.centrevacinnation.model.Personnel;
import ipam.sgbd.centrevacinnation.model.SiegeCentre;
import ipam.sgbd.centrevacinnation.model.Vaccin;
import ipam.sgbd.centrevacinnation.repository.PatientRepository;
import ipam.sgbd.centrevacinnation.repository.PersonnelRepository;
import ipam.sgbd.centrevacinnation.repository.VaccinRepository;

@SpringBootTest
class CentreVacinnationApplicationTests {

	@Autowired PatientRepository patientRepo;
	
	@Autowired VaccinRepository vRepo;
	
	@Autowired PersonnelRepository peRepo;
	
	/*
	// Test un POST Vaccin 
		@Test
		public void createVaccin() {
			Vaccin v = new Vaccin();
			v.setIdVaccin((long)2);
			v.setNom("Pfize");
			v.setDuree(30);
			vRepo.save(v);
			assertNotNull(vRepo.findById((long)2).get());
		}
	*/
	
	/*
	// test un POST patient
	@Test
	public void createPatient() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		SiegeCentre sc = new SiegeCentre();
		Patient p = new Patient();
		p.setIdPatient((long)1);
		p.setNom("Jackouille");
		p.setPrenom("Paul");
		p.setAge(35);
		p.setDateNaissance(date.parse("10-01-1990"));
		p.setNumeroNational(0321312321);
		p.setAdresse("Rue des Patates");
		p.setEmail("paul@hotmail.com");
		patientRepo.save(p);
		assertNotNull(patientRepo.findById((long) 1).get());
	}
	*/
	
	/* Test pour vérifier qu'il y a bien une entrée en DB
	@Test
	void testGetAll() {
		List<Patient> p = (List<Patient>) patientRepo.findAll();
		assertThat(p).size().isGreaterThan(0);
	}
	*/
	
	/*
	//Verifier que il a bien un vaccin dans la DB
	@Test
	void testGetAllVaccins() {
		List<Vaccin> v = (List<Vaccin>) vRepo.findAll();
		assertThat(v).size().isGreaterThan(0);
	}
	*/
	
	/*
	// Test creation Personnel
	@Test
	public void createPersonnel() {
		Personnel per = new Personnel();
		per.setIdPersonnel(1);
		per.setNom("Tran");
		per.setPrenom("Jake");
		per.setEmail("tran@centre.com");
		per.setOccupation("Médecin");
		peRepo.save(per);
		List<Personnel> lpe = (List<Personnel>) peRepo.findAll();
		assertThat(lpe).size().isGreaterThan(0);
	}
	*/
	
}
