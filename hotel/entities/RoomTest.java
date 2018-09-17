/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

//import com.sun.java.swing.plaf.windows.TMSchema;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SANCHAY
 */
public class RoomTest {

    public RoomTest() {
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
     * Test of book method, of class Room.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        Guest guest = new Guest("name", "address", 123456);//String name, String address, int phoneNumber
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 123, 333); //CreditCard(CreditCardType type, int number, int ccv)
        Room instance = new Room(3, RoomType.SINGLE); //int id, RoomType roomType
        Booking expResult = new Booking(guest, instance, arrivalDate, stayLength, numberOfOccupants, creditCard);
//Booking(Guest guest, Room room, Date arrivalDate, int stayLength, int numberOfOccupants, CreditCard creditCard)
        Booking result = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        assertEquals(expResult.getConfirmationNumber(), result.getConfirmationNumber());
        assertEquals(expResult.getCreditCard(), result.getCreditCard());
        assertEquals(expResult.isCheckedIn(), result.isCheckedIn());
        //        fail("The test case is a prototype.");
    }

    /**
     * Test of checkin method, of class Room.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
        Room instance = new Room(3, RoomType.SINGLE);
        instance.checkin();
        assertEquals("OCCUPIED", instance.enumString());
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of checkout method, of class Room.
//     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        Guest guest = new Guest("name", "address", 123456);//String name, String address, int phoneNumber
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 143, 999); //CreditCard(CreditCardType type, int number, int ccv)        
        Room instance = new Room(5, RoomType.DOUBLE);

        int bookingListSizeAtFirst = instance.bookings.size();
        Booking booking = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        int bookingListSizeAfterBook = instance.bookings.size();
        booking.checkIn();

        instance.checkout(booking);
        int bookingListSizeAfterCheckOut = instance.bookings.size();
        assertEquals("READY", instance.enumString());
        assertEquals(bookingListSizeAtFirst + 1, bookingListSizeAfterBook);
        assertEquals(bookingListSizeAfterBook - 1, bookingListSizeAfterCheckOut);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
