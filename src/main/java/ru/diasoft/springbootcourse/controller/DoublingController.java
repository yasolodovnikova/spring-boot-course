package ru.diasoft.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.springbootcourse.domain.Doubling;
import ru.diasoft.springbootcourse.service.DoublingService;

/**
 * REST-контроллер для обработки запросов удвоения числа.
 */
@RestController
public class DoublingController {

    @Autowired
    private DoublingService doublingService;

    /**
     * Обрабатывает GET-запрос вида /doubling?value=X
     *
     * @param value число, которое нужно удвоить; если null, используется 0
     * @return объект {@link Doubling} с результатом удвоения
     */
    @GetMapping("/doubling")
    public Doubling doubling(@RequestParam(required = false) Integer value) {
        return doublingService.getDoubling(value);
    }
}
