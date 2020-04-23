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

    @RepeatedTest(1)
    public void testRobustness() {

        for (int i = 0; i < 10000; i++) {
            PrimeUnitTest pUnitTest = new PrimeUnitTest();
            pUnitTest.testFindSmallestWithTenZeroes();
            logger.info("iteration completed:  " + i);
        }
    }

    @RepeatedTest(1)
    public void testRobustness2() {

        for (int i = 0; i < 10000; i++) {
            PrimeUnitTest pUnitTest = new PrimeUnitTest();
            pUnitTest.testInitiateThreads();
        }
    }
}
