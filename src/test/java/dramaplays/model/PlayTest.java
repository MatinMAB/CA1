package dramaplays.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {
    @Test
    public void testTruePlayCreation() {
        // Arrange
        String name = "Play1";
        String type = "comedy";

        //Act
        Play play = new Play(name, type);

        //Assert
        assertEquals(name, play.name);
        assertEquals(type, play.type);
    }

}