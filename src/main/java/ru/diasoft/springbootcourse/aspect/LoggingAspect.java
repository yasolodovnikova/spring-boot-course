package ru.diasoft.springbootcourse.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.diasoft.springbootcourse.aspect.annotation.Loggable;

import java.util.Arrays;

/**
 * Аспект для логгирования методов, помеченных аннотацией {@link Loggable}.
 * Логирует:
 * <ul>
 *     <li>название метода</li>
 *     <li>входные параметры</li>
 *     <li>результат выполнения</li>
 *     <li>ошибку, если она произошла</li>
 * </ul>
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    /**
     * Логирует выполнение методов, помеченных аннотацией {@link Loggable}.
     *
     * @param joinPoint точка соединения (метод, который вызывается)
     * @return результат выполнения метода
     * @throws Throwable если исходный метод выбрасывает исключение
     */
    @Around("@annotation (ru.diasoft.springbootcourse.aspect.annotation.Loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Логгировани метода " + joinPoint.getSignature().getName());
        logger.info("Входные параметры: " + Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        logger.info("Завершил работу метод " + joinPoint.getSignature().getName());
        logger.info("Результат работы метода " + joinPoint.getSignature().getName() + " : " + result);

        return result;
    }

    /**
     * Логирует ошибку, если метод выбросил исключение.
     *
     * @param joinPoint точка соединения (метод, в котором произошла ошибка)
     * @param error     исключение, которое возникло
     */
    @AfterThrowing(
            pointcut = "@annotation (ru.diasoft.springbootcourse.aspect.annotation.Loggable)",
            throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error(error.toString());
    }

//    @Before("execution (* ru.diasoft.springbootcourse.service.DoublingServiceImpl.*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        logger.info("Логгировани метода " + joinPoint.getSignature().getName());
//        logger.info("Входные параметры: " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @After("execution (* ru.diasoft.springbootcourse.service.DoublingServiceImpl.*(..))")
//    public void logAfter(JoinPoint joinPoint) {
//        logger.info("Завершил работу метод " + joinPoint.getSignature().getName());
//    }
//
//    @AfterReturning(
//            pointcut = "execution (* ru.diasoft.springbootcourse.service.DoublingServiceImpl.*(..))",
//            returning = "result"
//    )
//    public void getAfterReturning(JoinPoint joinPoint, Object result) {
//        logger.info("Результат работы метода " + joinPoint.getSignature().getName() + " : " + result);
//    }
}
