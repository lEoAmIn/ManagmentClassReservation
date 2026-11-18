package org.example;
import java.util.*;

public class Enseignant {
    private  int id;
    private String nom ;
    private String  prenom;
    private String email;
    public Enseignant(int id , String nom ,String prenom,String email){
        if (id <= 0){
            throw new IllegalArgumentException("invalid Enseignant id ");
        }
        this.id=id;
        if (nom == null || nom.isBlank()){
            throw new IllegalArgumentException("invalid Enseignant nom ");
        }
        this.nom= nom;
        if (prenom == null || prenom.isBlank()){
            throw new IllegalArgumentException("invalid Enseignant prenom ");
        }
        this.prenom=prenom;
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (email == null || email.isBlank() || !email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid Enseignant email");
        }
        this.email= email;
    }
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getEmail(){
        return email;
    }

}
