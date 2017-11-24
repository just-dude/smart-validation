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
public abstract class UsesConstraintNameNullSafeValidator<T> extends NullSafeValidator<T>{
    
    public static final String CONSTRAINT_NAME_BASIS = "validation.constraintViolation";
    
    protected final String constraintName;
    
    public UsesConstraintNameNullSafeValidator(String constraintName) {
        if(constraintName==null || constraintName.equals("")){
            throw new ConstraintValidationException("Argument 'constraintName' is null or empty");
        }        
        this.constraintName=constraintName;
    }

    @Override
    public abstract boolean isNullSafeValid(T actual) throws ConstraintValidationException;

    @Override
    public ConstraintDescription getConstraintDescription() {
        return new ConstraintDescription(CONSTRAINT_NAME_BASIS+"."+constraintName, new String[]{});
    }
}
