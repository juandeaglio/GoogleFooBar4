import java.math.BigInteger;
public class FuelController
{

    public int Optimize(String pelletStart)
    {
        int steps = 0;
        String binaryBig = new BigInteger(pelletStart).toString(2);
        if(binaryBig.length()>=4)
        {
            binaryBig = binaryBig.substring(binaryBig.length()-3);
        }
        if(new BigInteger(pelletStart).compareTo(BigInteger.ONE) == 0)
            return steps;
        else if(binaryBig.charAt(binaryBig.length()-1) == '0')
        {
            int lastDigit = Character.digit(pelletStart.charAt(pelletStart.length()-1),10);
            if (lastDigit % 2 == 0)
            {
                while (lastDigit % 2 == 0)
                {
                    pelletStart = LongDivisionBy2(pelletStart);
                    lastDigit = Character.digit(pelletStart.charAt(pelletStart.length()-1),10);
                    steps++;
                }
            }
            return steps + Optimize(pelletStart);
        }
        else
        {
            String optimizationArg;
            BigInteger strToInt = new BigInteger(pelletStart);
            steps++;
            if(Integer.parseInt(binaryBig,2) == 7 || strToInt.compareTo(BigInteger.valueOf(3)) != 0 && (Integer.parseInt(binaryBig,2) %3 == 0 ))
            {
                strToInt = strToInt.add(BigInteger.ONE);
                optimizationArg = strToInt.toString();
            }
            else
            {
                strToInt = strToInt.subtract(BigInteger.ONE);
                optimizationArg = strToInt.toString();
            }
            return Optimize(optimizationArg) + steps;
        }
    }
    public String LongDivisionBy2(String number)
    {
        StringBuilder quotient = new StringBuilder();
        BigInteger quotientBigInt = new BigInteger(number);
        quotient = new StringBuilder();
        quotientBigInt = quotientBigInt.shiftRight(1);
        quotient.append(quotientBigInt);
        return quotient.toString();
    }
}
