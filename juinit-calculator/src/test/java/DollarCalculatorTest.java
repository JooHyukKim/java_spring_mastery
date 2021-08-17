import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello() {
        System.out.println("Hello");
    }

    @Test
    public void mockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Assertions.assertEquals(60000, dollarCalculator.sum(10, 10));
        Assertions.assertEquals(0, dollarCalculator.subtract(10, 10));
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();
        System.out.println(dollarCalculator.sum(10, 20));
        System.out.println(dollarCalculator.sum(10, 20));

        Assertions.assertEquals(22000, dollarCalculator.sum(10, 10));
        Assertions.assertEquals(0, dollarCalculator.subtract(10, 10));
    }
}
