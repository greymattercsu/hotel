/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkin;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.model.FrameworkMethod;
import org.junit.rules.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class CheckinCTLTest {
    
    //adding in the dummy variables need for the code to run properly
    Room room = new Room(111, RoomType.DOUBLE);
    
    Guest guest = new Guest("Saurav", "some address", 231245687);
    Date arrivalDate = new Date();

    int stayLength = 2;
    int occupantNumber = 2;
    CreditCard creditCard = new CreditCard(CreditCardType.MASTERCARD, 123456789, 236);
    Hotel hotel = new Hotel();
    long confirmationNumber = hotel.book(room, guest,arrivalDate, stayLength, occupantNumber,creditCard);
    ServiceType serviceType = ServiceType.ROOM_SERVICE;
//    long confirmationNumber = hotel.book(room, guest,arrivalDate, stayLength, occupantNumber,creditCard);
    Booking booking = new Booking(guest,room, arrivalDate,stayLength,occupantNumber, creditCard);
    static Booking bookingValue;
    Booking booked = new Booking(guest,room, arrivalDate,stayLength,occupantNumber, creditCard);;
    double cost = 20.0;
    ServiceCharge serviceCharge = new ServiceCharge(serviceType, cost);
    
    public CheckinCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of checkInConfirmed method, of class CheckinCTL.
     */
    @Test
    public void testCheckInConfirmed() {
        System.out.println("checkInConfirmed");

        //this dummy variable is set to true so that the condition that we are testing is working.
        boolean confirmed = true;
        
        //creating the object CheckinCTL  and passing in the hotel object
        CheckinCTL instance = new CheckinCTL(hotel);
    
        //this method passes in the confirmation number to the checkinCTL object
        instance.confirmationNumberEntered(confirmationNumber);
        
        //the real method to be tested is checked. This method works as expected.
        instance.checkInConfirmed(confirmed);
        
        
        
    }

    @Test
    //this is to check if the state is set to cancelled if the confirmed is set to false
    //the state is set to cancelled if the boolean is false.
    public void testCheckInConfirmed1() {
        System.out.println("checkInConfirmed for false statement");
        boolean confirmed = false;
        
        CheckinCTL instance = new CheckinCTL(hotel);
        
        
        instance.confirmationNumberEntered(confirmationNumber);
        
        
        instance.checkInConfirmed(confirmed);
        
        
        
    }

   
    //this is to check if the runtime exception is catched or not if the state is confirming
    //the code catches the state if it is confirming and then shows the run time exception
    @Test(expected = RuntimeException.class)
    
    public void testCheckInConfirmed3() {
        System.out.println("checkInConfirmed:Check in for null point exception");
        boolean confirmed = true;
        
        CheckinCTL instance = new CheckinCTL(hotel);
      
        instance.checkInConfirmed(confirmed);
        
        
        
    }

    
    
}
