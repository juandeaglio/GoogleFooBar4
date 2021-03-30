import java.math.BigInteger;
import java.util.HashMap;

public class FuelController
{
    //BigInteger MAX_INT_VALUE = (2 ^ 32) ^ Integer.MAX_VALUE;

    static StringBuilder quotient = new StringBuilder();
    static BigInteger quotientBigInt;
    public int Optimize(String pelletStart)
    {
        int steps = 0;
        String binaryBig = new BigInteger(pelletStart).toString(2);
        if(binaryBig.length()>=3)
        {
            binaryBig = binaryBig.substring(binaryBig.length()-3);
        }

        if(new BigInteger(pelletStart).compareTo(BigInteger.ONE) == 0 && Integer.parseInt(pelletStart) == 1)
            return steps;

        else if(binaryBig.charAt(binaryBig.length()-1) == '0')
        {
            int afterSteps = 0;
            String lastDigit = pelletStart.substring(pelletStart.length() - 1);
            if (Integer.parseInt(lastDigit) % 2 == 0)
            {
                while (Integer.parseInt(lastDigit) % 2 == 0)
                {
                    quotientBigInt = new BigInteger(pelletStart);
                    LongDivisionBy2(pelletStart);
                    pelletStart = quotient.toString();
                    if (pelletStart.length() == 1)
                        lastDigit = pelletStart;
                    else
                        lastDigit = pelletStart.substring(pelletStart.length() - 1);
                    steps++;
                }
                afterSteps = Optimize(pelletStart);

            }
            return steps + afterSteps;
        }
        else
        {
            int totalSteps;
            String optimizationArg;
            String numberWithoutLastDigit;
            if(Integer.parseInt(binaryBig,2) == 7)
            {
                String lastDigit = pelletStart.substring(pelletStart.length() - 1);
                if (pelletStart.length() > 1)
                {
                    numberWithoutLastDigit = pelletStart.substring(0, pelletStart.length() - 1);
                }
                else
                {
                    numberWithoutLastDigit = "";
                }
                optimizationArg = numberWithoutLastDigit + (Integer.parseInt(lastDigit) + 1);
                totalSteps = Optimize(optimizationArg);
            }
            else
            {
                String lastDigit = pelletStart.substring(pelletStart.length() - 1);
                if (pelletStart.length() > 1) {
                    numberWithoutLastDigit = pelletStart.substring(0, pelletStart.length() - 1);
                }
                else
                {
                    numberWithoutLastDigit = "";
                }
                optimizationArg = numberWithoutLastDigit + (Integer.parseInt(lastDigit) - 1);
                totalSteps = Optimize(optimizationArg);
            }
            return 1 + totalSteps;
        }
    }

    public void LongDivisionBy2(String number)
    {
        quotient.setLength(0);
        quotientBigInt = quotientBigInt.divide(BigInteger.valueOf(2));
        quotient.append(quotientBigInt);
    }
}
