package Lesson3.password;

public enum PasswordEnum {

    MIN_PASSWORD_LENGTH("Пароль должен быть не менее 8 символов."),
    CONTAINS_A_DIGIT("Пароль должен содержать хотя бы одну цифру."),
    CONTAINS_A_CAPITAL_LETTER("Пароль должен содержать хотя бы одну заглавную букву."),
    PASSWORD_IS_CORRECT("Пароль корректный");
    private String text;
    PasswordEnum(String text)
    {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
