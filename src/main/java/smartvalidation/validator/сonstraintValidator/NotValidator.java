/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;


/**
 *
 * @author SuslovAI
 */
public class NotValidator<T> implements ConstraintValidator<T>{

    private final ConstraintValidator<T> validator;
    
    public NotValidator(ConstraintValidator<T> validator) {
        if(validator==null){
            throw new ConstraintValidationException("Argument 'smartvalidation.validator' is null");
        }
        this.validator = validator;
    }
    
    @Override
    public boolean isValid(T actual) throws ConstraintValidationException {
        return !validator.isValid(actual);
    }

    @Override
    public ConstraintDescription getConstraintDescription() {
        return reverseConstraintViolationMessage(validator.getConstraintDescription());
    }

    
    private ConstraintDescription reverseConstraintViolationMessage(ConstraintDescription msg) {
        ConstraintDescription result;
        String constraintFullName = msg.getConstraintFullName();
        if(!constraintFullName.contains(".not.")){
            constraintFullName=constraintFullName.replace(UsesConstraintNameNullSafeValidator.CONSTRAINT_NAME_BASIS,
                    UsesConstraintNameNullSafeValidator.CONSTRAINT_NAME_BASIS+".not");
        } else{
            constraintFullName=constraintFullName.replace(".not","");            
        }        
        result = new ConstraintDescription(constraintFullName,msg.getConstraintParameters());
        return result;
    }
    
    
    public static <T> ConstraintValidator<T> not(ConstraintValidator<T> validator){
        return new NotValidator(validator);
    }
    
    
    
}
