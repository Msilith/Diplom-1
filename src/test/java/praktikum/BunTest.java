package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String testName = "хлебушек";
    private final float testPrice = 10.5f;
    private Bun bun;

    @Before
    public void setUp() {

        bun = new Bun(testName, testPrice);

    }

    @Test
    public void getNameReturnCorrectValue() {

        String actual = bun.getName();
        assertEquals("Ошибка в имени булочки", testName, actual);

    }

    @Test
    public void getPriceReturnCorrectValue() {
        float actual = bun.getPrice();
        assertEquals("Ошибка в цене булочки", testPrice, actual, 0);
    }

}