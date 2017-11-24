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
public abstract class FeatureNullSafeValidator<T,U> extends NullSafeValidator<T>{

    protected final ConstraintValidator<? super U> validator;
    protected String featureName;
    
    public FeatureNullSafeValidator(ConstraintValidator<? super U> validator,String featureName) {
        if(validator==null){
            throw new ConstraintValidationException("Argument 'smartvalidation.validator' is null");
        }
        if(featureName==null ||featureName.equals("")){
            throw new ConstraintValidationException("Argument 'featureName' is null or empty");
        }
        this.validator=validator;
        this.featureName=featureName;
    }    
    
    protected abstract U featureValueOf(T actual) throws ConstraintValidationException;
    
    @Override
    public boolean isNullSafeValid(T actual) throws ConstraintValidationException {
        return validator.isValid(featureValueOf(actual));
    }

    @Override
    public ConstraintDescription getConstraintDescription() {
        ConstraintDescription msg= validator.getConstraintDescription();
        msg.setConstraintFullName(msg.getConstraintFullName()+"."+this.featureName);
        return msg;
    }
        
}