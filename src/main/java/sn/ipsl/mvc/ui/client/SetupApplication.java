package sn.ipsl.mvc.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.ipsl.mvc.dao.DataTemp;
import sn.ipsl.mvc.model.Personne;

import java.util.List;
import java.util.Scanner;

public class SetupApplication {
     static DataTemp dataTemp =null;
  private static Logger logger = LoggerFactory.getLogger(SetupApplication.class);
             PersonneController personneController;

    public static void main(String args[]) throws Exception {
         SetupApplication setupApplication = new SetupApplication();
        dataTemp = DataTemp.getInstance();
       
        dataTemp.init();
     setupApplication.addNewPersonne();
     //yade
     setupApplication.getAll();

    }

    public SetupApplication() {
        personneController = new PersonneController();
    }

    public void addNewPersonne() throws Exception {

        System.out.println("Saisissez le nom: ");
        Scanner input = new Scanner(System.in);
        String lastName = input.nextLine();
        System.out.println("You entered lastName is: " + lastName);

        System.out.println("Saisissez le prenom: ");
        String firstName = input.nextLine();
        System.out.println("You entered firstName is: " + firstName);
        System.out.println("Saisissez le telephone: ");

        String phoneNumber = input.nextLine();
        System.out.println("You entered phone number is: " + phoneNumber);

        System.out.println("Saisissez l'age: ");
        //int age = input.nextInt();
        String age= input.nextLine();
        try {
            personneController.validatePersonne(lastName, firstName, phoneNumber, Integer.parseInt(age));
        } catch (Exception e) {
            throw e;
        }
        Personne p=new Personne(lastName,firstName, phoneNumber,Integer.parseInt(age));
        dataTemp.addPersonne(p);
    }

    public void getPersonneByPhoneNumer() {
        System.out.println("Saisissez le numero de tel. que vous cherchez: ");
        Scanner input = new Scanner(System.in);
        String phone = input.nextLine();
        System.out.println("You entered phone number is: " + phone);
        Personne personne = personneController.getPersonneByPhone(phone);
        if (personne == null) {
            logger.info("Aucune eprsonne trouvé avec ce numero ");
        } else {
            logger.info("La personne trouvée est : ", personne);
        }
    }

    public List<Personne> getAll() {
        List<Personne> personnes= dataTemp.getPersonneList();
        for(Personne p: personnes){
            logger.info("####### Personne {}:", p);
        }
        return personnes;
    }
}
