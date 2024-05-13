package dramaplays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorPrinterTest {

    private FactorPrinter factorPrinter;
    private Invoice invoice;
    private Map<String, Play> plays;

    @BeforeEach
    void setUp() {
        factorPrinter = new FactorPrinter();

        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("Hamlet", 55));
        performances.add(new Performance("Othello", 35));

        invoice = new Invoice("John Doe", performances);

        plays = new HashMap<>();
        plays.put("Hamlet", new Play("Hamlet", "tragedy"));
        plays.put("Othello", new Play("Othello", "tragedy"));
    }

    @AfterEach
    void tearDown() {
        factorPrinter = null;
        invoice = null;
        plays = null;
    }

    @Test
    void testPrintInvoiceForTragedies() {
        String expectedResult = "Factor for John Doe\n" +
                "  Hamlet: $650.00 (55 seats)\n" +
                "  Othello: $450.00 (35 seats)\n" +
                "Amount owed is $1,100.00\n" +
                "You earned 30 credits\n";

        String result = factorPrinter.print(invoice, plays);
        assertEquals(expectedResult, result);
    }

    @Test
    void testPrintInvoiceForComedies() {
        plays.put("Hamlet", new Play("Hamlet", "comedy"));
        plays.put("Othello", new Play("Othello", "comedy"));

        String expectedResult = "Factor for John Doe\n" +
                "  Hamlet: $740.00 (55 seats)\n" +
                "  Othello: $580.00 (35 seats)\n" +
                "Amount owed is $1,320.00\n" +
                "You earned 48 credits\n";

        String result = factorPrinter.print(invoice, plays);
        assertEquals(expectedResult, result);
    }

    @Test
    void testPrintInvoiceWithMixedPlays() {
        plays.put("Hamlet", new Play("Hamlet", "tragedy"));
        plays.put("Othello", new Play("Othello", "comedy"));

        String expectedResult = "Factor for John Doe\n" +
                "  Hamlet: $650.00 (55 seats)\n" +
                "  Othello: $580.00 (35 seats)\n" +
                "Amount owed is $1,230.00\n" +
                "You earned 37 credits\n";

        String result = factorPrinter.print(invoice, plays);
        assertEquals(expectedResult, result);
    }

    @Test
    void testPrintInvoiceWithUnknownPlayType() {
        plays.put("Hamlet", new Play("Hamlet", "unknown"));

        assertThrows(Error.class, () -> factorPrinter.print(invoice, plays));
    }

    @Test
    void testPrintInvoiceWithNullPerformances() {
        invoice = new Invoice("John Doe", null);

        assertThrows(NullPointerException.class, () -> factorPrinter.print(invoice, plays));
    }

    @Test
    void testPrintInvoiceWithNullPlays() {
        assertThrows(NullPointerException.class, () -> factorPrinter.print(invoice, null));
    }

    @Test
    void testPrintInvoiceWithNullCustomer() {
        invoice = new Invoice(null, invoice.performances);

        try {
            assertThrows(NullPointerException.class, () -> factorPrinter.print(invoice, plays));
        } catch (AssertionError e) {
            System.out.println("Expected: NullPointerException to be thrown");
            System.out.println("Actual: " + e.getMessage());
            throw e;
        }
    }
}