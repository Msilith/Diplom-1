package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class BunParametersTest {

    private static final String LONG_NAME = RandomStringUtils.randomAlphabetic(100);
    private static final String SPEC_NAME = RandomStringUtils.random(10,' ', '.', '/', ',', '|', '!', '@', '$', '%');
    private final String name;
    private final float price;
    @Mock
    private Bun bun;

    public BunParametersTest (String name, float price) {

        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters(name = "Проверка возвращаемого значения в зависимости от переданного. Тестовые данные: {0} : {1}")
    public static Object[][] lionSexParameters() {
        return new Object[][]{

                {"", -18.5f},
                {null, 0},
                {LONG_NAME, 0.001f},
                {SPEC_NAME, 1255}

        };
    }

    @Test
    public void returnActualNameAndPrice() {

        bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0);

    }

}
