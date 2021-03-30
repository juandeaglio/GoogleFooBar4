import java.math.BigInteger;
import java.util.HashMap;

public class FuelController
{
    //BigInteger MAX_INT_VALUE = (2 ^ 32) ^ Integer.MAX_VALUE;
    HashMap<String, Integer> dict = new HashMap<String, Integer>();
    BigInteger pelletStart;
    public int Optimize(String pelletStart)
    {

        int steps = 0;
        if(pelletStart.length() == 1 && Integer.parseInt(pelletStart) == 1)
            return steps;
        else if(dict.containsKey(pelletStart))
        {
            return dict.get(pelletStart);
        }
        else
        {
            String lastDigit = pelletStart.substring(pelletStart.length()-1);
            if(Integer.parseInt(lastDigit) % 2 == 0)
            {
                while(Integer.parseInt(lastDigit) % 2 == 0)
                {
                    pelletStart = LongDivisionBy2(pelletStart);
                    lastDigit = pelletStart.substring(pelletStart.length()-1);
                    steps++;
                }
                int afterSteps = Optimize(pelletStart); //subject to change
                dict.put(pelletStart, afterSteps);
                return steps + afterSteps;
            }
            else
            {
                String leftOptimizationArg;
                String rightOptimizationArg;
                int leftSteps;
                int rightSteps;
                String numberWithoutLastDigit;
                if(pelletStart.length() > 1)
                {
                    numberWithoutLastDigit = pelletStart.substring(0, pelletStart.length() - 1);

                }
                else
                {
                    numberWithoutLastDigit = "";
                }
                leftOptimizationArg = numberWithoutLastDigit + (Integer.parseInt(lastDigit) - 1);
                leftSteps = Optimize(leftOptimizationArg);

                rightOptimizationArg = numberWithoutLastDigit + (Integer.parseInt(lastDigit) + 1);
                rightSteps = Optimize(rightOptimizationArg);
                int totalSteps = Math.min(leftSteps, rightSteps);
                if(totalSteps+1 > 2)
                {
                    if(leftSteps == totalSteps)
                    {
                        dict.put(leftOptimizationArg, totalSteps);
                    }
                    else
                    {
                        dict.put(rightOptimizationArg, totalSteps);
                    }
                }
                return 1 + totalSteps;
            }
        }
    }
    public String LongDivisionBy2(String number)
    {
        String numberToDivide = number;
        StringBuilder quotient = new StringBuilder();
        int letterCount = 1;
        boolean forceDivide = false;
        while(numberToDivide.length() > 0)
        {
            if(numberToDivide.compareTo("44") == 0)
            {
                boolean yes = true;
            }
            if(numberToDivide.length() < letterCount)
            {
                boolean yes = true;
            }
            BigInteger subDivisible = new BigInteger(numberToDivide.substring(0,letterCount));
            if(forceDivide)
            {
                numberToDivide = longDivisionUsingSubDivisible(numberToDivide, quotient, letterCount, subDivisible);
                letterCount = 1;
            }
            else if(letterCount == 1 && subDivisible.compareTo(BigInteger.ZERO) == 0)
            {
                quotient.append(0);
                numberToDivide = numberToDivide.substring(letterCount);
            }
            else if(subDivisible.getLowestSetBit() != 0)
            {
                longDivisionUsingSubDivisible(numberToDivide, quotient, letterCount, subDivisible);
                numberToDivide = numberToDivide.substring(letterCount);
                letterCount = 1;
            }
            else
            {
                if (Math.pow(10, letterCount - 1) < Long.MAX_VALUE)
                    letterCount++;
                //else
                   // forceDivide = true;
            }
        }
        return quotient.toString();
    }

    private String longDivisionUsingSubDivisible(String numberToDivide, StringBuilder quotient, int letterCount, BigInteger subDivisible)
    {
        BigInteger subQuotient = subDivisible.divide(BigInteger.valueOf(2));
        quotient.append(subQuotient);
        numberToDivide = subDivisible.subtract(subQuotient.multiply(BigInteger.valueOf(2))).toString() + numberToDivide.substring(letterCount);
        return numberToDivide;
    }
}
