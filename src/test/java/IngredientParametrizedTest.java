import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final String name;
    private final float price;
    IngredientType ingredientType;

    public IngredientParametrizedTest(String name, float price, IngredientType ingredientType) {
        this.name = name;
        this.price = price;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Создание ингредиента с данными - {0}, {1}, {2}")
    public static Object[][] getIngredientParameters() {
        return new Object[][] {
                {"Котлета из говядины ", 99.99f, FILLING},
                {" mustard!@", 0, SAUCE},
                {"", -1, SAUCE},
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Цена ингредиента некорректна", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Название ингредиента некорректно", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("Цена ингредиента некорректна", ingredientType, ingredient.getType());
    }
}
