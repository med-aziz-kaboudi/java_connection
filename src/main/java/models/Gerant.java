package models;

import java.sql.Timestamp;

public class Gerant {
    private int id;
    private String username;
    private String name;
    private String description;
    private String document;
    private String image;
    private String email;
    private String password;
    private Timestamp date;

    public Gerant(int id, String username, String name, String description, String document, String image, String email ,String password, Timestamp date){
        this.id = id;
        this.username = username;
        this.name = name;
        this.description = description;
        this.document = document;
        this.image = image;
        this.email = email;
        this.password = password;
        this.date = date;
    }
    public Gerant( String username, String name, String description, String document, String image, String email, String password, Timestamp date) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.document = document;
        this.image = image;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
