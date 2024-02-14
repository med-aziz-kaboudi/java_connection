package tests;

import models.Admin;
import models.Client;
import services.Adminservices;
import services.Clientservices;
import utils.MyDataBase;

import java.sql.Date;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        MyDataBase bd = MyDataBase.getInstance();
        Adminservices ad = new Adminservices();
        Clientservices cl = new Clientservices();

        try {
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
        }

        try {
            // Add a new Client
            Client newClient = new Client("kaboudi", "aziz", "azizkaboudi1@gmail.com", "aziz123", "kaboudi", "tunis", 50082878,new Date(System.currentTimeMillis()));
            cl.ajouter(newClient);
            System.out.println("Client added successfully.");

            // Update a Client
            int clientIdToUpdate = 6;
            Client clientToUpdate = new Client(clientIdToUpdate, "mohsen", "mohsen", "mohsen@gmail.com", "mohsen123", "mohsen", "mohsen", 50082879, newClient.getDate());            cl.modifier(clientToUpdate);
            System.out.println("Client updated successfully.");

            // Delete a Client
            int clientIdToDelete = 3;
            cl.supprimer(clientIdToDelete);
            System.out.println("Client deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
