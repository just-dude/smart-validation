/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator.stub;

import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;
import smartvalidation.exception.ConstraintValidationException;

/**
 *
 * @author SuslovAI
 */
public class AlwaysValidator<T> extends UsesConstraintNameNullSafeValidator<T>{

    public AlwaysValidator() {
        super("always");
    }
    
    @Override
    public boolean isNullSafeValid(T actual) throws ConstraintValidationException {
        return true;
    }
    
    public static <T> ConstraintValidator<T> always(){
        return new AlwaysValidator();
    }
    
    
}
