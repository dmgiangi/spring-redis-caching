package dev.dmgiangi.springrediscaching.exceptions.handlers;

import dev.dmgiangi.springrediscaching.exceptions.model.MultipleErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handle Method Argument Not Valid Exception
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 10 09 2022
 */
@ControllerAdvice
public class MethodArgumentNotValid_EXC_HAN {
    /**
     * handle exceptions of {@link org.springframework.web.bind.MethodArgumentNotValidException} type
     *
     * @param e       a {@link org.springframework.web.bind.MethodArgumentNotValidException} object
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @return a {@link org.springframework.http.ResponseEntity} object
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<MultipleErrorDto> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException e,
            HttpServletRequest request) {

        //Get all the error fields form the exception
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        /*
         * Map the list of object with attributes ("field", "message")
         * to a map with key "field" and value a list of "message"
         */
        Map<String, List<String>> errors = fieldErrors
                .stream()
                .collect(
                        Collectors.groupingBy(
                                FieldError::getField,
                                Collectors.mapping(
                                        FieldError::getDefaultMessage,
                                        Collectors.toList()
                                )
                        )
                );

        return ResponseEntity
                .badRequest()
                .body(
                        new MultipleErrorDto()
                                .setStatus(HttpStatus.BAD_REQUEST)
                                .setError("sfsfsf<f<wesf")
                                .setErrorMessages(errors)
                                .setPath(
                                        request.getRequestURI()
                                                .substring(
                                                        request.getContextPath().length())
                                )
                );
    }
}
