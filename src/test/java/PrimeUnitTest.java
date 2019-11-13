import junit.framework.TestCase;
import prime.Prime;
import prime.PrimeRunnable;
import utilities.Helper;

import java.math.BigInteger;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by mark on 16-04-30.
 */
public class PrimeUnitTest extends TestCase {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

    public void testIsFiftyPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("50");
        assertFalse(primeRunnable.isPrime(potentialPrimeNumber));
    }

    public void testIsSevenPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("7");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    public void testSmallestWithTwoZeroes() {
        int numberOfZeroes = 2;
        assertEquals(new BigInteger("100"), Helper.smallestNumber(numberOfZeroes));
    }

    public void testFindSmallestWithTwoZeroes() {
        int numberOfZeroes = 2;
        assertEquals(new BigInteger("101"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testFindSmallestWithThreeZeroes() {
        int numberOfZeroes = 3;
        assertEquals(new BigInteger("1009"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testFindSmallestWithFourZeroes() {

        int numberOfZeroes = 4;
        assertEquals(new BigInteger("10007"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testSumOfDigitsWithEleven() {

        BigInteger numberToBeSummed = new BigInteger("11");
        assertEquals(2d, primeRunnable.sumOfDigits(numberToBeSummed));
    }

    public void testSumOfDigitsWithFiveNines() {

        BigInteger numberToBeSummed = new BigInteger("99999");
        assertEquals(45d, primeRunnable.sumOfDigits(numberToBeSummed));
    }

    public void testFindSmallestWithNineZeroes() {

        int numberOfZeroes = 9;
        assertEquals(new BigInteger("1000000007"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testSimpleDoubleAddition() {
        double firstNumber = 5d;
        double secondNumber = 4d;
        assertEquals(9d, Helper.doubleAddition(firstNumber, secondNumber));
    }

    public void testComplexDoubleAddition() {
        Double firstNumber = 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
        Double secondNumber = 1d;

        //This is why we can't use doubles
        //Is this a Java Bug???
        assertEquals(10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001d, Helper.doubleAddition(firstNumber, secondNumber));
        assertEquals(10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d, Helper.doubleAddition(firstNumber, secondNumber));
    }

    public void testBigIntegerAdditionA() {
        BigInteger firstNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        BigInteger secondNumber = new BigInteger("1");
        assertEquals(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), Helper.bigIntegerAddition(firstNumber, secondNumber));
    }

    public void testBigIntegerAdditionB() {
        BigInteger firstNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        BigInteger secondNumber = new BigInteger("1");
        assertNotEquals(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), Helper.bigIntegerAddition(firstNumber, secondNumber));
    }

    public void testFindSmallestWithTenZeroes() {
        int numberOfZeroes = 10;
        assertEquals(new BigInteger("10000000019"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testFindSmallestWithElevenZeroes() {
        int numberOfZeroes = 11;
        assertEquals(new BigInteger("100000000003"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    public void testIsPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("10000000019");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    public void testMutation() {
        if (true || false) {
            assertTrue(true);
        }
    }
}
