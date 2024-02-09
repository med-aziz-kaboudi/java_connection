package services;

import models.Personne;
import utils.MyDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonneServices implements Iservice<Personne> {
   private Connection connection;
    public PersonneServices(){
        connection = MyDataBase.getInstance().getconn();
    }

    @Override
    public void ajouter(Personne personne) throws SQLException {
     String req = "insert into client (nom, prenom ,age) " +
             "values('" + personne.getNom() + "','" + personne.getPrenom() + "'"
             +  "," + personne.getAge() + ")";
     Statement ste = connection.createStatement();
     ste.executeUpdate(req);
    }

    @Override
    public void modifier(Personne personne) throws SQLException {

    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public List<Personne> afficher() throws SQLException {
        return null;
    }

}
