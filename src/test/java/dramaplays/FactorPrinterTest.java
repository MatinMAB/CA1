package dramaplays;

import dramaplays.model.Invoice;
import dramaplays.model.Performance;
import dramaplays.model.Play;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static dramaplays.FactorPrinter.print;
import static org.junit.jupiter.api.Assertions.*;

class FactorPrinterTest {

    @Test
    void testPrintWithTrueCustomer() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20)
        ));
        Play play = new Play("Play0","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play);

        //Act
        String result = print(invoice, playID0);
        String expectedTitle = String.format("Factor for %s\n", invoice.customer);

        //Assert
        assertTrue(result.startsWith(expectedTitle));

    }

    @Test
    void testPrintWithSinglePerformanceAndTrueTotalPrice() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20)
        ));
        Play play = new Play("Play0","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play);

        //Act
        String result = print(invoice, playID0);
        String expectedTotalLine = String.format("Amount owed is $%s.00\n",invoice.performances.getFirst().audience() * 18);

        //Assert
        assertTrue(result.contains(expectedTotalLine));
    }

    @Test
    void testPrintWithSinglePerformanceAndTrueCredits() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20)
        ));
        Play play = new Play("Play0","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play);

        //Act
        String result = print(invoice, playID0);
        String expectedCreditsLine = "You earned 4 credits\n";

        //Assert
        assertTrue(result.contains(expectedCreditsLine));
    }

    @Test
    void testPrintWithDuplicatePerformanceAndTruePricePerPerformance() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20),
                new Performance("PlayID0",30)
        ));
        Play play = new Play("Play0","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play);

        //Act
        String result = print(invoice, playID0);
        for (int i = 0; i < invoice.performances.size() ; i++) {
            String expectedPriceLine = String.valueOf(invoice.performances.get(i).audience() * 18);

            //Assert
            assertTrue(result.contains(expectedPriceLine));
        }
    }

    @Test
    void testPrintWithMultiplePerformanceAndSameTypeAndTrueTotalPrice() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20),
                new Performance("PlayID1",30)
        ));
        Play play0 = new Play("Play0","comedy");
        Play play1 = new Play("Play1","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play0, "PlayID1", play1);

        //Act
        int total = 0;
        String result = print(invoice, playID0);
        for (int i = 0; i < invoice.performances.size() ; i++) {
            total += invoice.performances.get(i).audience() * 18;
        }
        String expectedPriceLine = String.valueOf(total);

        //Assert
        assertTrue(result.contains(expectedPriceLine));
    }
    @Test
    void testPrintWithMultiplePerformanceAndDifferentTypeAndTrueTotalPrice() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20),
                new Performance("PlayID1",20)
        ));
        Play play0 = new Play("Play0","comedy");
        Play play1 = new Play("Play1","tragedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play0, "PlayID1", play1);

        //Act
        String result = print(invoice, playID0);
        String expectedPriceLine = "Amount owed is $760.00";

        //Assert
        assertTrue(result.contains(expectedPriceLine));
    }

    @Test
    void testPrintWithMultiplePerformanceAndTrueCredits() {
        //Arrange
        Invoice invoice = new Invoice("Matin", List.of(
                new Performance("PlayID0",20),
                new Performance("PlayID0",30)
        ));
        Play play = new Play("Play0","comedy");
        Map<String, Play> playID0 = Map.of("PlayID0", play);

        //Act
        String result = print(invoice, playID0);
        String expectedCreditsLine = "You earned 10 credits\n";

        //Assert
        assertTrue(result.contains(expectedCreditsLine));
    }
}