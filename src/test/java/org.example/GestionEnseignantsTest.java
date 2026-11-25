package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GestionEnseignantsTest {
    @Test
    void ajouterEnseignant_WhenEnseignantIsNull_ThrowsException() {
        // Arrange
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        // Act & Assert
        assertThrows(IllegalArgumentException.class,()-> gestionEnseignants.ajouterEnseignant(null));
    }
    @Test
    void ajouterEnseignant_WhenEnseignantIsValid_ReturnsTrue() {
        // Arrange
        Enseignant enseignant = new Enseignant(1,"Ahmed","Ali","ahmed@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        // Act
        boolean result = gestionEnseignants.ajouterEnseignant(enseignant);
        // Assert
        assertTrue(result);
    }
    @Test
    void ajouterEnseignant_WhenValid_StoresEnseignant() {
        // Arrange
        Enseignant enseignant = new Enseignant(1,"Ahmed","Ali","ahmed@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        gestionEnseignants.ajouterEnseignant(enseignant);
        // Act & Assert
        assertEquals(1,gestionEnseignants.getEnseignants().size());
        assertSame(enseignant,gestionEnseignants.getEnseignants().get(0));
    }
    @Test
    void ajouterEnseignant_WhenIdAlreadyExists_ReturnsFalse() {
        // Arrange
        Enseignant enseignant1 = new Enseignant(1,"Ahmed","Ali","ahmed@gmail.com");
        Enseignant enseignant2 = new Enseignant(1,"karim","benani","benani@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        // Act
        gestionEnseignants.ajouterEnseignant(enseignant1);
        boolean result = gestionEnseignants.ajouterEnseignant(enseignant2);
        // Assert
        assertFalse(result);
        assertEquals(1,gestionEnseignants.getEnseignants().size());
        assertSame(enseignant1,gestionEnseignants.getEnseignants().get(0));
    }
    @Test
    void  getEnseignants_WhenReturnedListIsCleared_InternalListRemainsUnchanged() {
        // Arrange
        Enseignant enseignant1 = new Enseignant(1,"Ahmed","Ali","ahmed@gmail.com");
        Enseignant enseignant2 = new Enseignant(2,"karim","benani","benani@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        gestionEnseignants.ajouterEnseignant(enseignant1);
        gestionEnseignants.ajouterEnseignant(enseignant2);

        List<Enseignant> enseignants = gestionEnseignants.getEnseignants();
        assertEquals(2, enseignants.size());

        // Act
        enseignants.clear();

        // Assert
        assertEquals(0, enseignants.size());
        assertEquals(2, gestionEnseignants.getEnseignants().size());
    }
    @Test
    void rechercherEnseignantParId_WhenIdExists_ReturnsEnseignant() {
        // Arrange
        Enseignant enseignant1 = new Enseignant(101,"Ahmed","Ali","ahmed@gmail.com");
        Enseignant enseignant2 = new Enseignant(102,"karim","benani","benani@gmail.com");
        Enseignant enseignant3 = new Enseignant(103,"Khalid","jalil","jalil@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        gestionEnseignants.ajouterEnseignant(enseignant1);
        gestionEnseignants.ajouterEnseignant(enseignant2);
        gestionEnseignants.ajouterEnseignant(enseignant3);
        // Act
        Enseignant enseignant = gestionEnseignants.rechercherEnseignantParId(102);
        // Assert
        assertSame(enseignant2,enseignant);
    }
    @Test
    void rechercherEnseignantParId_WhenIdDoesNotExist_ReturnsNull() {
        // Arrange
        Enseignant enseignant1 = new Enseignant(101,"Ahmed","Ali","ahmed@gmail.com");
        Enseignant enseignant2 = new Enseignant(102,"karim","benani","benani@gmail.com");
        Enseignant enseignant3 = new Enseignant(103,"Khalid","jalil","jalil@gmail.com");
        GestionEnseignants gestionEnseignants = new GestionEnseignants();
        gestionEnseignants.ajouterEnseignant(enseignant1);
        gestionEnseignants.ajouterEnseignant(enseignant2);
        gestionEnseignants.ajouterEnseignant(enseignant3);
        // Act
        Enseignant enseignant = gestionEnseignants.rechercherEnseignantParId(999);
        // Assert
        assertNull(enseignant);
    }

}