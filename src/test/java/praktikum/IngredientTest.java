package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private final String NAME_INGREDIENT = "Халапеньо";
    private final float PRICE_INGREDIENT = 10f;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, NAME_INGREDIENT, PRICE_INGREDIENT);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Неверная цена ингредиента", PRICE_INGREDIENT, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Неверное имя ингредиента", NAME_INGREDIENT, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Типы ингредиентов не совпадают", IngredientType.FILLING, ingredient.getType());
    }
}