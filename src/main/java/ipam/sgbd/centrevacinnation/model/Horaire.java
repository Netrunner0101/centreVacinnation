package ipam.sgbd.centrevacinnation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="horaire")
@Data
public class Horaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idHoraire;
	
	@Column(name="dateHoraire")
	@Temporal(TemporalType.DATE)
	private Date dateHoraire;
	
	@Column(name="horaireDebut")
	@Temporal(TemporalType.TIME)
	private Date horaireDebut;
	
	@Column(name="horaireFin")
	@Temporal(TemporalType.TIME)
	private Date horaireFin;
	
	//Relation many to one Personnel
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPersonnel")
	private Personnel personnelHoraire;
	
	//Relation many to one Centre vaccination
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idCentre")
	private CentreVaccination centreHoraire;

	public Horaire(long idHoraire, Date dateHoraire, Date horaireDebut, Date horaireFin) {
		super();
		this.idHoraire = idHoraire;
		this.dateHoraire = dateHoraire;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
	}

	public Horaire() {
		super();
	}
	
	
	
}
