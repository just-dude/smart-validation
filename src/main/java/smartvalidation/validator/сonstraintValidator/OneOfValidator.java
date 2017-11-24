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

public class OneOfValidator<T> extends CombinationValidator<T>{
    
    private boolean isValid;
    
    public OneOfValidator(Collection<ConstraintValidator<? super T>> validators) {
        super(validators);
        isValid=true;
    }
    
    @Override
    public boolean isValid(T actual) {
        for (ConstraintValidator<? super T> validator : validators) {
            if (validator.isValid(actual)) {
                isValid=true;
                return true;                
            }
        }
        isValid=false;
        return false;
    }
    
    @Override
    public ConstraintDescription getConstraintDescription() throws ConstraintValidationException{
        throw new UnsupportedOperationException();
        /*if(!isValid){
            ConstraintDescription firstConstraintDescription = Iterators.get(validators.iterator(), 0).getConstraintDescription();
            ConstraintDescription buildedConstraintDescription = new ConstraintDescription(firstConstraintDescription.getConstraintFullName(),firstConstraintDescription.getConstraintParameters());
            Iterator validatorsIterator=validators.iterator();
            validatorsIterator.next();
            while(validatorsIterator.hasNext()){
                ConstraintDescription currentCD = validatorsIterator.next();
                String oldConstrainFullName = ;
                buildedConstraintDescription.setConstraintFullName(
                        buildedConstraintDescription.getConstraintFullName()+ currentCD.getConstraintFullName());
                buildedConstraintDescription.
            }
            return this.shortcutValidator.getConstraintDescription();
        }else{
            throw new ConstraintValidationException("No constraint violations have occured");
        }*/
    }
    
    public static <T> ConstraintValidator<T> OneOf(Collection<ConstraintValidator<? super T>> validators){
        return new OneOfValidator(validators);
    }
    
    public static <T> ConstraintValidator<T> OneOf(ConstraintValidator<? super T>... validators){
        return new OneOfValidator(Arrays.asList(validators));
    }
    
}
