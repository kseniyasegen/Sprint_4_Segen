import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;


    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        /* регулярка на все правила у меня не получилась.
        сам механизм работы с регуляркой понятен. Код, с которым работала - закомментила
        Pattern pattern = Pattern.compile("^[^ ](.+)+[ ]+(.+)+[^ ]$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

         */

        if (checkLengthName() && isFirstAndLastNotSpace()) {
            return true;
        }
        ;
        return false;
    }

    public boolean checkLengthName() {
        if (StringUtils.isNotEmpty(name)) {
            return ((name.length() >= 3) && (name.length() <= 19));
        };
        return false;
    }

    public boolean isFirstAndLastNotSpace() {
        if (StringUtils.isNotEmpty(name)) {
            int n = name.length();
            return ((name.charAt(0) != ' ') && (name.charAt(n - 1) != ' '));
        };
        return false;
    }
}