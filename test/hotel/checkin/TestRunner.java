/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hotel.checkin;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    
    static JUnitCore junitCore;
   
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
