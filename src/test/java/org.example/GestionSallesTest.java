package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GestionSallesTest {
    @Test
    void ajouterSalle_WhenSalleIsNull_ThrowsException() {
        // Arrange
        GestionSalles gestionSalles = new GestionSalles();
        // Act & Assert
        assertThrows(IllegalArgumentException.class,()->gestionSalles.ajouterSalle(null));
    }
    @Test
    void ajouterSalle_WhenSalleIsValid_ReturnsTrue() {
        // Arrange
        Salle salle = new Salle(1,"Salle A",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act
         boolean result = gestionSalles.ajouterSalle(salle);
        // Assert
        assertTrue(result);
    }
    @Test
    void ajouterSalle_WhenSalleIsValid_StoresSalle() {
        // Arrange
        Salle salle = new Salle(1,"Salle A",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act
        boolean result = gestionSalles.ajouterSalle(salle);
        // Assert
        assertTrue(result);
        assertEquals(1,gestionSalles.getSalles().size());
        assertSame(salle,gestionSalles.getSalles().get(0));
    }
    @Test
    void ajouterSalle_WhenIdAlreadyExists_ReturnsFalse() {
        // Arrange
        Salle salle1 = new Salle(1,"Salle A",16,List.of("Wifi"));
        Salle salle2 = new Salle(1,"Salle B",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act
        gestionSalles.ajouterSalle(salle1);
        boolean result = gestionSalles.ajouterSalle(salle2);
        // Assert
        assertFalse(result);
        assertEquals(1,gestionSalles.getSalles().size());
        assertSame(salle1,gestionSalles.getSalles().get(0));
    }
    @Test
    void getSalles_WhenReturnedListIsCleared_InternalListRemainsUnchanged() {
        // Arrange
        Salle salle1 = new Salle(1,"Salle A",16,List.of("Wifi"));
        Salle salle2 = new Salle(2,"Salle B",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act & Assert
        gestionSalles.ajouterSalle(salle1);
        gestionSalles.ajouterSalle(salle2);
        List<Salle> result = gestionSalles.getSalles();
        assertEquals(2,result.size());
        result.clear();
        assertEquals(2,gestionSalles.getSalles().size());
        assertEquals(0,result.size());
    }
    @Test
    void rechercherSalleParId_WhenIdExists_ReturnsSalle() {
        // Arrange
        Salle salle1 = new Salle(101,"Salle A",16,List.of("Wifi"));
        Salle salle2 = new Salle(102,"Salle B",16,List.of("Wifi"));
        Salle salle3 = new Salle(103,"Salle C",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act
        gestionSalles.ajouterSalle(salle1);
        gestionSalles.ajouterSalle(salle2);
        gestionSalles.ajouterSalle(salle3);
        Salle salle = gestionSalles.rechercherSalleParId(102);
        // Assert
        assertSame(salle2,salle);
    }
    @Test
    void rechercherSalleParId_WhenIdDoesNotExist_ReturnsNull() {
        // Arrange
        Salle salle1 = new Salle(101,"Salle A",16,List.of("Wifi"));
        Salle salle2 = new Salle(102,"Salle B",16,List.of("Wifi"));
        Salle salle3 = new Salle(103,"Salle C",16,List.of("Wifi"));
        GestionSalles gestionSalles = new GestionSalles();
        // Act
        gestionSalles.ajouterSalle(salle1);
        gestionSalles.ajouterSalle(salle2);
        gestionSalles.ajouterSalle(salle3);
        Salle salle = gestionSalles.rechercherSalleParId(105);
        // Assert
        assertNull(salle);    }
}