/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;

/**
 *
 * @author SuslovAI
 */
public class NullValidator<T> implements ConstraintValidator<T>{
    
    
    @Override
    public boolean isValid(T actual) throws ConstraintValidationException {
        return actual==null;
    
    }
    
    @Override
    public ConstraintDescription getConstraintDescription() {
        return new ConstraintDescription(UsesConstraintNameNullSafeValidator.CONSTRAINT_NAME_BASIS+".isNull", new String[]{});
    }
    
    public static <T> ConstraintValidator<T> isNull(){
        return new NullValidator();
    }
    
}
