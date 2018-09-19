package hotel.service;

import hotel.checkin.CheckinCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecordServiceCTLTest {

    public RecordServiceCTLTest() {
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
     * Test of serviceDetailsEntered method, of class RecordServiceCTL.
     */
    @Test
    public void testServiceDetailsEnteredException() {
        System.out.println("Test Runtime Exception  if state is not SERVICE.");
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 20.0;
        Hotel hotel = new Hotel();
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        System.out.println("Present State: " + instance.getState());
        instance.serviceDetailsEntered(serviceType, cost);
    }

    @Test
    public void testServiceDetailsEnteredState() {
        System.out.println("serviceDetailsEntered");
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 20.0;
        Hotel hotel = new Hotel();
        RecordServiceCTL instance = new RecordServiceCTL(hotel);

        /*------------ for booking -------------*/
        Guest guest = new Guest("name1", "address1", 1123456);
        Date arrivalDate = new Date();
        int stayLength = 2;
        int numberOfOccupants = 2;
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 1, 2);
        Room room = new Room(1, RoomType.SINGLE);
        Booking booking = room.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
        //booking.checkIn();
        hotel.book(room, guest, arrivalDate, 2, 1, creditCard);

        long confNumber = booking.getConfirmationNumber();

//        /*------------ for booking end -------------*/
//              System.out.print("abc");
//
        CheckinCTL checkin = new CheckinCTL(hotel);
//        
        checkin.confirmationNumberEntered(confNumber);
        checkin.checkInConfirmed(true);
        instance.roomNumberEntered(room.getId());

//
        System.out.println("State before method call: " + instance.getState());
        instance.serviceDetailsEntered(serviceType, cost);
        System.out.println("serviceDetailsEntered(serviceType, cost) method call success");
        System.out.println("State after method call: " + instance.getState());
        assertEquals("COMPLETED", instance.getState());
    }
}
