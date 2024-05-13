package dramaplays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    private Invoice invoice;
    private List<Performance> performances;

    @BeforeEach
    void setUp() {
        performances = new ArrayList<>();
        performances.add(new Performance("Hamlet", 55));
        performances.add(new Performance("Othello", 35));
    }

    @AfterEach
    void tearDown() {
        invoice = null;
        performances = null;
    }

    @Test
    void testInvoiceConstructor() {
        invoice = new Invoice("John Doe", performances);
        assertEquals("John Doe", invoice.customer);
        assertEquals(performances, invoice.performances);
    }

    @Test
    void testSetCustomer() {
        invoice = new Invoice("John Doe", performances);
        invoice.customer = "Jane Smith";
        assertEquals("Jane Smith", invoice.customer);
    }

    @Test
    void testSetPerformances() {
        invoice = new Invoice("John Doe", performances);
        List<Performance> newPerformances = new ArrayList<>();
        newPerformances.add(new Performance("Macbeth", 60));
        invoice.performances = newPerformances;
        assertEquals(newPerformances, invoice.performances);
    }

    @Test
    void testSetPerformancesWithNullList() {
        invoice = new Invoice("John Doe", performances);
        try {
            assertThrows(IllegalArgumentException.class, () -> invoice.performances = null);
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when setting performances to null");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testInvoiceConstructorWithNullCustomer() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Invoice(null, performances));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Invoice with null customer");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }

    @Test
    void testInvoiceConstructorWithNullPerformances() {
        try {
            assertThrows(IllegalArgumentException.class, () -> new Invoice("John Doe", null));
        } catch (AssertionError e) {
            System.out.println("Expected: IllegalArgumentException to be thrown when creating Invoice with null performances");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }
}