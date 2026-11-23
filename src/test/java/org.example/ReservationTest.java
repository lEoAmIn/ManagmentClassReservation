package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationTest {
    @Test
    void constructor_WhenDatesAreValid_CreatesReservation() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime expectedDebut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime expectedFin = LocalDateTime.of(2026,11,19,11,30,0);
        Reservation reservation = new Reservation(109,s,e,expectedDebut,expectedFin);
        // Act
        LocalDateTime debut = reservation.getDebut();
        LocalDateTime fin = reservation.getFin();
        // Assert
        assertEquals(expectedDebut,debut);
        assertEquals(expectedFin,fin);

    }
    @Test
    void constructor_WhenFinIsBeforeDebut_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime expectedDebut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime expectedFin = LocalDateTime.of(2026,11,19,8,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,s,e,expectedDebut,expectedFin));

    }
    @Test
    void constructor_WhenFinEqualsDebut_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,9,15,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,s,e,debut,fin));
    }
    @Test
    void constructor_WhenIdIsNegative_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(-109,s,e,debut,fin));
    }
    @Test
    void constructor_WhenSalleIsNull_ThrowsException() {
        // Arrange
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,null,e,debut,fin));
    }
    @Test
    void constructor_WhenEnseignantIsNull_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        LocalDateTime debut = LocalDateTime.of(2026,11,19,9,15,0);
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,s,null,debut,fin));
    }
    @Test
    void constructor_WhenDebutIsNull_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime fin = LocalDateTime.of(2026,11,19,11,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,s,e,null,fin));

    }
    @Test
    void constructor_WhenFinIsNull_ThrowsException() {
        // Arrange
        Salle s = new Salle(199,"Salle A",26,List.of("WiFi","LapTop"));
        Enseignant e = new Enseignant(107,"Ahmed","Ali","Ahmed@gmail.com");
        LocalDateTime debut = LocalDateTime.of(2026,11,19,11,30,0);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Reservation(109,s,e,debut,null));
    }
}
