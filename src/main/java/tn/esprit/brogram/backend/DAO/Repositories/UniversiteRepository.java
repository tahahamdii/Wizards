package tn.esprit.brogram.backend.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.brogram.backend.DAO.Entities.Universite;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findUnBynomUniversite(String name);

    Universite findUniversiteByEmail(String email);


    List<Universite> findByStatuts(String statuts);


    Universite findUniversiteByNomUniversiteAndEmail(String name, String email);


    List<Universite> findUniversiteByFoyer_IdFoyer(long idFoyer);
    Universite findUniversiteByFoyerIdFoyer(long idFoyer);

}
