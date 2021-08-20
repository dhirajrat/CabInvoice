package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator =null;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double distance=2.0;
        int time=5;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_shouldReturnMinFare() {

        double distance=0.1;
        int time=1;
        double fare= invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {

        Ride[] rides= {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary =invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary= new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceSummary() {
        String userID="p@l.com";
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1)};
        invoiceGenerator.addRides(userID,rides);
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides,"normal");
        InvoiceSummary invoiceSummary=invoiceGenerator.getInvoiceSummary(userID);
        Assert.assertEquals(invoiceSummary,summary);

    }
}