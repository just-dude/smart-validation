/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator.base;

import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;

/**
 *
 * @author SuslovAI
 */
public abstract class NullSafeValidator<T> implements ConstraintValidator<T>{

    protected abstract boolean isNullSafeValid(T actual) throws ConstraintValidationException;
    
    @Override
    public final boolean isValid(T actual) throws ConstraintValidationException {
       if(actual!=null){
           return isNullSafeValid(actual);
       }else{
           throw new ConstraintValidationException("Validating value is null");
       }
    }
}