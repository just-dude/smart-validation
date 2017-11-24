/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.base.FeatureNullSafeValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.exception.ConstraintValidationException;

/**
 *
 * @author SuslovAI
 */
public class StringLengthValidator extends FeatureNullSafeValidator<String,Integer>{

    public StringLengthValidator(ConstraintValidator<Integer> validator) {
        super(validator, "length");
    }

    @Override
    protected Integer featureValueOf(String actual) throws ConstraintValidationException {
        return actual.length();
    }
    
    public static ConstraintValidator<String> stringLength(ConstraintValidator<Integer> validator){
        return new StringLengthValidator(validator);
    }
}
