package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EnseignantTest {

    @Test
    void constructor_WhenEmailIsInvalid_ThrowsException(){
        assertThrows(IllegalArgumentException.class,() -> new Enseignant(103,"Ahmed","Ali","dwdw@dxh"));
    }
    @Test
    void constructor_WhenEmailIsValid_CreatesEnseignant(){
        // arrange
        Enseignant enseignant = new Enseignant(1,"Ahmed","Ali","ahmed@gmail.com");
        // act
        String result = enseignant.getEmail();
        // Assert
        assertEquals("ahmed@gmail.com",result);
    }
    @Test
    void constructor_WhenIdIsNegative_ThrowsException() {
     assertThrows(IllegalArgumentException.class,() -> new Enseignant(-12,"Ahmed","Ali","ahmed@gmail.com"));    }
}
