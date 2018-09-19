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
        System.out.println("Expected: credit card is approved");
        System.out.println("Result: credit card is approved");
        Hotel hotel = new Hotel();
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    @Test
    public void testCreditDetailsEntered2() {
        System.out.println("creditDetailsEntered");
        System.out.println("Expected: There is no any credit");
        System.out.println("Result: There is no any credit");
        
        CreditCard creditCard = new CreditCard(CreditCardType.VISA, 1234567, 222);
        boolean approved = new CreditAuthorizer().authorize(creditCard, 123);
        CreditCardType type = CreditCardType.VISA;
        assertEquals(approved, true);
        
        Hotel hotel = new Hotel();
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
}
