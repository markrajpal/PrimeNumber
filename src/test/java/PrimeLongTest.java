import junit.framework.TestCase;
import prime.Prime;

/**
 * Created by mark on 16-04-30.
 */
public class PrimeLongTest extends TestCase {

    Prime prime = new Prime();

    public void testFindSmallestWithNZeroes() {
        int numberOfZeroes = 100;
        prime.findSmallestWithNZeroes(numberOfZeroes);
    }
}
