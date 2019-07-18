package prime;

import org.apache.log4j.Logger;
import utilities.Helper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by mark on 2019-06-01.
 */
public class Prime {

    public static BigInteger concurrentThreads = BigInteger.TEN;
    public BigInteger latestPotentialPrimeNumber = BigInteger.ZERO;
    public PrimeRunnable primeRunnableEvaluation = new PrimeRunnable();
    public BigInteger unitTestThreshhold = new BigInteger("1000000000");

    final static Logger logger = Logger.getLogger(Prime.class);

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
                if (temporaryListToSort == null) {
                    continue;
                }
                Collections.sort(temporaryListToSort);
                Iterator<BigInteger> i = temporaryListToSort.iterator();

                BigInteger counter = smallestNumber.add(BigInteger.ONE).add(threadCounter).subtract(concurrentThreads);
                boolean smallestPrimeFoundValidated = false;

                while (i.hasNext() && smallestPrimeFoundValidated == false) {
                    BigInteger currentItem = i.next();
                    if (counter.compareTo(currentItem) == 0) {
                        if (counter.compareTo(primeRunnableEvaluation.smallestPrimeFound) == 0) {
                            smallestPrimeFoundValidated = true;
                        } else {
                            counter = counter.add(BigInteger.ONE);
                        }
                        continue;
                    }
                    break;
                }
                if (smallestPrimeFoundValidated) {
                    logger.info("smallest number is: " + primeRunnableEvaluation.smallestPrimeFound);
                    return primeRunnableEvaluation.smallestPrimeFound;
                }

            } else if (primeRunnableEvaluation.threadsCompleted.compareTo(concurrentThreads) == 0 || threadCounter.compareTo(BigInteger.ZERO) == 0) {
                logger.info("currentPotentialPrime " + latestPotentialPrimeNumber);
                threadCounter = initiateThreads(threadCounter, smallestNumber);
            }
            //not sure why this is needed


            if (smallestNumber.compareTo(unitTestThreshhold) > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public BigInteger initiateThreads(BigInteger threadCounter, BigInteger smallestNumber) {
        primeRunnableEvaluation.potentialPrimeNumberTestCompleted.clear();
        boolean firstPass = true;
        for (BigInteger i = threadCounter; i.compareTo(concurrentThreads.add(threadCounter)) < 0; i = i.add(BigInteger.ONE)) {
            PrimeRunnable primeRunnable = new PrimeRunnable();
            if (firstPass) {
                primeRunnable.threadsCompleted = BigInteger.ZERO;
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
