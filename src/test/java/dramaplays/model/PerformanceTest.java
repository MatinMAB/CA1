package dramaplays.model;

import org.junit.jupiter.api.Test;
import requisite.Main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    @Test
    public void testTruePerformanceCreation() {
        // Arrange
        String PlayID = "Play01";
        int audience = 100;

        //Act
        Performance performance = new Performance(PlayID, audience);

        //Assert
        assertEquals(PlayID, performance.playID());
        assertEquals(audience, performance.audience());
    }
    @Test
    public void testInvoiceCreationByTrueEmptyPerformanceListInitialization() {
        // Arrange
        String customerName = "Matin";
        List<Performance> performances = new ArrayList<>();

        //Act
        Invoice invoice = new Invoice(customerName, performances);

        //Assert
        assertTrue(invoice.performances.isEmpty());
    }

    @Test
    public void testInvoiceCreationByTruePerformanceCreation() {
        // Arrange
        String customerName = "Matin";
        List<Performance> performances = new ArrayList<>();

        //Act
        Invoice invoice = new Invoice(customerName, performances);

        //Assert
        assertNotNull(invoice.performances);
    }

}