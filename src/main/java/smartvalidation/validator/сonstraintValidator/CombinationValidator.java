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

public abstract class CombinationValidator<T> implements ConstraintValidator<T>{
    
    protected Collection<ConstraintValidator<? super T>> validators;
    
    public CombinationValidator(Collection<ConstraintValidator<? super T>> validators) {
        if(validators==null){
            throw new ConstraintValidationException("Argument 'validators' is null");
        }
        if(validators.isEmpty()){
            throw new ConstraintValidationException("Argument 'validators' is empty");
        }
        if(hasArgumentNullValues(validators)){
            throw new ConstraintValidationException("Argument 'validators' contains null value(s) in position(s): "+Arrays.toString(getArgumentNullValuePositions(validators)));
        }
        this.validators = validators;
    }
       
    protected <U> boolean hasArgumentNullValues(Collection<U> argument){
        for(U arg: argument){
            if(arg==null)
                return true;            
        }
        return false;
    }
    
    protected <U> Integer[] getArgumentNullValuePositions(Collection<U> argument){
        List<Integer> positions = new ArrayList(); 
        int i=0;
        for(U arg: argument){
            if(arg==null){
                positions.add(i);
            }
            i++;
        }
        return (Integer[])positions.toArray();
    }
    
}
