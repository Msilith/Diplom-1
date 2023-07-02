package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String TEST_NAME = "хлебушек";
    private final float TEST_PRICE = 10.5f;
    private Bun bun;

    @Before
    public void setUp() {

        bun = new Bun(TEST_NAME, TEST_PRICE);

    }

    @Test
    public void getNameReturnCorrectValue() {

        String actual = bun.getName();
        assertEquals("Ошибка в имени булочки", TEST_NAME, actual);

    }

    @Test
    public void getPriceReturnCorrectValue() {
        float actual = bun.getPrice();
        assertEquals("Ошибка в цене булочки", TEST_PRICE, actual, 0);
    }

}