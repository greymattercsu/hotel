package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    static JUnitCore junitCore;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please pass valid arguments 'Unit' or 'integration'");
        } else {
            if (args[0].equalsIgnoreCase("unit")) {
                System.out.println("Running Unit Test.");
                Result result = JUnitCore.runClasses(BookingJunitTest.class);
                System.out.println("[Test Executed]: " + result.getRunCount());
                System.out.println("[Test result]: " + result.wasSuccessful());

            } else if (args[0].equalsIgnoreCase("integration")) {
                Result result2 = JUnitCore.runClasses(BookingCTLTest.class);
                System.out.println("[Test Executed]: " + result2.getRunCount());
                System.out.println("[Test result]: " + result2.wasSuccessful());
            } else {
                System.out.println("Please pass valid arguments 'Unit' or 'integration'");
            }
        }
    }
}