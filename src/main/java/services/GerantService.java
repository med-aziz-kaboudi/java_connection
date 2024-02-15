package services;

import models.Gerant;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerantService implements IGerant {
    private final Connection connection;

    public GerantService() {
        this.connection = MyDataBase.getInstance().getconn();
    }

    @Override
    public void ajouter(Gerant gerant) throws SQLException {
        String req = "INSERT INTO gerant (username, name, description, document, image, email, password, date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, gerant.getUsername());
            pst.setString(2, gerant.getName());
            pst.setString(3, gerant.getDescription());
            pst.setString(4, gerant.getDocument());
            pst.setString(5, gerant.getImage());
            pst.setString(6, gerant.getEmail());
            pst.setString(7, gerant.getPassword());
            pst.setTimestamp(8, gerant.getDate());

            pst.executeUpdate();
        }
    }

    @Override
    public void modifier(Gerant gerant) throws SQLException {
        String req = "UPDATE gerant SET username = ?, name = ?, description = ?, document = ?, image = ?, email = ?, password = ?, date = ? WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setString(1, gerant.getUsername());
            pst.setString(2, gerant.getName());
            pst.setString(3, gerant.getDescription());
            pst.setString(4, gerant.getDocument());
            pst.setString(5, gerant.getImage());
            pst.setString(6, gerant.getEmail());
            pst.setString(7, gerant.getPassword());
            pst.setTimestamp(8, new Timestamp(gerant.getDate().getTime())); // Using Timestamp for date and time
            pst.setInt(9, gerant.getId());

            pst.executeUpdate();
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM gerant WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(req)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public List<Gerant> afficher() throws SQLException {
        List<Gerant> gerants = new ArrayList<>();
        String req = "SELECT * FROM gerant";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Gerant gerant = new Gerant(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("document"),
                        rs.getString("image"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("date")
                );
                gerants.add(gerant);
            }
        }
        return gerants;
    }
}
