package tests;

import models.Personne;
import services.PersonneServices;
import utils.MyDataBase;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        MyDataBase bd = MyDataBase.getInstance();
        PersonneServices ps = new PersonneServices();

        try {

            Personne newPerson = new Personne(30, "hi", "fadhel");
            ps.ajouter(newPerson);


            int personId = 6;
            Personne personToUpdate = new Personne(personId,30,"wassim","aziz");
            ps.modifier(personToUpdate);
            System.out.println("Person updated successfully.");

         
            int personIdToDelete = 1;
             ps.supprimer(personIdToDelete);
            System.out.println("Person deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
