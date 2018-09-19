/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meinong
 */
public class BookingTest {
    
    public BookingTest() {
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
     * Test of checkin method, of class Booking.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
        Guest guest = new Guest("aaa", "address", 123456);
        Room room = new Room(1, RoomType.SINGLE);
        CreditCard cc = new CreditCard(CreditCardType.MASTERCARD, 123456, 333);
//        	public Booking(Guest guest, Room room, Date arrivalDate, int stayLength, int numberOfOccupants, CreditCard creditCard)
        Booking instance = new Booking(guest, room, new Date(), 4, 4, cc);
        instance.checkin();        
//        System.out.println(instance.isCheckedIn());
        assertEquals(true, instance.isCheckedIn());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addServiceCharge method, of class Booking.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
         Guest guest = new Guest("aaa", "address", 123456);
        Room room = new Room(1, RoomType.SINGLE);
        CreditCard cc = new CreditCard(CreditCardType.MASTERCARD, 123456, 333);
        Booking instance = new Booking(guest, room, new Date(), 4, 4, cc);
        
        ServiceType st = ServiceType.ROOM_SERVICE;
        instance.checkin();
        instance.addServiceCharge(st, 22);
        assertEquals(true, instance.isCheckedIn());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkOut method, of class Booking.
     */
    @Test
    public void testCheckOut() {
        System.out.println("checkOut");
        
        Guest guest = new Guest("aaa", "address", 123456);
        Room room = new Room(1, RoomType.SINGLE);
        CreditCard cc = new CreditCard(CreditCardType.MASTERCARD, 123456, 333);
        Booking instance = new Booking(guest, room, new Date(), 4, 4, cc);
        
        //Booking instance = null;
        
        
        instance.checkin();
        assertEquals(true, instance.isCheckedIn());
        // TODO review the generated test code and remove the default call to fail.
        //ail("The test case is a prototype.");
    }
    
}
