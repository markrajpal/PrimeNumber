package prime;

import org.apache.log4j.Logger;
import utilities.Helper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Mark Rajpal on 2019-06-01.
 * Ideally this class will function as the hub in order to calculate really large prime numbers
 */
public class Prime {

    private static BigInteger concurrentThreads = BigInteger.TEN;
    private BigInteger latestPotentialPrimeNumber = BigInteger.ZERO;
    private static PrimeRunnable primeRunnableEvaluation = new PrimeRunnable();

    final static private Logger logger = Logger.getLogger(Prime.class);

    public BigInteger findSmallestWithNZeroes(int numberOfZeroes) {
        BigInteger smallestNumber = Helper.smallestNumber(numberOfZeroes);
        BigInteger threadCounter = BigInteger.ZERO;

        if (smallestNumber.compareTo(concurrentThreads) < 0) {
            concurrentThreads = smallestNumber;
        }

        primeRunnableEvaluation.setSmallestPrimeFound(BigInteger.ZERO);
        primeRunnableEvaluation.threadsCompleted = BigInteger.ZERO;
        primeRunnableEvaluation.potentialPrimeNumber = BigInteger.ZERO;

        while (true) {

            if (primeRunnableEvaluation.smallestPrimeFound.compareTo(BigInteger.ZERO) > 0) {
                ArrayList<BigInteger> temporaryListToSort = new ArrayList<BigInteger>(primeRunnableEvaluation.potentialPrimeNumberTestCompleted);

                //TODO the warning indicates that temporaryListToSort is always null, DOES THIS CAUSE AN ISSUE?

                //if (temporaryListToSort == null) {
                //    continue;
                //}

                while (temporaryListToSort.remove(null)) {
                    logger.debug("temporaryListToSort has a null element");
                }

                logger.info("size:" + temporaryListToSort.size());
                Collections.sort(temporaryListToSort);

                Iterator<BigInteger> i = temporaryListToSort.iterator();

                BigInteger counter = smallestNumber.add(BigInteger.ONE).add(threadCounter).subtract(concurrentThreads);
                boolean smallestPrimeFoundValidated = false;

                while (i.hasNext() && !smallestPrimeFoundValidated) {
                    BigInteger currentItem = i.next();
                    if (counter.compareTo(currentItem) != 0) {
                        counter = currentItem;
                        //break;
                    }
                    if (counter.compareTo(primeRunnableEvaluation.smallestPrimeFound) == 0) {
                        smallestPrimeFoundValidated = true;
                    } else {
                        counter = counter.add(BigInteger.ONE);
                    }
                }
                if (smallestPrimeFoundValidated) {
                    logger.info("smallest number is: " + primeRunnableEvaluation.smallestPrimeFound);
                }
                return primeRunnableEvaluation.smallestPrimeFound;

            } else if (primeRunnableEvaluation.threadsCompleted.compareTo(concurrentThreads) == 0 || threadCounter.compareTo(BigInteger.ZERO) == 0) {
                logger.info("currentPotentialPrime " + latestPotentialPrimeNumber);
                threadCounter = initiateThreads(threadCounter, smallestNumber);
            }
            //not sure why this is needed

            /*
            if (smallestNumber.compareTo(unitTestThreshhold) > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            */

        }
    }

    public BigInteger initiateThreads(BigInteger threadCounter, BigInteger smallestNumber) {
        primeRunnableEvaluation.potentialPrimeNumberTestCompleted.clear();
        boolean firstPass = true;
        for (BigInteger i = threadCounter; i.compareTo(concurrentThreads.add(threadCounter)) < 0; i = i.add(BigInteger.ONE)) {
            PrimeRunnable primeRunnable = new PrimeRunnable();
            if (firstPass) {
                primeRunnableEvaluation.threadInt = 0;
                primeRunnableEvaluation.threadsCompleted = BigInteger.ZERO;
                firstPass = false;
            }

            primeRunnable.potentialPrimeNumber = smallestNumber.add(i).add(BigInteger.ONE);
            primeRunnable.start();

            if (i.add(BigInteger.ONE).compareTo(concurrentThreads.add(threadCounter)) == 0) {
                latestPotentialPrimeNumber = smallestNumber.add(i).add(BigInteger.ONE);
            }
        }
        return threadCounter.add(concurrentThreads);
    }

}
