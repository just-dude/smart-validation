/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.exception;

/**
 *
 * @author SuslovAI
 */
public class PropertyValidationException extends ValidationException{

    public PropertyValidationException(String message) {
        super(message);
    }

    public PropertyValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
