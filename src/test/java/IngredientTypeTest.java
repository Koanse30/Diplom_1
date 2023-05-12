import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import java.util.Arrays;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeSauceTest() {
        Assert.assertEquals("Не соответствует списку типов игредиентов",
                Arrays.toString(IngredientType.values()), "[SAUCE, FILLING]");
    }
}
