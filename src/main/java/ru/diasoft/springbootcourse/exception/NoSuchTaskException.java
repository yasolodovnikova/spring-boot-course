package ru.diasoft.springbootcourse.exception;

/**
 * Исключение, выбрасываемое при отсутствии задачи с заданным ID.
 */
public class NoSuchTaskException extends RuntimeException{

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param msg описание ошибки
     */
    public NoSuchTaskException(String msg) {
        super(msg);
    }
}
