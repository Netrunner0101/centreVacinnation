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
@Table(name="personnel")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idPersonnel")
public class Personnel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPersonnel;

	@Column(name="nom")
    private String nom;
    
	@Column(name="prenom")
	private String prenom;
    
	@Column(name="occupation")
	private String occupation;
    
	@Column(name="email")
	private String email;
	
    //Relation n to 1 Avec le centre
	@ManyToOne
	@JoinColumn(name="idCentre")
	private CentreVaccination centre;
	
	//Relation Many to Many (Personnel) avec table intermiédaire Horaire.
	@OneToMany(mappedBy="personnelHoraire")
	private List<Horaire> centreHoraire;

	public Personnel(long idPersonnel, String nom, String prenom, String occupation, String email) {
		super();
		this.idPersonnel = idPersonnel;
		this.nom = nom;
		this.prenom = prenom;
		this.occupation = occupation;
		this.email = email;
	}

	public Personnel() {
		super();
	}
	
	
}
