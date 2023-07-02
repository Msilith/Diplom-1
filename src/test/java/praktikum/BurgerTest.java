package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final String NAME_BUN = "Ржаная булочка";
    private final float PRICE_BUN = 18.5f;
    private final String NAME_INGREDIENT = "Горчица";
    private final float PRICE_INGREDIENT = 10.1f;
    Burger burger;

    @Mock
    Bun bun;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);

    @Before
    public void setUp (){
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);
        String actual = bun.getName();
        assertEquals("Возвращается неверное название булочки", NAME_BUN, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals("Неверное колличество ингредиентов в бургере", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("Ингридиент не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не поменялись местами", "secondIngredient", burger.ingredients.get(0).toString());
    }

    @Test
    public void getPriceBunTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(20f);
        float actual = bun.getPrice();
        assertEquals("Цена булочки некорректна", 20f, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(NAME_INGREDIENT);
        Mockito.when(firstIngredient.getPrice()).thenReturn(PRICE_INGREDIENT);

        burger.addIngredient(firstIngredient);

        String expected =
                String.format("(==== %s ====)%n", NAME_BUN) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), NAME_INGREDIENT) +
                        String.format("(==== %s ====)%n", NAME_BUN) +
                        String.format("%nPrice: %f%n", (PRICE_BUN * 2 + PRICE_INGREDIENT));

        assertEquals("Чек неккоректен", expected, burger.getReceipt());

    }
}