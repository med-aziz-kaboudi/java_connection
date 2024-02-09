package services;

import models.Personne;
import utils.MyDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonneServices implements Iservice<Personne> {
    private Connection connection;

    public PersonneServices() {
        connection = MyDataBase.getInstance().getconn();
    }

    @Override
    public void ajouter(Personne personne) throws SQLException {
        String req = "INSERT INTO client (nom, prenom, age) VALUES('" + personne.getNom() + "','" + personne.getPrenom() + "'," + personne.getAge() + ")";
        Statement ste = connection.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public void modifier(Personne personne) throws SQLException {
        String req = "UPDATE client SET nom = ?, prenom = ?, age = ? WHERE cin = ?";
        PreparedStatement pst = connection.prepareStatement(req);
        pst.setString(1, personne.getNom());
        pst.setString(2, personne.getPrenom());
        pst.setInt(3, personne.getAge());
        pst.setInt(4, personne.getId());
        pst.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM client WHERE cin = ?";
        PreparedStatement pst = connection.prepareStatement(req);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    @Override
    public List<Personne> afficher() throws SQLException {
        return null;
    }
}
