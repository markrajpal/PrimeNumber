import junit.framework.TestCase;
import prime.Prime;
import prime.PrimeRunnable;

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
}
