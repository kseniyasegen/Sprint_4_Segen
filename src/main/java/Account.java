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

        if (checkLengthName() && isOneSpace() && isFirstAndLastNotSpace()) {
            return true;
        }
        ;
        return false;
    }


    //  }

    public boolean checkLengthName() {
        return ((name.length() >= 3) && (name.length() <= 19));
    }

    public boolean isOneSpace() {
        //return (name.contains(" "));
        int spaceCount = 0;
        for (char a : name.toCharArray()) {
            if (a == ' ') {
                spaceCount++;
            }
        }

        return (spaceCount == 1);


    }

    public boolean isFirstAndLastNotSpace() {
        int n = name.length();
        return ((name.charAt(0) != ' ') && (name.charAt(n - 1) != ' '));
    }


}