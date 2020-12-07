package prime;

import org.junit.jupiter.api.RepeatedTest;

/**
 * Created by mark on 16-04-30.
 */
public class RobustnessTest {

    Prime prime = new Prime();
    PrimeRunnable primeRunnable = new PrimeRunnable();

    @RepeatedTest(100)
    public void testRobustness() {

        PrimeUnitTest pUnitTest = new PrimeUnitTest();
        pUnitTest.testFindSmallestWithNineZeroes();
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @RepeatedTest(10000)
    public void testRobustness2() {
        
        PrimeUnitTest pUnitTest = new PrimeUnitTest();
        pUnitTest.testInitiateThreads();
    }
}
