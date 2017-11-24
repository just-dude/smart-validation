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
public class ConstraintValidationException extends ValidationException{

    public ConstraintValidationException(String message) {
        super(message);
    }

    public ConstraintValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
