package ipam.sgbd.centrevacinnation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipam.sgbd.centrevacinnation.model.Reservation;
import ipam.sgbd.centrevacinnation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired ReservationRepository reservationRepo;
	
	//Toutes les reservations
	public List<Reservation> allReservation(){
		return (List<Reservation>) reservationRepo.findAll();
	}
	
	//Les reservations par id
	public Optional<Reservation> reservationId(long idReservation){
		return reservationRepo.findById(idReservation);
	}
	
	//Creer une nouvelle reservation
	public Reservation reservationCreate(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	
	//Update reservation
	public Reservation reservationUpdate(Reservation reservation,long idReservation) {
		//SimpleDateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
		//SimpleDateFormat timeF = new SimpleDateFormat("HH:mm:ss");
		Reservation rUpdated = reservationRepo.findById(idReservation).get();
		rUpdated.setDateReservation(reservation.getDateReservation());
		rUpdated.setTimeReservation(reservation.getTimeReservation());
		return reservationRepo.save(reservation);
	}
	
	//Supprimer une reservation
	public void deleteReservation(long idReservation) {
		reservationRepo.deleteById(idReservation);
	}
	
	//Change Vaccin (id)
	public void changeVaccinId(long idVaccin, long idReservation) {
		reservationRepo.changeVaccinReservation(idVaccin, idReservation);
	}
	
	//Change Patient (id)
	public void changePatientId(long idPatient , long idReservation) {
		reservationRepo.changeReservationPatientId(idPatient, idReservation);
	}
	
	//Change Centre (id)
	public void changeCentreId(long idCentre, long idReservation) {
		reservationRepo.changeReservationCentreId(idCentre, idReservation);
	}
}
