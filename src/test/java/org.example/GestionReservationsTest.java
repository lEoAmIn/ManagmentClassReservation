package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionReservationsTest {
    @Test
    void ajouterReservation_WhenReservationIsNull_ThrowsException() {
        // Arrange
        GestionReservations gestionReservations = new GestionReservations();
        // Act & Assert
        assertThrows(IllegalArgumentException.class,()-> gestionReservations.ajouterReservation(null));
    }
    @Test
    void ajouterReservation_WhenReservationIsValid_ReturnsTrue() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        Reservation reservation = new Reservation(109,s,e,debut,fin);
        GestionReservations gestionReservations = new GestionReservations();
        // Act// Assert
        assertTrue(gestionReservations.ajouterReservation(reservation));
    }
    @Test
    void ajouterReservation_WhenValid_StoresReservation() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        Reservation expectedReservation = new Reservation(109,s,e,debut,fin);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(expectedReservation);
        // Assert
        assertSame(expectedReservation,gestionReservations.getReservations().get(0));
    }
    @Test
    void getReservations_WhenReturnedListIsCleared_InternalListRemainsUnchanged() {
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        Reservation expectedReservation = new Reservation(109,s,e,debut,fin);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(expectedReservation);
        List<Reservation> list =  gestionReservations.getReservations();
        list.clear();
        // Assert
        assertEquals(0, list.size());
        assertEquals(1, gestionReservations.getReservations().size());
    }
    @Test
    void ajouterReservation_WhenSameSalleAndOverlappingDates_ReturnsFalse() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut1 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime debut2 = LocalDateTime.of(2026,11,19,10,15,0);
        LocalDateTime fin1 = LocalDateTime.of(2026,11,19,11,30,0);
        LocalDateTime fin2 = LocalDateTime.of(2026,11,19,12,30,0);

        Reservation reservation1 = new Reservation(109,s,e,debut1,fin1);
        Reservation reservation2 = new Reservation(105,s,e,debut2,fin2);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(reservation1);
        boolean result = gestionReservations.ajouterReservation(reservation2);

        // Assert
        assertFalse(result);
        assertEquals(1, gestionReservations.getReservations().size());
        assertSame(reservation1, gestionReservations.getReservations().get(0));
    }
    @Test
    void ajouterReservation_WhenSameSalleAndDatesAreAdjacent_ReturnsTrue() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut1 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime debut2 = LocalDateTime.of(2026,11,19,10,15,0);
        LocalDateTime fin1 = LocalDateTime.of(2026,11,19,10,15,0);
        LocalDateTime fin2 = LocalDateTime.of(2026,11,19,12,30,0);

        Reservation reservation1 = new Reservation(109,s,e,debut1,fin1);
        Reservation reservation2 = new Reservation(105,s,e,debut2,fin2);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(reservation1);
        boolean result = gestionReservations.ajouterReservation(reservation2);

        // Assert
        assertTrue(result);
        assertEquals(2, gestionReservations.getReservations().size());
        assertSame(reservation1, gestionReservations.getReservations().get(0));
        assertSame(reservation2, gestionReservations.getReservations().get(1));
    }
    @Test
    void ajouterReservation_WhenDifferentSallesAndOverlappingDates_ReturnsTrue() {
        // Arrange
        Salle s1 = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Salle s2 = new Salle(190,"Salle B",26,List.of("WiFi"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut1 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime debut2 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin1 = LocalDateTime.of(2026,11,19,10,15,0);
        LocalDateTime fin2 = LocalDateTime.of(2026,11,19,12,30,0);

        Reservation reservation1 = new Reservation(109,s1,e,debut1,fin1);
        Reservation reservation2 = new Reservation(105,s2,e,debut2,fin2);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(reservation1);
        boolean result = gestionReservations.ajouterReservation(reservation2);

        // Assert
        assertTrue(result);
        assertEquals(2, gestionReservations.getReservations().size());
        assertSame(reservation1, gestionReservations.getReservations().get(0));
        assertSame(reservation2, gestionReservations.getReservations().get(1));
    }
    @Test
    void ajouterReservation_WhenIdAlreadyExists_ReturnsFalse() {
        // Arrange
        Salle s1 = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Salle s2 = new Salle(190,"Salle B",26,List.of("WiFi"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut1 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime debut2 = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin1 = LocalDateTime.of(2026,11,19,10,15,0);
        LocalDateTime fin2 = LocalDateTime.of(2026,11,19,12,30,0);

        Reservation reservation1 = new Reservation(109,s1,e,debut1,fin1);
        Reservation reservation2 = new Reservation(109,s2,e,debut2,fin2);
        GestionReservations gestionReservations = new GestionReservations();
        // Act
        gestionReservations.ajouterReservation(reservation1);
        boolean result = gestionReservations.ajouterReservation(reservation2);

        // Assert
        assertFalse(result);
        assertEquals(1, gestionReservations.getReservations().size());
        assertSame(reservation1, gestionReservations.getReservations().get(0));
    }
}