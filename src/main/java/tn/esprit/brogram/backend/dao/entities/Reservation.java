package tn.esprit.brogram.backend.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {
    @Id
    private String idReservation;

    @Column(name="anneeReservation")
    private Date anneeReservation ;

    @Column(name="estValide")
    private Boolean estValide ;

    @Column(name="dateDebut")
    private LocalDate dateDebut ;

    @Column(name="dateFin")
    private LocalDate dateFin  ;

    @Column(name="status")
    private StateReservation status ;

    @Column(name="anneeUniversitaire")
    private String anneeUniversitaire ;

    @Column(name="AutoRenew")
    private boolean autoRenew ;

    @ManyToMany(cascade = CascadeType.ALL)
    public Set<User> etudiants = new HashSet<>();


}
