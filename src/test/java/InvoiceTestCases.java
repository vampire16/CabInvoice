import com.bridgeLabz.service.InvoiceGenerator;
import com.bridgeLabz.service.InvoiceSummary;
import com.bridgeLabz.service.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTestCases {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime__ThenReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0);
    }

    @Test
    public void givenDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnSummary() {
        Ride[] rides = { new Ride(2.0,5),
                new Ride(0.1,1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }
}
