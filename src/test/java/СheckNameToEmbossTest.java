import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(Parameterized.class)
@AllArgsConstructor
public class СheckNameToEmbossTest {

    private String name;
    private boolean expected;


    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][]{
                {"Ксю", true},
                {"Ксю Ксю", true},
                {" Ксю Ксю ", false},
                {" ", false},
                {"", false},
                {null, false},

        };
    }

    //проверка метода checkNameToEmboss()
    @Test
    @DisplayName("Проверка метода checkNameToEmboss")
    @Description("Тест проверяет, что ФИ соответствует слудующим критериям:\n" +
            "количество символов >= 3 и <= 19\n" +
            "нет пробелов в начале и в конце\n")
    public void checkNameToEmbossReturnResult() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}
