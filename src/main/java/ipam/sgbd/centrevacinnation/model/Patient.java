package ipam.sgbd.centrevacinnation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name="patient")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idPatient")
public class Patient {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPatient")
	private long idPatient;
	
	@Column(name="nom")
	private String nom ;
	
	@Column(name="prenom")
	private String prenom ;
	
	@Column(name="numeroNational")
	private long numeroNational;
	
	@Column(name="dateNaissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Column(name="adresse")
	private String adresse ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name="age")
	private int age ;
	
	//relation many to one SiegeCentre
	@ManyToOne
	@JoinColumn(name="idSiege")
	private SiegeCentre siege;
	
	//relation many to one CentreVaccination
	@ManyToOne
	@JoinColumn(name="idCentre")
	private CentreVaccination centreVaccination;
	
	//relation many to many CentreVaccination
	@OneToMany(mappedBy="patientReservation")
	private List<Reservation> patientReservation;

	public Patient(long idPatient, String nom, String prenom, long numeroNational, Date dateNaissance, String adresse,
			String email, int age) {
		super();
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroNational = numeroNational;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.email = email;
		this.age = age;
	}

	public Patient() {
		super();
	}

	
	
}
