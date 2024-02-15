package tests;

import models.Admin;
import models.Client;
import models.Gerant;
import services.Adminservices;
import services.Clientservices;
import services.GerantService;
import utils.MyDataBase;
import models.Livreur;
import services.LivreurService;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        MyDataBase bd = MyDataBase.getInstance();
        Adminservices ad = new Adminservices();
        Clientservices cl = new Clientservices();

      /*  try {
            // Add a new Admin
            Admin newAdmin = new Admin("aziz", "aziz", "aziz@gmail.com", "aziz123");
            ad.ajouter(newAdmin);
            System.out.println("Admin added successfully.");

            // Update an Admin
            int adminIdToUpdate = 6;
            Admin adminToUpdate = new Admin(adminIdToUpdate, "azouz", "azouz", "azouz@gmail.com", "azouz123");
            ad.modifier(adminToUpdate);
            System.out.println("Admin updated successfully.");

            // Delete an Admin
            int adminIdToDelete = 1;
            ad.supprimer(adminIdToDelete);
            System.out.println("Admin deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }*/

      /*  try {
            // Add a new Client
            Client newClient = new Client("kaboudi", "aziz", "azizkaboudi1@gmail.com", "aziz123", "kaboudi", "tunis", 50082878, new Date(System.currentTimeMillis()));
            cl.ajouter(newClient);
            System.out.println("Client added successfully.");

            // Update a Client
            int clientIdToUpdate = 6;
            Client clientToUpdate = new Client(clientIdToUpdate, "mohsen", "mohsen", "mohsen@gmail.com", "mohsen123", "mohsen", "mohsen", 50082879, newClient.getDate());
            cl.modifier(clientToUpdate);
            System.out.println("Client updated successfully.");

            // Delete a Client
            int clientIdToDelete = 3;
            cl.supprimer(clientIdToDelete);
            System.out.println("Client deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        GerantService gs = new GerantService();

        try {
            // Add a new Gerant
            Gerant newGerant = new Gerant( "amira", "gharbi", "A description", "documentPath", "imagePath", "amira@example.com", "azizkb", new Timestamp(System.currentTimeMillis()));
            gs.ajouter(newGerant);
            System.out.println("Gerant added successfully.");

            // Update a Gerant
            int gerantIdToUpdate = 6;
            Gerant gerantToUpdate = new Gerant(gerantIdToUpdate, "amiraaa", "gharbiii", "Updated description", "newDocumentPath", "newImagePath", "amiraa@example.com", "azizkb", new Timestamp(System.currentTimeMillis()));
            gs.modifier(gerantToUpdate);
            System.out.println("Gerant updated successfully.");

            // Delete a Gerant
            int gerantIdToDelete = 1;
            gs.supprimer(gerantIdToDelete);
            System.out.println("Gerant deleted successfully.");

            // List all Gerants
           System.out.println("Listing all gerants:");
            for (Gerant gerant : gs.afficher()) {
                System.out.println(gerant.getName() + " - " + gerant.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }*/


        LivreurService ls = new LivreurService();

        try {
            // Add a new Livreur
            Livreur newLivreur = new Livreur("Nom", "Prenom", "email@example.com", "password123", "Adresse", 1, 1, 12345678, new Timestamp(System.currentTimeMillis()));
            ls.ajouter(newLivreur);
            System.out.println("Livreur added successfully.");

            // Update a Livreur
            int livreurIdToUpdate = 6;
            Livreur livreurToUpdate = new Livreur(livreurIdToUpdate, "NomMod", "PrenomMod", "emailmod@example.com", "password1234", "AdresseMod", 2, 2, 87654321, new Timestamp(System.currentTimeMillis()));
            ls.modifier(livreurToUpdate);
            System.out.println("Livreur updated successfully.");

            // Delete a Livreur
            int livreurIdToDelete = 1;
            ls.supprimer(livreurIdToDelete);
            System.out.println("Livreur deleted successfully.");
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
