/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.entityValidator;

import smartvalidation.constraintViolation.ConstraintViolation;

import java.util.*;
import smartvalidation.exception.EntityValidationException;

public interface EntityValidator {
    
    public boolean isValid() throws EntityValidationException;
    public List<ConstraintViolation> getConstraintViolations() throws EntityValidationException;
    
}
