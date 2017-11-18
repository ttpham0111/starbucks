


package starbucks ;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ObserverPatternTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ObserverPatternTest
{
    KeyPad keyPad;
    PinEntryMachine pinEntryMachine;
    
    /**
     * Default constructor for test class ObserverPatternTest
     */
    public ObserverPatternTest()
    {  
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        keyPad = new KeyPad();
        pinEntryMachine = new PinEntryMachine();
        keyPad.attach(pinEntryMachine);
    }


    @Test
    public void testOneKey()
    {
        keyPad.touch(1, 5);
        System.out.println( pinEntryMachine.getCurrentState() ) ;
        assertEquals(pinEntryMachine.d1(), "1");
    }

    @Test
    public void testTwoKeys()
    {
        keyPad.touch(1, 5);
        keyPad.touch(2, 5);
        assertEquals(pinEntryMachine.d1(), "1");
        assertEquals(pinEntryMachine.d2(), "2");
    }

    @Test
    public void testThreeKeys()
    {
        keyPad.touch(1, 5);
        keyPad.touch(2, 5);
        keyPad.touch(3, 5);
        assertEquals(pinEntryMachine.d1(), "1");
        assertEquals(pinEntryMachine.d2(), "2");
        assertEquals(pinEntryMachine.d3(), "3");
     }

    @Test
    public void testFourKeys()
    {
        keyPad.touch(1, 5);
        keyPad.touch(2, 5);
        keyPad.touch(3, 5);
        keyPad.touch(1, 6);
        assertEquals(pinEntryMachine.d1(), "1");
        assertEquals(pinEntryMachine.d2(), "2");
        assertEquals(pinEntryMachine.d3(), "3");
        assertEquals(pinEntryMachine.d4(), "4");
    }

   @Test
    public void testBackspace()
    {
        keyPad.touch(1, 5);
        keyPad.touch(2, 5);
        keyPad.touch(3, 5);
        keyPad.touch(1, 6);
        assertEquals(pinEntryMachine.d1(), "1");
        assertEquals(pinEntryMachine.d2(), "2");
        assertEquals(pinEntryMachine.d3(), "3");
        assertEquals(pinEntryMachine.d4(), "4");

        keyPad.touch(3, 8);
        assertEquals(pinEntryMachine.d1(), "1");
        assertEquals(pinEntryMachine.d2(), "2");
        assertEquals(pinEntryMachine.d3(), "3");
        assertEquals(pinEntryMachine.d4(), "");        
    }
    


    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
