/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import java.util.Collection;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;

/**
 *
 * @author SuslovAI
 */
public class ContainsNullValidator<T extends Collection> implements ConstraintValidator<T>{
    
    
    @Override
    public boolean isValid(T actual) throws ConstraintValidationException {
        return actual.contains(null);    
    }
    
    @Override
    public ConstraintDescription getConstraintDescription() {
        return new ConstraintDescription(UsesConstraintNameNullSafeValidator.CONSTRAINT_NAME_BASIS+".containsNull", new String[]{});
    }
    
    public static <T> ConstraintValidator<T> containsNull(){
        return new ContainsNullValidator();
    }
    
}
