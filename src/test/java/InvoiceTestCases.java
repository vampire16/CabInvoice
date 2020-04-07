import com.bridgeLabz.service.InvoiceGenerator;
import com.bridgeLabz.service.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceTestCases {

    @Test
    public void givenDistanceAndTime__ThenReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0);
    }

    @Test
    public void givenDistanceOrTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0,5),
                         new Ride(0.1,1)
        };
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30, fare, 0);
    }
}
