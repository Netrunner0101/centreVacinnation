package ipam.sgbd.centrevacinnation.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name="siegeCentre")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idSiege")
public class SiegeCentre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSiege")
	private Long idSiege ;
	
	@Column(name="nom")
	private String nom ;
	
	@Column(name="adresse")
	private String adresse ;
	
	//Relation one to many avec Patient(PK)
	@OneToMany(mappedBy="siege")
	private List<Patient> patient;
	
	//Relation one to many avec CentreVaccination(PK)
	@OneToMany(mappedBy="siegeCentre")
	private List<CentreVaccination> centreVaccination;

	public SiegeCentre(Long idSiege, String nom, String adresse) {
		super();
		this.idSiege = idSiege;
		this.nom = nom;
		this.adresse = adresse;
	}

	public SiegeCentre() {
		super();
	}
	
}
