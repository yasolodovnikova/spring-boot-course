package ru.diasoft.springbootcourse.service;

import org.springframework.stereotype.Service;
import ru.diasoft.springbootcourse.domain.Doubling;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Реализация сервиса удвоения чисел.
 */
@Service
public class DoublingServiceImpl implements DoublingService {

    private static final String DOUBLING_TEMPLATE = "Удвоенное значение: %d";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Doubling getDoubling(Integer value) {
        long id = counter.incrementAndGet();

        int doublingValue = (value == null) ? 0 : value * 2;

        return new Doubling(id, doublingValue, String.format(DOUBLING_TEMPLATE, doublingValue));
    }
}
