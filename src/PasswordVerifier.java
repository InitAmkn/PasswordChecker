package Lesson3.password;

/*
Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)

        Создайте класс PasswordVerifier.
        Этот класс должен содержать метод,
        который принимает строку пароля и проверяет его на соответствие следующим правилам:

        Пароль должен быть не менее 8 символов.
        Пароль должен содержать хотя бы одну цифру.
        Пароль должен содержать хотя бы одну заглавную букву.
        Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
 */


/**
 * Проверка ввода пароля:
 * Пароль должен быть не менее 8 символов.
 * Пароль должен содержать хотя бы одну цифру.
 * Пароль должен содержать хотя бы одну заглавную букву.
 */
public class PasswordVerifier {
    private String password;


    public boolean isThePasswordCorrect(String inputPassword) {
        try {
            int minLength = 8;
            if (inputPassword.length() < minLength) {
                throw new InvalidPasswordException(PasswordEnum.MIN_PASSWORD_LENGTH.toString());
            }
            if (!isContainsToUpperCase(inputPassword)) {
                throw new InvalidPasswordException(PasswordEnum.CONTAINS_A_CAPITAL_LETTER.toString());
            }
            if (!isContainsToNumbers(inputPassword)) {
                throw new InvalidPasswordException(PasswordEnum.CONTAINS_A_DIGIT.toString());
            }
            password = inputPassword;
            return true;

        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Проверка наличия символов в строке
     */
    private boolean isContainsToString(String inputPassword, String str) {
        for (Character i : str.toCharArray()) {
            if (inputPassword.contains(i.toString())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Пароль должен содержать хотя бы одну цифру.
     */
    private boolean isContainsToNumbers(String inputPassword) {
        String numbers = "0123456789";
        return isContainsToString(inputPassword, numbers);
    }

    /**
     * Пароль должен содержать хотя бы одну заглавную букву.
     */
    private boolean isContainsToUpperCase(String inputPassword) {
        String abcENG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcRUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        return isContainsToString(inputPassword, abcENG + abcRUS);
    }
}
