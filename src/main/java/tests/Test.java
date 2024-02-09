package tests;

import models.Personne;
import services.PersonneServices;
import utils.MyDataBase;

import java.sql.SQLException;

public class Test {
    public static void main (String [] args ){
        MyDataBase bd = MyDataBase.getInstance();
        PersonneServices ps = new PersonneServices();
        try {
            ps.ajouter(new Personne(24,"essid","fadhel"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


