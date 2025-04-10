package tn.esprit.DevOps.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.DevOps.DAO.Entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    int countByAnneeUniversitaireBetween(LocalDate dateInf, LocalDate dateSup);
    Reservation findByEtudiantsCinAndEstValide(long cin,boolean isValid);
    List<Reservation> findByEstValideAndAnneeUniversitaireBetween(boolean estValide, LocalDate dateDebut, LocalDate dateFin);

}

