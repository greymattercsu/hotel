import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
    System.out.println("Running Junit Test.");
    Result result = JUnitCore.runClasses(HotelTest1.class);
    System.out.println("[Test Executed]: " + result.getRunCount());
    System.out.println("[Test result]: " + result.wasSuccessful());
    for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
    }
   }
}