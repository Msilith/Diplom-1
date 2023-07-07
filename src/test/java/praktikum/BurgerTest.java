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

    private final String nameBun = "Ржаная булочка";
    private final float priceBun = 18.5f;
    private final String nameIngredient = "Горчица";
    private final float priceIngredient = 10.1f;
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
        Mockito.when(bun.getName()).thenReturn(nameBun);
        String actual = bun.getName();
        assertEquals("Возвращается неверное название булочки", nameBun, actual);
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
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(nameIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(priceIngredient);

        burger.addIngredient(firstIngredient);

        String expected =
                String.format("(==== %s ====)%n", nameBun) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), nameIngredient) +
                        String.format("(==== %s ====)%n", nameBun) +
                        String.format("%nPrice: %f%n", (priceBun * 2 + priceIngredient));

        assertEquals("Чек неккоректен", expected, burger.getReceipt());

    }
}