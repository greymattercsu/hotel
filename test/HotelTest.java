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
     * Test of addRoom method, of class Hotel.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        RoomType roomType = null;
        int id = 0;
        Hotel instance = new Hotel();
        instance.addRoom(roomType, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRegistered method, of class Hotel.
     */
    @Test
    public void testIsRegistered() {
        System.out.println("isRegistered");
        int phoneNumber = 0;
        Hotel instance = new Hotel();
        boolean expResult = false;
        boolean result = instance.isRegistered(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerGuest method, of class Hotel.
     */
    @Test
    public void testRegisterGuest() {
        System.out.println("registerGuest");
        String name = "";
        String address = "";
        int phoneNumber = 0;
        Hotel instance = new Hotel();
        Guest expResult = null;
        Guest result = instance.registerGuest(name, address, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findGuestByPhoneNumber method, of class Hotel.
     */
    @Test
    public void testFindGuestByPhoneNumber() {
        System.out.println("findGuestByPhoneNumber");
        int phoneNumber = 0;
        Hotel instance = new Hotel();
        Guest expResult = null;
        Guest result = instance.findGuestByPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findActiveBookingByRoomId method, of class Hotel.
     */
    @Test
    public void testFindActiveBookingByRoomId() {
        System.out.println("findActiveBookingByRoomId");
        int roomId = 0;
        Hotel instance = new Hotel();
        Booking expResult = null;
        Booking result = instance.findActiveBookingByRoomId(roomId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAvailableRoom method, of class Hotel.
     */
    @Test
    public void testFindAvailableRoom() {
        System.out.println("findAvailableRoom");
        RoomType selectedRoomType = null;
        Date arrivalDate = null;
        int stayLength = 0;
        Hotel instance = new Hotel();
        Room expResult = null;
        Room result = instance.findAvailableRoom(selectedRoomType, arrivalDate, stayLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBookingByConfirmationNumber method, of class Hotel.
     */
    @Test
    public void testFindBookingByConfirmationNumber() {
        System.out.println("findBookingByConfirmationNumber");
        long confirmationNumber = 0L;
        Hotel instance = new Hotel();
        Booking expResult = null;
        Booking result = instance.findBookingByConfirmationNumber(confirmationNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
       System.out.println("checkin");
       long confirmationNumber = 0L;
       Hotel instance = new Hotel();
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
