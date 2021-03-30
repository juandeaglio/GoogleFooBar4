import java.math.BigInteger;
public class FuelController
{
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

        if(new BigInteger(pelletStart).compareTo(BigInteger.ONE) == 0)
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
                BigInteger strToInt = new BigInteger(pelletStart);
                strToInt = strToInt.add(BigInteger.ONE);
                optimizationArg = strToInt.toString();
                totalSteps = Optimize(optimizationArg);
            }
            else
            {
                BigInteger strToInt = new BigInteger(pelletStart);
                strToInt = strToInt.subtract(BigInteger.ONE);
                optimizationArg = strToInt.toString();
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
