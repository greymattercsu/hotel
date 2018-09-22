package test;

import org.junit.runners.model.FrameworkMethod;

import org.junit.Rule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import hotel.entities.*;
import hotel.booking.BookingCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BookingCTLTest {

    public BookingCTLTest() {
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
        public void starting(FrameworkMethod method) {
            System.out.print("[Starting]: " + method.getName());
        }

        public void failed(Throwable e, FrameworkMethod method) {
            System.out.println(" [Failed]\n\t " + e.getMessage());
        }

        public void succeeded(FrameworkMethod method) {
            System.out.println(" [PASSED]");
        }
    };

    @Test
    public void creditDetailsTest() {
        int creditCardNumber = 1;
        int ccv = 123;
        String guestname = "Bijan Dhakal";
        String guestAddress = "Some address";
        int guestPhone = 123456789;
        int occupantNumber = 1;
        CreditCardType type = CreditCardType.MASTERCARD;
        RoomType roomType = RoomType.SINGLE;
        Date arrivalDate = new Date(2018, 12, 12);
        int stayLength = 1;
        double cost = roomType.calculateCost(arrivalDate, stayLength);

        CreditCard creditCard = new CreditCard(type, creditCardNumber, ccv);
        Room room = new Room(1, roomType);
        Guest guest = new Guest(guestname, guestAddress, guestPhone);
        Hotel hotel = new Hotel();
        hotel.addRoom(roomType, 1);
        Booking booking = new Booking(guest, room, arrivalDate, stayLength, occupantNumber, creditCard);

        BookingCTL bookingCTL = new BookingCTL(hotel);
        bookingCTL.phoneNumberEntered(guestPhone);
        bookingCTL.guestDetailsEntered(guestname, guestAddress);
        bookingCTL.roomTypeAndOccupantsEntered(roomType, occupantNumber);
        bookingCTL.bookingTimesEntered(arrivalDate, stayLength);
        bookingCTL.creditDetailsEntered(type, creditCardNumber, ccv);

        assertEquals("COMPLETED", String.valueOf(bookingCTL.getState()));

    }

    @Test(expected = RuntimeException.class)
    public void creditDetailsException() {
        int creditCardNumber = 1;
        int ccv = 123;
        String guestname = "Bijan Dhakal";
        String guestAddress = "Some address";
        int guestPhone = 123456789;
        int occupantNumber = 1;
        CreditCardType type = CreditCardType.MASTERCARD;
        RoomType roomType = RoomType.SINGLE;
        Date arrivalDate = new Date(2018, 12, 12);
        int stayLength = 1;
        double cost = roomType.calculateCost(arrivalDate, stayLength);

        CreditCard creditCard = new CreditCard(type, creditCardNumber, ccv);
        Room room = new Room(1, roomType);
        Guest guest = new Guest(guestname, guestAddress, guestPhone);
        Hotel hotel = new Hotel();
        hotel.addRoom(roomType, 1);
        Booking booking = new Booking(guest, room, arrivalDate, stayLength, occupantNumber, creditCard);

        BookingCTL bookingCTL = new BookingCTL(hotel);
        bookingCTL.creditDetailsEntered(type, creditCardNumber, ccv);

        assertEquals("COMPLETED", String.valueOf(bookingCTL.getState()));

    }

}