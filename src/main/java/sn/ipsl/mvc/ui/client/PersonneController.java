package sn.ipsl.mvc.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.ipsl.mvc.metier.IPersonneMetier;
import sn.ipsl.mvc.metier.PersonneMetierImp;
import sn.ipsl.mvc.model.Personne;

import java.util.List;

public class PersonneController {
    Logger logger = LoggerFactory.getLogger(PersonneController.class);
    IPersonneMetier personneMetier;

    public PersonneController() {
        personneMetier = new PersonneMetierImp();
    }

    public void validatePersonne(String lastName, String firstName, String phoneNumber, int age) throws Exception {

        if (lastName.isEmpty()) {
            logger.info(" le parametre nom doit etre rempli ");
            throw new Exception();
        }
        if (firstName.isEmpty()) {
            logger.info(" le parametre nom doit etre rempli ");
            throw new Exception();
        }
        String phonePattern = "[0-9]{9}+";
        if (phoneNumber.isEmpty()) {
            logger.info(" le parametre telephone doit etre rempli ");
            throw new Exception();
        } else if (!phoneNumber.matches(phonePattern)) {
            logger.info(" you must provided digit only ");
            throw new Exception();
        }
        String patternAge = "[0-9]{2}";
        if (!("" + age).matches(patternAge)) {
            System.out.println(" you must provided digit only ");
            throw new Exception();
        } else if (age < 0) {
            logger.info(" l'age doit etre positif ");
            throw new Exception();
        } else {
            System.out.println("You entered age " + age);
        }
        logger.info(" Information correct: le controller passe la main au metier ");
        Personne personne = new Personne();
        personne.setNom(lastName);
        personne.setPrenom(firstName);
        personne.setTelephone(phoneNumber);
        personne.setAge(age);
        personneMetier.savePersonne(personne);


    }

    public void deletePersonne(Long id) {
        Personne personne = personneMetier.findById(id);
        if (personne != null) {
            personneMetier.deletePersonne(personne);
        }
    }

    public List<Personne> getAll() {
        logger.info("Liste de toutes les personnes ");
        List<Personne> all = personneMetier.findAll();
        for (Personne personne : all) {
            logger.info("Personne {}: ", personne);
        }
        return all;
    }

    public Personne getPersonneById(Long id) {
        return personneMetier.findById(id);
    }

    public Personne getPersonneByPhone(String phoneNumber) {
        return personneMetier.findByPhoneNumber(phoneNumber);
    }

    public List<Personne> getPersonneByNom(String nom) {
        return personneMetier.findByNom(nom);
    }

    public List<Personne> getPersonneByPrenom(String prenom) {
        return personneMetier.findByPrenom(prenom);
    }

}
