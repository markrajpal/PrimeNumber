package utilities;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by mark on 2019-07-03.
 */
public class Helper {

    public static Double doubleAddition(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static BigInteger smallestNumber(int numberOfZeroes) {
        BigInteger returnNumber= BigDecimal.valueOf(Math.pow(10,numberOfZeroes)).toBigInteger();
        return returnNumber;
    }

    public static BigInteger BigIntegerAddition(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.add(secondNumber);
    }
}
