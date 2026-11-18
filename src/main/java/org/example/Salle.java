import java.util.List ;
import java.util.ArrayList;

public class Salle {
    // Attributs de la classe Salle
    private int id ;
    private String nom ;
    private int capacite ;
    private List<String> equipements;

// the constructor of the class sale
    public Salle(int id , String nom , int capacite ,List<String> equipements ){
        if (id <= 0){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
        if (nom == null || nom.isBlank()){
            throw new IllegalArgumentException("Invalid name ");
        }
        this.nom = nom ;
        if (capacite <= 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }
        this.capacite = capacite;
        if (equipements == null ){
            throw new IllegalArgumentException("Invalid equipment list");
        }
        this.equipements = new ArrayList<>(equipements);
    }
// Getters des attributs
   public int getId(){
        return id;
    }
    public String getNom(){
        return nom ;
    }
    public int getCapacite(){
        return capacite;
    }

    public List<String> getEquipements() {
        return new ArrayList<>(equipements);
    }
     public boolean possedeEquipement(String equipementName){
        return equipements.contains(equipementName);
     }
}
