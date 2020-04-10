import com.bridgeLabz.service.InvoiceGenerator;
import com.bridgeLabz.service.InvoiceSummary;
import com.bridgeLabz.service.Ride;
import com.bridgeLabz.service.TypesOfCab;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTestCases {

    @Test
    public void givenDistanceAndTime__ThenReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.NORMAL_RIDE);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0);
    }

    @Test
    public void givenDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.NORMAL_RIDE);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.NORMAL_RIDE);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnSummary() {
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.NORMAL_RIDE);
        invoiceGenerator.userRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenDistanceAndTime__ThenReturnPremiumTotalFare() {
        double distance = 2.0;
        int time = 5;
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.PREMIUM_RIDE);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(40, fare, 0);
    }

    @Test
    public void givenDistanceOrTime_ShouldReturnPremiumMinFare() {
        double distance = 0.1;
        int time = 1;
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.PREMIUM_RIDE);
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(20, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnPremiumSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.PREMIUM_RIDE);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnPremiumSummary() {
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(TypesOfCab.PREMIUM_RIDE);
        invoiceGenerator.userRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedSummary, summary);
    }
}
