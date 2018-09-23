
/*
 * @author:Saurav Pradhan
 * Hotel Entities
 * Method to be working on: Book(), checkin(), addServiceCharge(), checkout()
 */
import hotel.entities;
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

import java.util.Date;
import java.util.List;


public class HotelTest {

    // creating dummy datas for testing
    Room room = new Room(111, RoomType.DOUBLE);

    Guest guest = new Guest("Saurav", "some address", 231245687);
    Date arrivalDate = new Date();

    int stayLength = 2;
    int occupantNumber = 2;
    CreditCard creditCard = new CreditCard(CreditCardType.MASTERCARD, 123456789, 236);
    Hotel instance = new Hotel();

    ServiceType serviceType = ServiceType.ROOM_SERVICE;
    long result = instance.book(room, guest, arrivalDate, stayLength, occupantNumber, creditCard);;
    Booking booking = new Booking(guest, room, arrivalDate, stayLength, occupantNumber, creditCard);
    static Booking bookingValue;
    Booking booked = new Booking(guest, room, arrivalDate, stayLength, occupantNumber, creditCard);;
    double cost = 20.0;
    ServiceCharge serviceCharge = new ServiceCharge(serviceType, cost);

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

    @Rule
    public MethodRule watchman = new TestWatchman() {
        @Override
        public void starting(FrameworkMethod method) {
            System.out.print("[Starting]: " + method.getName());
        }

        @Override
        public void failed(Throwable e, FrameworkMethod method) {
            System.out.println(" [Failed]\n\t " + e);
        }

        @Override
        public void succeeded(FrameworkMethod description) {
            System.out.println(" [PASSED]");
        }
    };

    /**
     * Test of book method, of class Hotel.
     */
    @Test
    public void testBook() {
        System.out.println("book");

        long expResult = 1782018111;
        assertEquals(expResult, result);

        assertEquals(expResult, result);
    }

    /**
     * Test of checkin method, of class Hotel.
     */
    @Test
    public void testCheckin() {
        System.out.println("Testing of checkin method");

        // booked method will return the booking by getActiveBookingByRoomId() method
        Booking booked = instance.findBookingByConfirmationNumber(confirmationNumber);

        // the confirmationNumber is formatted as ddMMYYrrr which is the current date
        // today.
        long confirmationNumber = result;

        // the confirmation is passed so that the hotel can be checked in.
        instance.checkin(confirmationNumber);

        // this gives whether the state is checkin or not. It returns true .
        System.out.println("Room is checkin: " + booked.isCheckedIn());

        assertEquals(true, booked.isCheckedIn());
    }

    /**
     * Test of addServiceCharge method, of class Hotel.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("Testing addServiceCharge method");
        int roomId = 0;
        ServiceType serviceType = null;
        double cost = 20.0;

        // creating a arraylist of activeBooking to test which is checkin. Since we dont
        // have arraylist.
        instance.activeBookingsByRoomId.put(room.getId(), booking);

        // Storing the result from method to booking variable
        Booking activeBooking = instance.findActiveBookingByRoomId(room.getId());

        // testing out the method
        instance.addServiceCharge(roomId, serviceType, cost);

        System.out.println("New: " + activeBooking.getCharges());

    }

    /**
     * Test of checkout method, of class Hotel.
     */
    @Test
    public void testCheckout() {
        System.out.println("Testing of checkout");

        // creating a arraylist of activeBooking to test which is checkin. Since we dont
        // have arraylist.
        instance.activeBookingsByRoomId.put(room.getId(), booking);

        // checking out the result
        // System.out.println(instance.activeBookingsByRoomId.get(room.getId()));

        // Storing the result from method to booking variable
        Booking bookinOut = instance.findActiveBookingByRoomId(room.getId());

        instance.checkout(roomId);

        // returns the state of the booking variable. Here the state is CHECKED_OUT.
        bookinOut.getState();
        bookinOut.isCheckedOut();
        System.out.println("Room is checkedOut:" + bookinOut.isCheckedOut());

        // checking out the state of the booking
        // System.out.println("Room is:" + bookinOut.getState());
        assertEquals(true, bookinOut.isCheckedOut());
    }

    //checking the null exception part of the test checkin
    @Test(expected = RuntimeException.class)
    public void testCheckin1() {
        System.out.println("checkinTest null point exception test");
        
        //confirmation number that does not exists
        long confirmationNumber = 222;

        booked = instance.findBookingByConfirmationNumber(confirmationNumber);

        instance.checkin(confirmationNumber);
       
        System.out.println("Room is checkin:" + booked.isCheckedIn());
        assertEquals(true, booked.isCheckedIn());

        
    }

    //testing the null point exception for the addServiceCharge of the code
    @Test(expected = RuntimeException.class)
    public void testAddServiceCharge1() {
        System.out.println("addServiceCharge testing of null");
        
        //active booking will be null since it does not get the room id
        Booking activeBooking = instance.findActiveBookingByRoomId(room.getId());
     
        System.out.println("Booking: " + activeBooking);
        
        instance.addServiceCharge(room.getId(), serviceType, cost);
        
        System.out.println("New: " + activeBooking.getCharges());
        
//        assertEquals("[20.0 added to S,Room Service]", activeBooking.getCharges());
    }

    //testing the null exception for the test checkout
    @Test(expected = RuntimeException.class)
    public void testCheckout1() {
        System.out.println("checkout for null");
        
        

        Booking bookinOut = instance.findActiveBookingByRoomId(room.getId());
        instance.checkout(room.getId());
        
        System.out.println("Room is checkedOut:" + bookinOut.isCheckedOut());
    
        assertEquals(true, bookinOut.isCheckedOut());
    }


}
