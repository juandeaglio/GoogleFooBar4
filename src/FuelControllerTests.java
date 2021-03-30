import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuelControllerTests
{
    FuelController controller;
    public void Setup()
    {
        controller = new FuelController();
    }
    @Test
    void Given9ShouldReturn3Steps()
    {
        Setup();
        String input = "9";
        int expectedResult = 3;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given143ShouldReturn9Steps()
    {
        Setup();
        String input = "143";
        int expectedResult = 9;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given67ShouldReturn8Steps()
    {
        Setup();
        String input = "67";
        int expectedResult = 8;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given31ShouldReturn6Steps()
    {
        Setup();
        String input = "31";
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void GivenANumberShouldLongDivideBy2()
    {
        Setup();
        String input = "103568";
        int expectedResult = 51784;
        Assertions.assertEquals(expectedResult, Integer.parseInt(controller.LongDivisionBy2(input)));
    }
}
