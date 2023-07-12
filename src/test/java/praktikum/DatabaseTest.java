package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void checkBunListSize() {
        Assert.assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void checkIngredientListSize() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }
}