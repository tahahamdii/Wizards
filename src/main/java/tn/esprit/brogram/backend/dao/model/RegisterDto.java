package tn.esprit.brogram.backend.dao.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Data
public class RegisterDto {
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private LocalDate dateNaissance ;

    private String email;
    private String password;
}
