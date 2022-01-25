package ipam.sgbd.centrevacinnation.model;


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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@Table(name="centreVaccination")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idCentre")
public class CentreVaccination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCentre")
	private Long idCentre ;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="email")
	private String email;
	
	//Relation many to one avec Siege 
	@ManyToOne
	@JoinColumn(name="idSiege")
	private SiegeCentre siegeCentre;
	
	//Relation one to many avec Patient
	@OneToMany(mappedBy="centreVaccination")
	private List<Patient> patient;
	
	//Relation one to many avec Vaccin
	@OneToMany(mappedBy="centreVaccin")
	private List<Vaccin> vaccin ;
	
	//Relation one to many avec Personnel
	@OneToMany(mappedBy="centre")
	private List<Personnel> personnel;
	
	//relation many to many Patient
	//Table Intermiédaire Réservation
	@OneToMany(mappedBy="centreReservation")
	private List<Reservation> patientReservation;
	
	//Relation Many to Many (Personnel) avec table intermiédaire Horaire.
	@OneToMany(mappedBy="centreHoraire")
	private List<Horaire> personnelHoraire;

	public CentreVaccination(Long idCentre, String nom, String adresse, String email) {
		super();
		this.idCentre = idCentre;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
	}

	public CentreVaccination() {
		super();
	}
	
	
	
	
}
