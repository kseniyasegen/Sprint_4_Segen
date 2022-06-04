import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
@AllArgsConstructor
public class LengthNameTest {

    private String name;
    private boolean expected;

    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][]{
                {"Кс", false},
                {"Ксю", true},
                {"Ксюш", true},
                {"КсенияКсенияКсения", true},
                {"КсенияКсенияКсенияК", true},
                {"КсенияКсенияКсенияКс", false},
        };
    }

    //проверка метода checkLengthName()
    @Test
    @DisplayName("Проверка метода checkLengthName на граничные значения")
    @Description("Текст проверяет количество символов ФИ на >= 3 и <= 19")
    public void checkLengthNameReturnResult() {
        Account account = new Account(name);
        boolean actual = account.checkLengthName();
        Assert.assertEquals(expected, actual);
    }
}
