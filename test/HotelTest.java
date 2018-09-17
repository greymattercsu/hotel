/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.*;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.*;
import org.junit.runner.*;
import org.junit.rules.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import hotel.entities.*;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class HotelTest {

    //creating dummy datas for testing
    Room room = new Room(111, RoomType.DOUBLE);
    
    Guest guest = new Guest("Saurav", "some address", 231245687);
    Date arrivalDate = new Date();
    int stayLength = 2;
    int occupantNumber = 2;
    CreditCard creditCard = new CreditCard(CreditCardType.MASTERCARD, 123456789, 236);
    Hotel instance = new Hotel();
    long result = instance.book(room, guest, arrivalDate, stayLength, occupantNumber, creditCard);;
    ServiceType serviceType = ServiceType.ROOM_SERVICE;
    public Map<Long, Booking> bookingsByConfirmationNumber;
    public Map<Integer, Booking> activeBookingsByRoomId;
    public Booking booking = new Booking(guest,room, arrivalDate,stayLength,occupantNumber, creditCard);
    
    public HotelTest() {
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
     * Test of book method, of class Hotel.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        Room room = null;
        Guest guest = null;
        Date arrivalDate = null;
        int stayLength = 0;
        int occupantNumber = 0;
        CreditCard creditCard = null;
        Hotel instance = new Hotel();
        long expResult = 0L;
        long result = instance.book(room, guest, arrivalDate, stayLength, occupantNumber, creditCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkin method, of class Hotel.
     */
   @Test
   public void testCheckin() {
       System.out.println("Testing of checkin method");
       long confirmationNumber = result;
       instance.checkin(confirmationNumber);
       // TODO review the generated test code and remove the default call to fail.
       fail("The test case is a prototype.");
   }

    /**
     * Test of addServiceCharge method, of class Hotel.
     */
    // @Test
    // public void testAddServiceCharge() {
    //     System.out.println("addServiceCharge");
    //     int roomId = 0;
    //     ServiceType serviceType = null;
    //     double cost = 0.0;
    //     Hotel instance = new Hotel();
    //     instance.addServiceCharge(roomId, serviceType, cost);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

    /**
     * Test of checkout method, of class Hotel.
     */
    // @Test
    // public void testCheckout() {
    //     System.out.println("checkout");
    //     int roomId = 0;
    //     Hotel instance = new Hotel();
    //     instance.checkout(roomId);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }
    
}
