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

import hotel.entities.*;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BookingJunitTest {
    
    private RoomType roomType = RoomType.SINGLE;
    private Guest guest = new Guest("Bijan DHakal", "some address", 123456789);
    private Room room = new Room(1,roomType);
    private CreditCard card = new CreditCard(CreditCardType.MASTERCARD, 123456789, 236);
    private Booking booking = new Booking(guest,room, new Date(2018,12,12),6,1, card);
    private List<ServiceCharge>charges = new ArrayList<>();

    public BookingJunitTest() {
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
        public void failed(Throwable e, FrameworkMethod metho){
            System.out.println(" [Failed]\n\t " + e.getMessage());
        }
        public void succeeded(FrameworkMethod description) { 
            System.out.println(" [PASSED]");
        }
    };
    
    
    @Test
    public void checkInTest(){
         booking.checkIn();
         assertEquals(true, booking.isCheckedIn());
    }
    @Test(expected = RuntimeException.class)
    public void checkInTestException(){
         booking.checkIn();
         booking.checkIn();
    }
    
    @Test
    public void addServiceChargeTest(){
        
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        int cost = 100;
        ServiceCharge serviceCharge = new ServiceCharge(serviceType, cost);
		charges.add(serviceCharge);
        
        booking.checkIn();
        booking.addServiceCharge(serviceType, cost);
        assertEquals(charges, booking.getCharges());
    }
    
    @Test(expected = RuntimeException.class)
    public void addServiceChargeTestException(){
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        int cost = 100;
        ServiceCharge serviceCharge = new ServiceCharge(serviceType, cost);
        charges.add(serviceCharge);
        charges = Collections.unmodifiableList(charges);

        booking.addServiceCharge(serviceType, cost);
        assertEquals(charges, booking.getCharges());
        
    }
    
    @Test(expected = RuntimeException.class)
    public void checkoutTestException(){
        booking.checkOut();
    }   
    @Test
    public void checkoutTest(){
        booking.checkIn();
        booking.checkOut();
        assertEquals(true, booking.isCheckedOut());
    }
    
}