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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="reservation")
@Data
public class Reservation {
	
	@Id
	@Column(name="idReservation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	
	@Column(name="DateReservation")
	@Temporal(TemporalType.DATE)
	private Date DateReservation;
	
	@Column(name="TimeReservation")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "hh:mm:ss")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
	private Date TimeReservation;

	// Relation many to one avec Patient et Centre Vaccination
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPatient")
	private Patient patientReservation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idCentre")
	private CentreVaccination centreReservation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idVaccin")
	private Vaccin vaccinReservation;

	public Reservation(long idReservation, Date dateReservation, Date timeReservation) {
		super();
		this.idReservation = idReservation;
		DateReservation = dateReservation;
		TimeReservation = timeReservation;
	}

	public Reservation() {
		super();
	} 
	
	
}
