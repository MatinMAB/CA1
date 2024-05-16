package dramaplays.model;

import org.junit.jupiter.api.Test;
import requisite.Main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class InvoiceTest {

    @Test
    public void testTrueInvoiceCreation() {
        // Arrange
        String customerName = "Matin";
        List<Performance> performances = new ArrayList<>();

        //Act
        Invoice invoice = new Invoice(customerName, performances);

        //Assert
        assertEquals(customerName, invoice.customer);
        assertEquals(performances, invoice.performances);
    }
    @Test
    public void testTrueSimplePerformanceReferencesCreation() {
        // Arrange
        String customerName = "Matin";
        List<Performance> performances = new ArrayList<>();

        //Act
        Invoice invoice = new Invoice(customerName, performances);

        //Assert
        assertSame(performances, invoice.performances);
    }

    @Test
    public void testTrueMultiplePerformanceReferencesCreation() {
        // Arrange
        String customerName = "Matin";
        List<Performance> performances1 = new ArrayList<>();
        List<Performance> performances2 = new ArrayList<>();

        //Act
        Invoice invoice = new Invoice(customerName, performances1);

        //Assert
        assertNotSame(performances2, invoice.performances);
    }
}