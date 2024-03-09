package tn.esprit.brogram.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.brogram.backend.dao.entities.*;
import tn.esprit.brogram.backend.dao.repositories.FoyerRepository;
import tn.esprit.brogram.backend.dao.repositories.UniversiteRepository;
import tn.esprit.brogram.backend.services.ChamberService;
import tn.esprit.brogram.backend.services.UniversiteService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UniversiteServiceTest {

    @Autowired
    private UniversiteService universiteService;
    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private UniversiteRepository universiteRepository;
    @Test
    void testAddUniversiteNom(){
        Universite universite  = Universite.builder().nomUniversite("NomUni").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteDescription(){
        Universite universite  = Universite.builder().description("Desp Uni").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteAdresse(){
        Universite universite  = Universite.builder().adresse("Adresse Uni").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteStatus(){
        Universite universite  = Universite.builder().statuts("Pending Uni").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteEmail(){
        Universite universite  = Universite.builder().email("Emain Uni").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteFirstName(){
        Universite universite  = Universite.builder().firstNameAgent("Agent first Name").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteLastName(){
        Universite universite  = Universite.builder().lastNameAgent("Agent last Name").build();
        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());

    }
    @Test
    void testAddUniversiteFoyer() {
        Universite universite = Universite.builder().nomUniversite("NomUni").build();
        Foyer foyer = Foyer.builder().nomFoyer("Foyer Name").build();

        Universite savedUniversite = universiteService.addUniversite(universite);
        foyer.setUniversite(savedUniversite);

        Foyer savedFoyer = foyerRepository.save(foyer);
        savedUniversite.setFoyer(savedFoyer);

        Universite updatedUniversite = universiteService.editUniversite(savedUniversite);

        Assertions.assertNotNull(updatedUniversite.getIdUniversite());
        Assertions.assertNotNull(updatedUniversite.getFoyer());
        Assertions.assertEquals("Foyer Name", updatedUniversite.getFoyer().getNomFoyer());

    }

    @Test
    void testAddUniversiteCreatedAt() {
        Universite universite = Universite.builder().nomUniversite("NomUni").build();
        universite.setCreatedAt(new Date());

        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());
        Assertions.assertNotNull(savedUniversite.getCreatedAt());

    }

    @Test
    void testAddUniversiteUpdatedAt() {
        Universite universite = Universite.builder().nomUniversite("NomUni").build();
        universite.setUpdatedAt(new Date());

        Universite savedUniversite = universiteService.addUniversite(universite);
        Assertions.assertNotNull(savedUniversite.getIdUniversite());
        Assertions.assertNotNull(savedUniversite.getUpdatedAt());

    }

    @Test
    void testAddAllUniversite() {
        List<Universite> universites = new ArrayList<>();

        Universite universite1 = Universite.builder().nomUniversite("Universite 1").build();
        Universite universite2 = Universite.builder().nomUniversite("Universite 2").build();
        universites.add(universite1);
        universites.add(universite2);

        List<Universite> savedUniversites = universiteService.addAllUniversite(universites);

        Assertions.assertNotNull(savedUniversites);
        Assertions.assertEquals(universites.size(), savedUniversites.size());

        for (Universite savedUniversite : savedUniversites) {
            Assertions.assertNotNull(savedUniversite.getIdUniversite());
        }
    }

    @Test
    void testEditUniversite() {
        Universite universite = Universite.builder().nomUniversite("Universite 1").build();

        Universite savedUniversite = universiteService.editUniversite(universite);

        Assertions.assertNotNull(savedUniversite);
        Assertions.assertEquals(universite.getIdUniversite(), savedUniversite.getIdUniversite());

        Universite updatedUniversite = universiteRepository.findById(savedUniversite.getIdUniversite()).orElse(null);
        Assertions.assertNotNull(updatedUniversite);
        Assertions.assertEquals(universite.getNomUniversite(), updatedUniversite.getNomUniversite());
    }

    @Test
    void testUnifindById() {
        Universite universite = Universite.builder().nomUniversite("Universite 1").build();
        universiteRepository.save(universite);

        Universite foundUniversite = universiteService.unifindById(universite.getIdUniversite());

        Assertions.assertNotNull(foundUniversite);
        Assertions.assertEquals(universite.getIdUniversite(), foundUniversite.getIdUniversite());

        Assertions.assertEquals(universite.getNomUniversite(), foundUniversite.getNomUniversite());
    }

}
