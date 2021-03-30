import java.math.BigInteger;
import java.util.HashMap;

public class FuelController
{
    //BigInteger MAX_INT_VALUE = (2 ^ 32) ^ Integer.MAX_VALUE;
    HashMap<String, Integer> dict = new HashMap<>();
    static StringBuilder quotient = new StringBuilder();
    static BigInteger quotientBigInt;
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
                String temp = pelletStart;
                while(Integer.parseInt(lastDigit) % 2 == 0)
                {
                    quotientBigInt = new BigInteger(pelletStart);
                    LongDivisionBy2(pelletStart);
                    pelletStart = quotient.toString();
                    if(pelletStart.length() == 1)
                        lastDigit = pelletStart;
                    else
                        lastDigit = pelletStart.substring(pelletStart.length()-1);
                    steps++;
                }
                int afterSteps = Optimize(pelletStart);
                if(afterSteps > 2)
                    dict.put(temp, steps + afterSteps);
                return steps + afterSteps;
            }
            else
            {
                String leftOptimizationArg;
                String rightOptimizationArg;
                int leftSteps = Integer.MAX_VALUE;
                int rightSteps = Integer.MAX_VALUE;
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
                rightOptimizationArg = numberWithoutLastDigit + (Integer.parseInt(lastDigit) + 1);

                if(amountOf2s(leftOptimizationArg) > amountOf2s(rightOptimizationArg))
                {
                    leftSteps = Optimize(leftOptimizationArg);
                }
                else
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
    public int amountOf2s(String number)
    {
        int timesDivided = 0;
        quotientBigInt = new BigInteger(number);
        while(quotientBigInt.getLowestSetBit() != 0)
        {
            quotientBigInt = quotientBigInt.divide(BigInteger.valueOf(2));
            timesDivided++;
        }
        return timesDivided;
    }
    public void LongDivisionBy2(String number)
    {
        quotient.setLength(0);
        quotientBigInt = quotientBigInt.divide(BigInteger.valueOf(2));
        quotient.append(quotientBigInt);
    }
}
