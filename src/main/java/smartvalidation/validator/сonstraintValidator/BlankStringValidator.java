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
public class BlankStringValidator  extends UsesConstraintNameNullSafeValidator<String>{

    public BlankStringValidator() {
        super("blankString");
    }    
    
    @Override
    public boolean isNullSafeValid(String actual) throws ConstraintValidationException {
        return actual.trim().equals("");
    }
    
    public static ConstraintValidator<String> blankString(){
        return blankStringValidator;
    }   
    
    private static final ConstraintValidator<String> blankStringValidator = new BlankStringValidator();
    
    
}
