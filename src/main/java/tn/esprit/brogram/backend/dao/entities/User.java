package tn.esprit.brogram.backend.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder
@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="nomEt")
    private String nomEt;
    @Column(name="prenomEt")
    private String prenomEt;
    @Column(name="cin")
    private long cin;

    @JsonIgnore
    @Column(name="password")
    private String password;
    @Column(name="role")
    private Roles role;
    @Column(name="ecole")
    private String ecole;
    @Column(name="dateNaissance")
    private LocalDate dateNaissance ;

    @JsonIgnore
    @ManyToMany(mappedBy = "etudiants" , cascade =  CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="enabled")
    private boolean enabled = false ;

    @Column(name="lastLogin")
    private LocalDate lastLogin ;

    @Lob
    @Column(name = "imagebyte", length = 100000)
    private byte[] imagebyte;

    @Column(name="verificationToken")
    private String verificationToken;



    public boolean getEnabled(){
        return this.enabled;
    }
}
