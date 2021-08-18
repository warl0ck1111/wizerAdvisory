package com.example.wizer.exceptions;

import lombok.Data;

/**
 * @author Okala III
 * Date Created: 2/14/2021
 * Project Name: sandbox
 */
@Data
public class ElementAlreadyExistException extends RuntimeException {
   private String response;
    public ElementAlreadyExistException(String message) {
        super(message);
        message = response;
    }
}
