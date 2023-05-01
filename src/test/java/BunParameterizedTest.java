import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String bunName;
    private final float bunPrice;

    public BunParameterizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Создание булочки с данными - {0}, {1}")
    public static Object[][] getBunParameters() {
        return new Object[][] {
                {"Белая булочка ", 999.99f},
                {" blackbun", 1},
                {"", 0},
                {"!@#$%^&", -1},
                {"булочка с неоправданно очень длинным названием", -999.99f},
        };
    }

    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Неверное название булочки", bunName, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Неверная цена булочки", bunPrice, bun.getPrice(),0);
    }
}
