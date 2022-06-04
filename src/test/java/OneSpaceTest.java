import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
@AllArgsConstructor
public class OneSpaceTest {

    private String name;
    private boolean expected;

    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][]{
                {"Ксю", false},
                {"Ксю Ксю", true},
                {"Ксю Ксю Ксю", false},
        };
    }

    //проверка метода isOneSpace()
    @Test
    @DisplayName("Проверка метода isOneSpace на граничные значения")
    @Description("Тест проверяет, что количество пробелов == 1")
    public void isOneSpaceReturnResult() {
        Account account = new Account(name);
        boolean actual = account.isOneSpace();
        Assert.assertEquals(expected, actual);
    }
}
