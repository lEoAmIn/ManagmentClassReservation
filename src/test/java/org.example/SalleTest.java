package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class SalleTest {
    @Test
    void constructor_WhenCapacityIsNegative_throwsException(){
        // Arange : Prapare invalid data
        // Act + Assert :verify the expected exception
        assertThrows(IllegalArgumentException.class,() -> new Salle(1, "Salle A", -5, List.of()));
    }
    @Test
    void constructor_WhenCapacityIsValid_StoresCapacity() {

        // Arrange
        Salle salle = new Salle(
                101, "Salle Informatique", 30, List.of("WiFi")
        );

        // Act
        int result = salle.getCapacite();

        // Assert
        assertEquals(30,salle.getCapacite());
    }
}
