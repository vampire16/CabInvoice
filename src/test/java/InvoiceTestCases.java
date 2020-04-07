import com.bridgeLabz.service.InvoiceGenerator;
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
}
