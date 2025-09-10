package ru.diasoft.springbootcourse.service;

import ru.diasoft.springbootcourse.domain.Doubling;

/**
 * Сервис для выполнения операций удвоения чисел.
 */
public interface DoublingService {

    /**
     * Удваивает переданное число.
     *
     * @param value исходное число
     * @return результат удвоения в виде {@link Doubling}
     */
    Doubling getDoubling(Integer value);
}
