package org.example;
import java.util.List;
import java.util.ArrayList;
public class GestionEnseignants {
    private final List<Enseignant> enseignants ;
    public GestionEnseignants(){
        enseignants = new ArrayList<>();
    }
    public boolean ajouterEnseignant(Enseignant enseignant) {

        // 1. Validate that enseignant is not null
        if(enseignant == null){
            throw new IllegalArgumentException("Enseignant cannot be null");
        }
        for(Enseignant existingEnseignant : enseignants){
            if(existingEnseignant.getId() == enseignant.getId()){
                return false;
            }
        }
        return enseignants.add(enseignant);
    }
    public List<Enseignant> getEnseignants() {
        return new ArrayList<>(enseignants);
    }
    public Enseignant rechercherEnseignantParId(int id) {

        // 1. Iterate through enseignants
        for(Enseignant enseignant : enseignants){
            if(enseignant.getId() == id){
                return enseignant;
            }
        }
        return null ;
    }

}
