/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator.base;

import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;

public interface ConstraintValidator<T> {
    
    public boolean isValid(T actual) throws ConstraintValidationException;
    
    public ConstraintDescription getConstraintDescription();
    
}
