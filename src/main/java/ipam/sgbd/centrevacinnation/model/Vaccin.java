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
@Table(name="vaccin")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idVaccin")
public class Vaccin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVaccin;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="duree")
	private int duree;
	
	// Relation one to Many avec centre Vaccination
	@ManyToOne
	@JoinColumn(name="idCentre")
	private CentreVaccination centreVaccin;
	
	// Relation one to Many avec centre Vaccination
	@OneToMany
	@JoinColumn(name="idVaccin")
	private List<Reservation> vaccinReservation;

	public Vaccin(long idVaccin, String nom, int duree) {
		super();
		this.idVaccin = idVaccin;
		this.nom = nom;
		this.duree = duree;
	}

	public Vaccin() {
		super();
	}
	
}
