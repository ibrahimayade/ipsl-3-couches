package sn.ipsl.mvc.dao;

import sn.ipsl.mvc.model.Personne;

import java.util.List;

public interface IPersoneDao {
    public void savePersonne(Personne personne);
    public void updatePersonne(Personne personne);
    public void deletePersonne(Personne personne);
    public List<Personne> findAll();
    public List<Personne> findByNom(String nom);
    public List<Personne> findByPrenom(String prenom);
    public Personne findById(Long id);
    public Personne findByPhoneNumber(String phoneNumber);
}
