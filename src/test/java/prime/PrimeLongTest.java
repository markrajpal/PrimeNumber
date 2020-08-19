package prime;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.RepeatedTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by mark on 16-04-30.
 */
public class PrimeLongTest  {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

    final static private Logger logger = Logger.getLogger(PrimeLongTest.class);

    @RepeatedTest(1)
    public void testFindSmallestWithNZeroes() {
        int numberOfZeroes = 100;
        prime.findSmallestWithNZeroes(numberOfZeroes);
    }

    @RepeatedTest(1)
    public void testBigNumber() {
        BigInteger potentialPrimeNumber = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000037");
        assertTrue(primeRunnable.isPrime(potentialPrimeNumber));
    }

    @RepeatedTest(10)
    public void testRobustness() {

        PrimeUnitTest pUnitTest = new PrimeUnitTest();
        pUnitTest.testFindSmallestWithNineZeroes();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RepeatedTest(10000)
    public void testRobustness2() {
        
        PrimeUnitTest pUnitTest = new PrimeUnitTest();
        pUnitTest.testInitiateThreads();
    }
}
