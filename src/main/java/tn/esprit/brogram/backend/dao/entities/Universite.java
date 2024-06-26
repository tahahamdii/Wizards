package tn.esprit.brogram.backend.dao.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;



@Entity
@Table(name="universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite ;

    @Column(name="nomUniversite")
    private String nomUniversite ;

    @Column(name="adresse")
    private String adresse ;

    @Column(name = "statuts")
    private String statuts;

    @Column(name = "firstNameAgent")
    private String firstNameAgent;

    @Column(name = "lastNameAgent")
    private String lastNameAgent;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @OneToOne
    private Foyer foyer ;

    @Column(name="CreatedAt")
    private Date createdAt;

    @Column(name="UpdatedAt")
    private Date updatedAt;

    @Lob
    @Column(name = "imagebyte", length = 100000)  
    private byte[] imagebyte;



   @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL)
   private Set<Documents> documents = new HashSet<>();
}
