package helpers;

import org.testng.Assert;
import java.util.List;

/**
 * Утилитный класс для проверок утверждений.
 */
public class AssertHelper {

    private AssertHelper() {}

    /**
     * Проверяет равенство двух списков строк.
     * @param actual фактический список
     * @param expected ожидаемый список
     * @param message сообщение об ошибке
     */
    public static void assertEquals(List<String> actual, List<String> expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    /**
     * Проверяет, что условие истинно.
     * @param condition условие для проверки
     * @param message   сообщение об ошибке
     */
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Проверяет, что клиент отсутствует в таблице.
     * @param isPresent результат проверки наличия клиента
     * @param message сообщение об ошибке
     */
    public static void assertFalse(boolean isPresent, String message) {
        Assert.assertFalse(isPresent, message);
    }
}
