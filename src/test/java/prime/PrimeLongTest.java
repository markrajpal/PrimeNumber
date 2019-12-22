package prime;

import junit.framework.TestCase;

import java.math.BigInteger;

/**
 * Created by mark on 16-04-30.
 */
public class PrimeLongTest extends TestCase {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

    public void testFindSmallestWithNZeroes() {
        int numberOfZeroes = 100;
        prime.findSmallestWithNZeroes(numberOfZeroes);
    }

    public void testBigNumber() {
        BigInteger potentialPrimeNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000037");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    public void testRobustness() {

        for (int i = 0; i < 10000; i++) {
            PrimeUnitTest pUnitTest = new PrimeUnitTest();
            pUnitTest.testFindSmallestWithThreeZeroes();
        }
    }

    public void testRobustness2() {

        for (int i = 0; i < 10000; i++) {
            PrimeUnitTest pUnitTest = new PrimeUnitTest();
            pUnitTest.testInitiateThreads();
        }
    }
}
