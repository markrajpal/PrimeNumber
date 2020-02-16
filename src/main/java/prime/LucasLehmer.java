package prime;

// Java program to check for primality using
// Lucas-Lehmer series.

import java.util.HashMap;
import java.util.Iterator;

public class LucasLehmer {
// Function to check whether (2^p - 1)
// is prime or not.

    static HashMap<Integer, Integer> LucasLehmerCandidates = new HashMap<Integer, Integer>();

    static boolean isPrime(int p) {

// generate the number
        double checkNumber = Math.pow(2, p) - 1;

// First number of the series
        double nextval = 4 % checkNumber;

// Generate the rest (p-2) terms
// of the series.
        for (int i = 1; i < p - 1; i++)
            nextval = (nextval * nextval - 2) % checkNumber;

// now if the (p-1)th term is
// 0 return true else false.
        return (nextval == 0);
    }

    static boolean isExpressedAsMultiplierOfTwoMinusOne(int p) { //e.g. 2^^n - 1
        // Getting an iterator
        Iterator hmIterator = LucasLehmerCandidates.entrySet().iterator();

        boolean foundLucasLehmerCandidate = false;
        while (hmIterator.hasNext()) {
            HashMap.Entry mapElement = (HashMap.Entry)hmIterator.next();
            if (mapElement.getValue() == (Integer)p) {
                return true;
            }
        }

        return foundLucasLehmerCandidate;
    }
}
