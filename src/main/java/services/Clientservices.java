package services;

import models.Client;

import java.sql.*;

import utils.MyDataBase;

import java.util.ArrayList;
import java.util.List;

public class Clientservices {
    private final Connection connection;

    public Clientservices() {
        this.connection = MyDataBase.getInstance().getconn();
    }

    public void ajouter(Client client) throws SQLException {
        String req = "INSERT INTO client (nom, prenom, email, password, username, adresse, num_tel, date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, client.getNom());
            pst.setString(2, client.getPrenom());
            pst.setString(3, client.getEmail());
            pst.setString(4, client.getPassword());
            pst.setString(5, client.getUsername());
            pst.setString(6, client.getAdresse());
            pst.setInt(7, client.getNumTel());
            pst.setTimestamp(8, new Timestamp(client.getDate().getTime())); // Using Timestamp here as well

            pst.executeUpdate();
        }
    }


    public void modifier(Client client) throws SQLException {
        String req = "UPDATE client SET nom = ?, prenom = ?, email = ?, password = ?, username = ?, adresse = ?, num_tel = ?, date = ? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, client.getNom());
            pst.setString(2, client.getPrenom());
            pst.setString(3, client.getEmail());
            pst.setString(4, client.getPassword());
            pst.setString(5, client.getUsername());
            pst.setString(6, client.getAdresse());
            pst.setInt(7, client.getNumTel());
            pst.setTimestamp(8, new Timestamp(client.getDate().getTime())); // Using Timestamp for date and time
            pst.setInt(9, client.getId());

            pst.executeUpdate();
        }
    }



    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public List<Client> afficher() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String req = "SELECT * FROM client";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("adresse"),
                        rs.getInt("num_tel"),
                        rs.getDate("date")
                );
                clients.add(client);
            }
        }
        return clients;
    }

}
