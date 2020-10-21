package prime;

import org.junit.jupiter.api.RepeatedTest;
import utilities.Helper;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mark on 16-04-30.
 */

public class PrimeUnitTest {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

    @RepeatedTest(1)
    public void testIsFiftyPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("50");
        assertFalse(primeRunnable.isPrime(potentialPrimeNumber));
    }

    @RepeatedTest(1)
    public void testIsSevenPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("7");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    @RepeatedTest(1)
    public void testIsSixtyOnePrime() {

        BigInteger potentialPrimeNumber = new BigInteger("61");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    @RepeatedTest(1)
    public void testSmallestWithTwoZeroes() {
        int numberOfZeroes = 2;
        assertEquals(new BigInteger("100"), Helper.smallestNumber(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithTwoZeroes() {
        int numberOfZeroes = 2;
        assertEquals(new BigInteger("101"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithThreeZeroes() {
        int numberOfZeroes = 3;
        assertEquals(new BigInteger("1009"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithFourZeroes() {

        int numberOfZeroes = 4;
        assertEquals(new BigInteger("10007"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testSumOfDigitsWithEleven() {

        BigInteger numberToBeSummed = new BigInteger("11");
        assertEquals(2d, primeRunnable.sumOfDigits(numberToBeSummed));
    }

    @RepeatedTest(1)
    public void testSumOfDigitsWithFiveNines() {

        BigInteger numberToBeSummed = new BigInteger("99999");
        assertEquals(45d, primeRunnable.sumOfDigits(numberToBeSummed));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithNineZeroes() {

        int numberOfZeroes = 9;
        assertEquals(new BigInteger("1000000007"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testSimpleDoubleAddition() {
        double firstNumber = 5d;
        double secondNumber = 4d;
        assertEquals(9d, Helper.doubleAddition(firstNumber, secondNumber));
    }

    @RepeatedTest(1)
    public void testComplexDoubleAddition() {
        Double firstNumber = 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
        Double secondNumber = 1d;

        //This is why we can't use doubles
        //Is this a Java Bug???
        assertEquals(10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001d, Helper.doubleAddition(firstNumber, secondNumber));
        assertEquals(10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d, Helper.doubleAddition(firstNumber, secondNumber));
    }

    @RepeatedTest(1)
    public void testBigIntegerAdditionA() {
        BigInteger firstNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        BigInteger secondNumber = new BigInteger("1");
        assertEquals(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), Helper.bigIntegerAddition(firstNumber, secondNumber));
    }

    @RepeatedTest(1)
    public void testBigIntegerAdditionB() {
        BigInteger firstNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        BigInteger secondNumber = new BigInteger("1");
        assertNotEquals(new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), Helper.bigIntegerAddition(firstNumber, secondNumber));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithTenZeroes() {
        int numberOfZeroes = 10;
        assertEquals(new BigInteger("10000000019"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testFindSmallestWithElevenZeroes() {
        int numberOfZeroes = 11;
        assertEquals(new BigInteger("100000000003"), prime.findSmallestWithNZeroes(numberOfZeroes));
    }

    @RepeatedTest(1)
    public void testIsPrime() {

        BigInteger potentialPrimeNumber = new BigInteger("10000000019");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    @RepeatedTest(1)
    public void testMutation() {
        if (true || false) {
            assertTrue(true);
        }
    }

    @RepeatedTest(1)
    public void testInitiateThreads() {
        BigInteger numberOfThreads = prime.initiateThreads(BigInteger.ZERO, new BigInteger("1000"));
        assertEquals(numberOfThreads, new BigInteger(("10")));
    }

    @RepeatedTest(1)
    public void testIsSmallestPrimeFoundA() {
        ArrayList<BigInteger> temporaryListToSort = new ArrayList<BigInteger>();
        temporaryListToSort.add(new BigInteger("100000000002"));
        temporaryListToSort.add(new BigInteger("100000000001"));

        BigInteger counter = new BigInteger("100000000001");
        assertFalse(prime.isSmallestPrimeFoundValidated(counter, temporaryListToSort));
    }

    @RepeatedTest(1)
    public void testIsSmallestPrimeFoundB() {
        ArrayList<BigInteger> temporaryListToSort = new ArrayList<BigInteger>();
        temporaryListToSort.add(new BigInteger("100000000003"));
        temporaryListToSort.add(new BigInteger("100000000002"));
        temporaryListToSort.add(new BigInteger("100000000001"));
        PrimeRunnable.smallestPrimeFound = new BigInteger("100000000003");

        BigInteger counter = new BigInteger("100000000001");
        assertTrue(prime.isSmallestPrimeFoundValidated(counter, temporaryListToSort));
    }

    @RepeatedTest(1)
    public void testIsSmallestPrimeFoundC() {
        ArrayList<BigInteger> temporaryListToSort = new ArrayList<BigInteger>();
        temporaryListToSort.add(new BigInteger("100000000003"));
        temporaryListToSort.add(new BigInteger("100000000001"));
        PrimeRunnable.smallestPrimeFound = new BigInteger("100000000003");

        BigInteger counter = new BigInteger("100000000001");
        assertFalse(prime.isSmallestPrimeFoundValidated(counter, temporaryListToSort));
    }

    @RepeatedTest(1)
    public void testIsSmallestPrimeFoundD() {
        ArrayList<BigInteger> temporaryListToSort = new ArrayList<BigInteger>();
        temporaryListToSort.add(new BigInteger("1000000001"));
        temporaryListToSort.add(new BigInteger("1000000002"));
        temporaryListToSort.add(new BigInteger("1000000003"));
        temporaryListToSort.add(new BigInteger("1000000004"));
        temporaryListToSort.add(new BigInteger("1000000005"));
        temporaryListToSort.add(new BigInteger("1000000006"));
        temporaryListToSort.add(new BigInteger("1000000008"));
        temporaryListToSort.add(new BigInteger("1000000010"));
        temporaryListToSort.add(new BigInteger("1000000009"));
        PrimeRunnable.smallestPrimeFound = new BigInteger("1000000009");

        BigInteger counter = new BigInteger("1000000001");
        assertFalse(prime.isSmallestPrimeFoundValidated(counter, temporaryListToSort));
    }
}
