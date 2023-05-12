import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final Burger burger = new Burger();
    String expectedReceipt = "(==== Белая булочка с кунжутом ====)\r\n" +
                             "= filling Котлета из говядины =\r\n" +
                             "= sauce Горчичный =\r\n" +
                             "(==== Белая булочка с кунжутом ====)\r\n" +
                             "\r\n" +
                             "Price: 230,000000" + "\r\n";

    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauce);
        Assert.assertEquals(List.of(sauce), burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        Assert.assertEquals(List.of(filling), burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(List.of(filling, sauce), burger.ingredients);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(50.00f);
        Mockito.when(filling.getPrice()).thenReturn(100.00f);
        Mockito.when(sauce.getPrice()).thenReturn(30.00f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = bun.getPrice() * 2 + filling.getPrice() + sauce.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Белая булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(50.00f);
        Mockito.when(filling.getName()).thenReturn("Котлета из говядины");
        Mockito.when(filling.getPrice()).thenReturn(100.00f);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sauce.getName()).thenReturn("Горчичный");
        Mockito.when(sauce.getPrice()).thenReturn(30.00f);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
