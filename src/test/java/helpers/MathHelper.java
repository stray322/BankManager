package helpers;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * Утилиты для математических операций с коллекциями.
 */
public class MathHelper {

    private MathHelper() {}

    /**
     * Вычисляет среднее значение для числовых свойств элементов.
     * @param items список элементов
     * @param mapper функция преобразования элемента в число
     * @return среднее значение
     * @param <T> тип элементов
     * @throws IllegalArgumentException если список пуст
     */
    public static <T> double calculateAverage(List<T> items, ToDoubleFunction<T> mapper) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Список элементов не может быть пустым");
        }

        return items.stream()
                .mapToDouble(mapper)
                .average()
                .orElseThrow();
    }

    /**
     * Находит элементы с минимальным отклонением от целевого значения.
     * @param items список элементов
     * @param target целевое значение
     * @param valueExtractor функция извлечения числового значения
     * @return список элементов с минимальной разницей
     * @param <T> тип элементов
     */
    public static <T> List<T> findClosestItems(List<T> items, double target, ToDoubleFunction<T> valueExtractor) {
        if (items == null || items.isEmpty()) {
            return Collections.emptyList();
        }

        TreeMap<Double, List<T>> differences = items.stream()
                .collect(Collectors.groupingBy(
                        item -> Math.abs(valueExtractor.applyAsDouble(item) - target),
                        TreeMap::new,
                        Collectors.toList()
                ));

        return differences.firstEntry().getValue();
    }
}
