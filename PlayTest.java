package dramaplays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    private Play play;

    @BeforeEach
    void setUp() {
        // Create a new instance of Play for each test
        play = new Play("Hamlet", "tragedy");
    }

    @AfterEach
    void tearDown() {
        // Clean up any resources used in the test
        play = null;
    }

    @Test
    void testPlayConstructor() {
        assertEquals("Hamlet", play.name);
        assertEquals("tragedy", play.type);
    }

    @Test
    void testSetName() {
        play.name = "Macbeth";
        assertEquals("Macbeth", play.name);
    }

    @Test
    void testSetType() {
        play.type = "comedy";
        assertEquals("comedy", play.type);
    }

    @Test
    void testPlayConstructorWithNullName() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Play(null, "tragedy"));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Play with null name");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testPlayConstructorWithNullType() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Play("Hamlet", null));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Play with null type");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testPlayConstructorWithEmptyName() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Play("", "tragedy"));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Play with empty name");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testPlayConstructorWithEmptyType() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Play("Hamlet", ""));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Play with empty type");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }
}