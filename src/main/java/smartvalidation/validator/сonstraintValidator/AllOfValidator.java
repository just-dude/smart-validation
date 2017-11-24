/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import java.util.*;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;

public class AllOfValidator<T> extends CombinationValidator<T>{
    
    protected ConstraintValidator<? super T> shortcutValidator;
    
    public AllOfValidator(Collection<ConstraintValidator<? super T>> validators) {
        super(validators);
        this.shortcutValidator=null;
    }
    
    @Override
    public boolean isValid(T actual) {
        for (ConstraintValidator<? super T> validator : validators) {
            if (!validator.isValid(actual)) {
                this.shortcutValidator=validator;
                return false;
            }
        }
        this.shortcutValidator=null;
        return true;
    }
    
    @Override
    public ConstraintDescription getConstraintDescription() throws ConstraintValidationException{
        if(this.shortcutValidator!=null){
            return this.shortcutValidator.getConstraintDescription();
        }else{
            throw new ConstraintValidationException("No constraint violations have occured");
        }
            
    }
    
    public static <T> ConstraintValidator<T> AllOf(Collection<ConstraintValidator<? super T>> validators){
        return new AllOfValidator(validators);
    }
    
    public static <T> ConstraintValidator<T> AllOf(ConstraintValidator<? super T>... validators){
        return new AllOfValidator(Arrays.asList(validators));
    }
    
}
