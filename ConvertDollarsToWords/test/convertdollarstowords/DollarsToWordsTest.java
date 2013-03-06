/*
 * This class was created as a coding example by Jay Silverthorn.
 */

package convertdollarstowords;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jay Silverthorn
 */
public class DollarsToWordsTest {

    public DollarsToWordsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsAsDouble() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords(2523.04);
        String expResult = "Two thousand five hundred twenty-three and 04/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);  
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsAsString() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("2523.04");
        String expResult = "Two thousand five hundred twenty-three and 04/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

     /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsBillion() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("1233444253.04");
        String expResult = "One billion two hundred thirty-three million four hundred forty-four thousand two hundred fifty-three and 04/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsBillionMilTeens() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("1018000000.05");
        String expResult = "One billion eighteen million and 05/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsMillions() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("5000000.05");
        String expResult = "Five million and 05/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsThousands() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("428030.16");
        String expResult = "Four hundred twenty-eight thousand thirty and 16/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsHundreds() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("46.00");
        String expResult = "Forty-six and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsEmpty() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsNull() {
        System.out.println("getWords");
        String input=null;
        DollarsToWords instance = new DollarsToWords(input);
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsJustDecimal() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords(".");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsZero() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("0");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsZeroDot() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("0.");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsDotZero() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords(".0");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsOverBillion() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("2123456789123");
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsOverBillionDecimal() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords(2e24);
        String expResult = "Zero and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class DollarsToWords.
     */
    @Test
    public void testGetWordsNoFraction() {
        System.out.println("getWords");
        DollarsToWords instance = new DollarsToWords("458");
        String expResult = "Four hundred fifty-eight and 00/100 dollars";
        String result = instance.getWords();
        assertEquals(expResult, result);
    }


}