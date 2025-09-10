package ru.diasoft.springbootcourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-контроллер для удвоения числа.
 */
@RestController
public class DoublingController {

    /**
     * Обрабатывает GET-запрос вида /doubling?value=X
     *
     * @param value число, которое нужно удвоить; если null, используется 0
     * @return строка с результатом удвоения
     */
    @GetMapping("/doubling")
    public String doubling(@RequestParam(required = false, defaultValue = "0") Integer value) {
        return "Удвоенное значение: " + (value * 2);
    }
}
