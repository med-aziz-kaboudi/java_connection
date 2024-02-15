package services;

import models.Livreur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreurService implements ILivreur {
    private final Connection connection;

    public LivreurService() {
        this.connection = MyDataBase.getInstance().getconn();
    }

    @Override
    public void ajouter(Livreur livreur) throws SQLException {
        String req = "INSERT INTO livreur (nom, prenom, email, password, adresse, id_vehicule, id_zone_livraison, num_tel, date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, livreur.getNom());
            pst.setString(2, livreur.getPrenom());
            pst.setString(3, livreur.getEmail());
            pst.setString(4, livreur.getPassword());
            pst.setString(5, livreur.getAdresse());
            pst.setInt(6, livreur.getIdVehicule());
            pst.setInt(7, livreur.getIdZoneLivraison());
            pst.setInt(8, livreur.getNumTel());
            pst.setTimestamp(9, livreur.getDate());

            pst.executeUpdate();
        }
    }

    @Override
    public void modifier(Livreur livreur) throws SQLException {
        String req = "UPDATE livreur SET nom = ?, prenom = ?, email = ?, password = ?, adresse = ?, id_vehicule = ?, id_zone_livraison = ?, num_tel = ?, date = ? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, livreur.getNom());
            pst.setString(2, livreur.getPrenom());
            pst.setString(3, livreur.getEmail());
            pst.setString(4, livreur.getPassword());
            pst.setString(5, livreur.getAdresse());
            pst.setInt(6, livreur.getIdVehicule());
            pst.setInt(7, livreur.getIdZoneLivraison());
            pst.setInt(8, livreur.getNumTel());
            pst.setTimestamp(9, livreur.getDate());
            pst.setInt(10, livreur.getId());

            pst.executeUpdate();
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM livreur WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public List<Livreur> afficher() throws SQLException {
        List<Livreur> livreurs = new ArrayList<>();
        String req = "SELECT * FROM livreur";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Livreur livreur = new Livreur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("adresse"),
                        rs.getInt("id_vehicule"),
                        rs.getInt("id_zone_livraison"),
                        rs.getInt("num_tel"),
                        rs.getTimestamp("date")
                );
                livreurs.add(livreur);
            }
        }
        return livreurs;
    }
}
