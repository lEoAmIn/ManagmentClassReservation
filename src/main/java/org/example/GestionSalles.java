package org.example;
import java.util.List;
import java.util.ArrayList;

public class GestionSalles {
    private final List<Salle> salles;
    public GestionSalles() {
        salles = new ArrayList<>();
    }
    public boolean ajouterSalle(Salle salle){
        if (salle == null){
            throw new IllegalArgumentException("the salle is null");
        }
        for ( Salle existingSalle : salles){
            if(existingSalle.getId()== salle.getId()){
                return false;
            }
        }

        return salles.add(salle);

    }
    public List<Salle> getSalles(){
        return new ArrayList<>(salles);
    }
    public Salle rechercherSalleParId(int id) {
        for (Salle salle : salles){
            if(salle.getId()== id){
                return salle;
            }
        }
        return null;
    }

}
