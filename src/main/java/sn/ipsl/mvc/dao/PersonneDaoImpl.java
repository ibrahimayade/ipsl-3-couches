package sn.ipsl.mvc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.ipsl.mvc.model.Personne;
import sn.ipsl.mvc.ui.client.PersonneController;

import java.util.ArrayList;
import java.util.List;

public class PersonneDaoImpl implements IPersoneDao {

    Logger logger = LoggerFactory.getLogger(PersonneController.class);
    private DataTemp dataTemp;
    List<Personne> personneList = new ArrayList<>();

    public PersonneDaoImpl() {
    }

    @Override
    public void savePersonne(Personne personne) {

        logger.info("**** size before saving person {}: ", personneList.size());
        personneList.add(personne);
        logger.info("**** size after saving person {}: ", personneList.size());
    }

    @Override
    public void updatePersonne(Personne personne) {
        logger.info("*** le Dao  se charge de la mise a jour la ou la donnée est stocké");

    }

    @Override
    public void deletePersonne(Personne personne) {
        logger.info("*** size before removing {}: ", personneList.size());
        personneList.remove(personne);
        logger.info("*** size before removing {}: ", personneList.size());

    }

    @Override
    public List<Personne> findAll() {
        dataTemp=DataTemp.getInstance();
        return dataTemp.getPersonneList();
    }

    @Override
    public List<Personne> findByNom(String nom) {
        List<Personne> result = new ArrayList<>();
        for (Personne personne : personneList) {
            if (personne.getNom().equalsIgnoreCase(nom)) {
                result.add(personne);
            }
        }
        return result;
    }

    @Override
    public List<Personne> findByPrenom(String prenom) {
        List<Personne> result = new ArrayList<>();
        for (Personne personne : personneList) {
            if (personne.getPrenom().equalsIgnoreCase(prenom)) {
                result.add(personne);
            }
        }
        return result;
    }

    @Override
    public Personne findById(Long id) {
        for (Personne personne : personneList) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return new Personne();
    }

    @Override
    public Personne findByPhoneNumber(String phoneNumber) {
        for (Personne personne : personneList) {
            if (personne.getTelephone().equalsIgnoreCase(phoneNumber)) {
                return personne;
            }
        }
        return new Personne();
    }

}
