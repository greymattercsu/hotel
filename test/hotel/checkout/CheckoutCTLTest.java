/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkout;

import hotel.credit.CreditAuthorizer;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Hotel;
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
public class CheckoutCTLTest {
    
    public CheckoutCTLTest() {
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
     * Test of creditDetailsEntered method, of class CheckoutCTL.
     */
    @Test
    public void testCreditDetailsEntered() {
        System.out.println("creditDetailsEntered");
        
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 1234567, 222);
boolean approved = new CreditAuthorizer().authorize(creditCard, 123);
        CreditCardType type = CreditCardType.VISA;
        assertEquals(approved, false);
        //int number = 1234567;
        //int ccv = 222;
        Hotel hotel = new Hotel();
        //        CheckoutCTL instance = new CheckoutCTL(hotel);
//        instance.creditDetailsEntered(type, 1234567, 222);
//        instance.chargesAccepted(true);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    
    
}
