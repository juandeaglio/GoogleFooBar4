public class FuelController
{
    int MAX_INT_VALUE = 2147483647;

    public int Optimize(String pelletStart)
    {
        int steps = 0;
        if(pelletStart.length() == 1 && Integer.parseInt(pelletStart) == 1)
            return steps;
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
                return steps + Optimize(pelletStart);
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
                return 1 + Math.min(leftSteps, rightSteps);
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
            int subDivisible = Integer.parseInt(numberToDivide.substring(0,letterCount));
            if(forceDivide)
            {
                numberToDivide = longDivisionUsingSubDivisible(numberToDivide, quotient, letterCount, subDivisible);
                letterCount = 1;
            }
            else if(letterCount == 1 && subDivisible == 0)
            {
                quotient.append(0);
                numberToDivide = numberToDivide.substring(letterCount);
            }
            else if(subDivisible % 2 == 0)
            {
                longDivisionUsingSubDivisible(numberToDivide, quotient, letterCount, subDivisible);
                numberToDivide = numberToDivide.substring(letterCount);
                letterCount = 1;
            }
            else
            {
                if (Math.pow(10, letterCount - 1) < MAX_INT_VALUE)
                    letterCount++;
                else
                    forceDivide = true;
            }
        }
        return quotient.toString();
    }

    private String longDivisionUsingSubDivisible(String numberToDivide, StringBuilder quotient, int letterCount, int subDivisible)
    {
        int subQuotient = subDivisible/2;
        quotient.append(subQuotient);
        numberToDivide = (subDivisible - subQuotient*2) + numberToDivide.substring(letterCount);
        return numberToDivide;
    }
}
