package com.example.wizer.exceptions;

import com.example.wizer.response.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

/**
 * @author Okala III
 * Date Created: 9/15/2019
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {


        @ExceptionHandler(value = {NoSuchElementException.class, IllegalArgumentException.class})
        protected ResponseEntity<?> handleConflict(Exception ex, WebRequest request) throws Exception {

            //add headers to be returned with response
            HttpHeaders headers = new HttpHeaders();

           if (ex instanceof IllegalArgumentException ) {
                log.error(ex.getMessage(), ex);
                return new ResponseEntity<>(new JsonResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);

            }  if (ex instanceof NoSuchElementException) {
                log.error(ex.getMessage(), ex);
                return new ResponseEntity<>(new JsonResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);

            }
             else {
                // rethrow the given exception for further processing through the HandlerExceptionResolver chain.
                throw ex;
            }
        }

}
