package org.example;
import java.time.LocalDateTime;

public class Reservation {
    private final int id;
    private final Salle salle;
    private final Enseignant enseignant;
    private final LocalDateTime debut;
    private final LocalDateTime fin;
    public Reservation(int id ,Salle salle ,Enseignant enseignant,LocalDateTime debut,LocalDateTime fin){
        if(id <= 0){
            throw new IllegalArgumentException("Invalid Id ");
        }
        this.id = id;
        if (salle == null){
            throw new IllegalArgumentException(" salle attribute est null ");
        }
        this.salle= salle;
        if (enseignant == null) {
            throw new IllegalArgumentException(" enseignant attribute est null  ");
        }
        this.enseignant = enseignant;
        if(debut == null){
            throw new IllegalArgumentException(" debut attribute est null  ");
        }
        this.debut =debut ;
        if(fin == null ||  !fin.isAfter(debut)){
            throw new IllegalArgumentException(
                    "La date de fin doit être non nulle et postérieure à la date de début"
            );
        }
        this.fin = fin;
    }
    public int getId() {
        return id;
    }
    public Salle getSalle(){
        return salle;
    }
    public Enseignant getEnseignant(){
        return enseignant;
    }
    public LocalDateTime getDebut(){
        return debut;
    }
    public LocalDateTime getFin(){
        return fin;
    }

}