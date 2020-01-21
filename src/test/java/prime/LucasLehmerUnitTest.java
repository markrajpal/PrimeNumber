package prime;

import junit.framework.TestCase;

public class LucasLehmerUnitTest extends TestCase {

    public void testIsSevenPrime() {
        int potentialPrimeNumber = 7;
        assertTrue(LucasLehmer.isPrime(potentialPrimeNumber));
    }

    public void testIsFiftyPrime() {
        int potentialPrimeNumber = 50;
        assertFalse(LucasLehmer.isPrime(potentialPrimeNumber));
    }

    public void testIsSixtyOnePrime() {
        //61 is actually Prime but the Lucas Lehmer test cannot determine that
        int potentialPrimeNumber = 61;
        assertFalse(LucasLehmer.isPrime(potentialPrimeNumber));
    }
}
