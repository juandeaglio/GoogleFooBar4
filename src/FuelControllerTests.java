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
        int expectedResult = 4;
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
    void Given5ShouldReturn3Steps()
    {
        Setup();
        String input = "5";
        int expectedResult = 3;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given2ShouldReturn1Steps()
    {
        Setup();
        String input = "2";
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given4ShouldReturn2Steps()
    {
        Setup();
        String input = "4";
        int expectedResult = 2;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given15houldReturn5Steps()
    {
        Setup();
        String input = "15";
        int expectedResult = 5;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }
    @Test
    void Given1ShouldReturn0Steps()
    {
        Setup();
        String input = "1";
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, controller.Optimize(input));
    }

}
