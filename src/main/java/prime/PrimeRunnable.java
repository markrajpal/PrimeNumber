package prime;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by mark on 2019-06-02.
 */
public class PrimeRunnable extends Thread {

    public static BigInteger smallestPrimeFound = BigInteger.ZERO;
    public static BigInteger threadsCompleted = BigInteger.ZERO;
    public static int threadInt = 0;
    public BigInteger potentialPrimeNumber;
    public static final ArrayList<BigInteger> potentialPrimeNumberTestCompleted = new ArrayList<BigInteger>();

    final static private Logger logger = Logger.getLogger(PrimeRunnable.class);

    public void run() {
        if (isPrime(potentialPrimeNumber)) {
            setSmallestPrimeFound(potentialPrimeNumber);
        }

        threadInt = threadInt + 1;
        potentialPrimeNumberTestCompleted.add(potentialPrimeNumber);
        //logger.info("num added:" + potentialPrimeNumber);
        if (threadInt == 10) {
            threadsCompleted = BigInteger.TEN;
        }
    }

    public void setSmallestPrimeFound(BigInteger potentialPrimeNumberToSet) {
        if (smallestPrimeFound == BigInteger.ZERO || potentialPrimeNumberToSet.compareTo(smallestPrimeFound) < 0) {
            smallestPrimeFound = potentialPrimeNumberToSet;
        }
    }

    public boolean isPrime(BigInteger potentialPrimeNumber) {

        BigInteger divisionResult;

        //check if n is a multiple of 2
        divisionResult = potentialPrimeNumber.mod(new BigInteger("2"));
        if (divisionResult.compareTo(BigInteger.ZERO) == 0) return false;

        //check if n is a multiple of 5
        divisionResult = potentialPrimeNumber.mod(new BigInteger("5"));
        if (divisionResult.compareTo(BigInteger.ZERO) == 0) return false;

        //check if the sum of n is a multiple of 3
        if (sumOfDigits(potentialPrimeNumber)%3==0) return false;

        //if not, then just check the odds
        for(BigInteger i=new BigInteger("3");i.multiply(i).compareTo(potentialPrimeNumber)<=0; i = i.add(new BigInteger("2"))) {
            if (i.compareTo(BigInteger.ONE) < 0) {
                break;
            }
            divisionResult = potentialPrimeNumber.mod(i);
            if (divisionResult.compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;
    }

    public double sumOfDigits(BigInteger numberToBeSummed) {
        String integerString = String.valueOf(numberToBeSummed);
        //int indexOfDecimal = doubleAsString.indexOf(".");
        //String integerString = doubleAsString.substring(0, indexOfDecimal);

        double sum = 0d;
        for (int i = 0; i < integerString.length(); i++) {
            char a = integerString.charAt(i);
            if (Character.isDigit(a)) {
                int b = Integer.parseInt(String.valueOf(a));
                sum = sum + b;
            }
        }
        return sum;
    }

}
