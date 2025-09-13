package ru.diasoft.springbootcourse.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.diasoft.springbootcourse.exception.NoSuchTaskException;

/**
 * Глобальный обработчик исключений.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обработка ситуации, когда задача не найдена.
     *
     * @param e исключение {@link NoSuchTaskException}
     * @return ответ с кодом 404 и сообщением об ошибке
     */
    @ExceptionHandler(NoSuchTaskException.class)
    public ResponseEntity<String> handleNoSuchTaskException(NoSuchTaskException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
