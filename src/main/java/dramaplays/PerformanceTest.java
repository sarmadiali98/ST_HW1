package dramaplays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    private Performance performance;

    @BeforeEach
    void setUp() {
        performance = new Performance("Hamlet", 55);
    }

    @AfterEach
    void tearDown() {
        performance = null;
    }

    @Test
    void testPerformanceConstructor() {
        assertEquals("Hamlet", performance.playID);
        assertEquals(55, performance.audience);
    }

    @Test
    void testSetPlayID() {
        performance.playID = "Macbeth";
        assertEquals("Macbeth", performance.playID);
    }



    @Test
    void testSetAudience() {
        performance.audience = 100;
        assertEquals(100, performance.audience);
    }



    @Test
    void testSetAudienceWithZero() {
        performance.audience = 0;
        assertEquals(0, performance.audience);
    }

    @Test
    void testPerformanceConstructorWithNullPlayID() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Performance(null, 55));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Performance with null playID");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testPerformanceConstructorWithNegativeAudience() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Performance("Hamlet", -10));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Performance with negative audience");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testSetPlayIDWithNull() {
        performance = new Performance("Hamlet", 55);
        try {
            assertThrows(IllegalArgumentException.class, () -> performance.playID = null);
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when setting null playID");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testSetAudienceWithNegativeValue() {
        performance = new Performance("Hamlet", 55);
        try {
            assertThrows(IllegalArgumentException.class, () -> performance.audience = -20);
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when setting negative audience");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }
}