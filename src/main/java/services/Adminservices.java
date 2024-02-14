package services;

import models.Admin;
import utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Adminservices implements Iadmin<Admin> {
    private final Connection connection;

    public Adminservices() {
        this.connection = MyDataBase.getInstance().getconn();
    }

    @Override
    public void ajouter(Admin admin) throws SQLException {
        String req = "INSERT INTO admin (nom, prenom, email, password) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, admin.getNom());
            pst.setString(2, admin.getPrenom());
            pst.setString(3, admin.getEmail());
            pst.setString(4, admin.getPassword());
            pst.executeUpdate();
        }
    }

    @Override
    public void modifier(Admin admin) throws SQLException {
        String req = "UPDATE admin SET nom = ?, prenom = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, admin.getNom());
            pst.setString(2, admin.getPrenom());
            pst.setString(3, admin.getEmail());
            pst.setString(4, admin.getPassword());
            pst.setInt(5, admin.getId());
            pst.executeUpdate();
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM admin WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public List<Admin> afficher() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String req = "SELECT * FROM admin";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                admins.add(admin);
            }
        }
        return admins;
    }
}
