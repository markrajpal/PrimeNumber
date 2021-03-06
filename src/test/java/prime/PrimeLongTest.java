package prime;

import org.junit.jupiter.api.RepeatedTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by mark on 16-04-30.
 */
public class PrimeLongTest  {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

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

}
