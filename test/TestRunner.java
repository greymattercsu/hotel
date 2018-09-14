package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    static JUnitCore junitCore;

    public static void main(String[] args) {
        System.out.println("Running Unit Test.");
        Result result = JUnitCore.runClasses(BookingJunitTest.class);
        System.out.println("[Test Executed]: " + result.getRunCount());
        System.out.println("[Test result]: " + result.wasSuccessful());      
    }
}  	