package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private final String nameIngredient = "Халапеньо";
    private final float priceIngredient = 10f;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, nameIngredient, priceIngredient);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Неверная цена ингредиента", priceIngredient, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Неверное имя ингредиента", nameIngredient, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Типы ингредиентов не совпадают", IngredientType.FILLING, ingredient.getType());
    }
}