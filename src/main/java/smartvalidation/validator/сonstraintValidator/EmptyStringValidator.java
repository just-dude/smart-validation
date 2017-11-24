/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;

/**
 *
 * @author SuslovAI
 */
public class EmptyStringValidator extends UsesConstraintNameNullSafeValidator<String>{

    public EmptyStringValidator() {
        super("emptyString");
    }
    
    @Override
    public boolean isNullSafeValid(String actual) throws ConstraintValidationException {
        return actual.equals("");
    }
    
    public static ConstraintValidator<String> emptyString(){
        return emptyStringValidator;
    }   
    
    private static final ConstraintValidator<String> emptyStringValidator = new EmptyStringValidator();
    
    
}
