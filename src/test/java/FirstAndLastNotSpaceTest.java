import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
@AllArgsConstructor
public class FirstAndLastNotSpaceTest {

    private String name;
    private boolean expected;

    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][]{
                {"Ксю Ксю", true},
                {" Ксю Ксю", false},
                {"Ксю Ксю ", false},
                {" Ксю Ксю ", false},
        };
    }

    //проверка метода isFirstAndLastNotSpace()
    @Test
    @DisplayName("Проверка метода isFirstAndLastNotSpace на граничные значения")
    @Description("Тест проверяет, что нет пробелов в начале и в конце")
    public void isFirstAndLastNotSpaceReturnResult() {
        Account account = new Account(name);
        boolean actual = account.isFirstAndLastNotSpace();
        Assert.assertEquals(expected, actual);
    }
}
