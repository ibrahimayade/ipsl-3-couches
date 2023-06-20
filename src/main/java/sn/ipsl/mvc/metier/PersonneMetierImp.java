package sn.ipsl.mvc.metier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.ipsl.mvc.dao.IPersoneDao;
import sn.ipsl.mvc.dao.PersonneDaoImpl;
import sn.ipsl.mvc.model.Personne;

import java.util.List;

public class PersonneMetierImp implements IPersonneMetier {
    Logger logger = LoggerFactory.getLogger(PersonneMetierImp.class);
    protected IPersoneDao personeDao;

    public PersonneMetierImp() {
        personeDao = new PersonneDaoImpl();
    }

    @Override
    public void savePersonne(Personne personne) {
        logger.info("#### le metier prend le relais");
        personeDao.savePersonne(personne);

    }

    @Override
    public void updatePersonne(Personne personne) {
        personeDao.updatePersonne(personne);
    }

    @Override
    public void deletePersonne(Personne personne) {
        personeDao.deletePersonne(personne);
    }

    @Override
    public List<Personne> findAll() {
        return personeDao.findAll();
    }

    @Override
    public List<Personne> findByNom(String nom) {
        return personeDao.findByNom(nom);
    }

    @Override
    public List<Personne> findByPrenom(String prenom) {
        return personeDao.findByPrenom(prenom);
    }

    @Override
    public Personne findById(Long id) {
        return personeDao.findById(id);
    }

    @Override
    public Personne findByPhoneNumber(String phoneNumber) {
        return personeDao.findByPhoneNumber(phoneNumber);
    }
}
