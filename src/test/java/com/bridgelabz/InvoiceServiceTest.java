package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    /**
     * Given Distance and Time
     * return total fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /**
     * Given Less Distance and Time
     * return minimum fare as 5
     */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
}