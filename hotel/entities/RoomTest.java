package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testBookCheckConfNumber() {
        System.out.println("Testing Confirmation Number");
        Guest guest = new Guest("name", "address", 123456);
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 123, 333);
        Room instance = new Room(3, RoomType.SINGLE);
        Booking expResult = new Booking(guest, instance, arrivalDate, stayLength, numberOfOccupants, creditCard);
        Booking result = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        System.out.println("Expected Confirmation Number = " + expResult.getConfirmationNumber() + " \nResult Confirmation Number = " + result.getConfirmationNumber());
        assertEquals(expResult.getConfirmationNumber(), result.getConfirmationNumber());
    }

    @Test
    public void testBookCheckBookingList() {
        System.out.println("Test if booking is added to list by checking Size of List<Booking> bookings.");
        Guest guest = new Guest("name1", "address1", 1123456);
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 123, 333);
        Room instance = new Room(3, RoomType.SINGLE);
        int initialBookingSize = instance.bookings.size();
        Booking expResult = new Booking(guest, instance, arrivalDate, stayLength, numberOfOccupants, creditCard);
        Booking result = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        int finalBookingSize = instance.bookings.size();
        System.out.println("Initial Booking Size = " + initialBookingSize + ",\nFinal Booking Size = " + finalBookingSize);
        assertEquals(initialBookingSize + 1, finalBookingSize);
//        assertEquals(expResult.isCheckedIn(), result.isCheckedIn());
    }

    @Test
    public void testBookCheckIn() {
        System.out.println("Test the checkin status of booking.");
        Guest guest = new Guest("name1", "address1", 1123456);
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 123, 333);
        Room instance = new Room(3, RoomType.SINGLE);
        Booking expResult = new Booking(guest, instance, arrivalDate, stayLength, numberOfOccupants, creditCard);
        Booking result = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        System.out.println("Expected checkIn = " + expResult.isCheckedIn() + ",\nResult checkIn = " + result.isCheckedIn());
        assertEquals(expResult.isCheckedIn(), result.isCheckedIn());
    }

    /**
     * Test of checkin method, of class Room.
     */
    @Test
    public void testCheckinOccupied() {
        System.out.println("Test if room state is changed after checkin ");
        Room instance = new Room(3, RoomType.SINGLE);
        instance.checkin();
        System.out.println("Expected state =  OCCUPIED \nResult state = " + instance.enumString());
        System.out.println(instance.enumString());
        assertEquals("OCCUPIED", instance.enumString());
    }

    @Test
    public void testCheckinRuntimeException() {
        System.out.println("Test Runtime Exception when room is already occupied");
        Room instance = new Room(3, RoomType.SINGLE);
        instance.checkin();     //this statement changes the state of the room to OCCUPIED
        System.out.println("Expected: Runtime Exception");
        instance.checkin();     //again call the same method to throw the runtime exception
    }

    /**
     * Test of checkout method, of class Room.
     */
    @Test
    public void testCheckoutState() {
        System.out.println("Test the checkout and the state must be ready after checkout");
        Guest guest = new Guest("name", "address", 123456);//String name, String address, int phoneNumber
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 143, 999); //CreditCard(CreditCardType type, int number, int ccv)        
        Room instance = new Room(5, RoomType.DOUBLE);

        Booking booking = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        booking.checkIn();

        instance.checkout(booking);
        System.out.println("Expected state =  READY \nResult state = " + instance.enumString());
        assertEquals("READY", instance.enumString());
    }

    /**
     * Test of checkout method, of class Room.
     */
    @Test
    public void testCheckoutRuntimeException() {
        System.out.println("Test Runtime Exception when room is not occupied");
        Guest guest = new Guest("name", "address", 123456);//String name, String address, int phoneNumber
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 143, 999); //CreditCard(CreditCardType type, int number, int ccv)        
        Room instance = new Room(5, RoomType.DOUBLE);

        Booking booking = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        booking.checkIn();

        instance.checkout(booking);
        System.out.println("Expected output is runtime exception (Room is READY)");
        instance.checkout(booking); // calling already checkout method again to get runtime exception        
    }

    /**
     * Test of checkout method, of class Room.
     */
    @Test
    public void testCheckoutTestBookingSize() {
        System.out.println("Test the List<Booking> bookings size after checkout");
        Guest guest = new Guest("name", "address", 123456);//String name, String address, int phoneNumber
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 143, 999); //CreditCard(CreditCardType type, int number, int ccv)        
        Room instance = new Room(5, RoomType.DOUBLE);

        int bookingListSizeAtFirst = instance.bookings.size();
        System.out.println("Initial Booking Size = " + bookingListSizeAtFirst);

        Booking booking = instance.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        int bookingListSizeAfterBook = instance.bookings.size();
        System.out.println("Size after Booking done = " + bookingListSizeAfterBook);

        booking.checkIn();

        instance.checkout(booking);
        int bookingListSizeAfterCheckOut = instance.bookings.size();
        System.out.println("Size after checkout done = " + bookingListSizeAfterCheckOut);
        assertEquals(bookingListSizeAtFirst + 1, bookingListSizeAfterBook);
        assertEquals(bookingListSizeAfterBook - 1, bookingListSizeAfterCheckOut);
    }

}
