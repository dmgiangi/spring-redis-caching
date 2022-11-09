package dev.dmgiangi.springrediscaching.exceptions.handlers;

import dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist;
import dev.dmgiangi.springrediscaching.exceptions.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Handle Entity Does Not Exist
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 10 09 2022
 */
@ControllerAdvice
public class EntityDoesNotExists_EXC_HAN {
    /**
     * entityDoesNotExistExceptionHandler.
     *
     * @param e       a {@link dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist} object
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @return a {@link org.springframework.http.ResponseEntity} object
     */
    @ExceptionHandler({EntityDoesNotExist.class})
    public ResponseEntity<ErrorDto> entityDoesNotExistExceptionHandler(
            EntityDoesNotExist e,
            HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorDto()
                        .setError("aswetwegtfw")
                        .setErrorMessage(e.getMessage())
                        .setStatus(HttpStatus.NOT_FOUND)
                        .setPath(
                                request.getRequestURI()
                                        .substring(
                                                request.getContextPath().length())),
                HttpStatus.NOT_FOUND
        );
    }
}
