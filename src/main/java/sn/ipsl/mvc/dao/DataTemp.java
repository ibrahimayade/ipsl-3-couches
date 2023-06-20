package sn.ipsl.mvc.dao;

import sn.ipsl.mvc.model.Personne;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataTemp {
     Logger logger = LoggerFactory.getLogger(DataTemp.class);
    private static  DataTemp instance;
    private List<Personne> personneList;



//    public static final DataTemp getInstance() {
//        return instance;
//    }
//    
     public static DataTemp getInstance() {
        if (instance == null) {
             instance = new DataTemp();
        }
        return instance;
    }


    @Override
    public String toString() {
        return String.format("###: %s", super.toString());
    }

    public void init() {
        //Add nes personne
        personneList = new ArrayList<>();
        Personne personne1 = new Personne();
        personne1.setId(1L);
        personne1.setNom("Mboup");
        personne1.setPrenom("Talla");
        personne1.setTelephone("221776982715");
        personne1.setAge(121);
        
        personneList.add(personne1);
        //Add nes personne
        Personne personne2 = new Personne();
        personne2.setId(2L);
        personne2.setNom("Mariama");
        personne2.setPrenom("Diallo");
        personne2.setTelephone("221775536114");
        personne2.setAge(144);
        
        personneList.add(personne2);
        //Add nes personne
        Personne personne3 = new Personne();
        personne3.setId(3L);
        personne3.setNom("SECK");
        personne3.setPrenom("Moustapha");
        personne3.setTelephone("221775191467");
        personne3.setAge(165);
        personneList.add(personne3);

        //Add nes personne
        Personne personne4 = new Personne();
        personne4.setId(4L);
        personne4.setNom("TAMPI");
        personne4.setPrenom("Fouta");
        personne4.setTelephone("221773098712");
        personne4.setAge(145);
        personneList.add(personne4);
        setPersonneList(personneList);
        viewPersonnesList(personneList);
        

    }
    
    public void addPersonne(Personne p){
        personneList.add(p);
        viewPersonnesList(getPersonneList());
    }
        
    public  void deletePersonne(Personne p){
        personneList.remove(p);
         viewPersonnesList(personneList);
    }
    

    public List<Personne> getPersonneList() {
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }
    
    
    
    
    public void viewPersonnesList(List<Personne> personnes){
        for(Personne p: personnes){
            logger.info("### Personne {}: ", p);
            
        }
    }
    
    
}
