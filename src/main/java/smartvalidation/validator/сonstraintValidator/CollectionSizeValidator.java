/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.validator.сonstraintValidator.base.FeatureNullSafeValidator;

import java.util.Collection;

/**
 *
 * @author SuslovAI
 */
public class CollectionSizeValidator<T extends Collection> extends FeatureNullSafeValidator<T,Integer>{

    public CollectionSizeValidator(ConstraintValidator<Integer> validator) {
        super(validator, "size");
    }

    @Override
    protected Integer featureValueOf(T actual) throws ConstraintValidationException {
        return actual.size();
    }
    
    public static <T extends Collection> ConstraintValidator<T> collectionSize(ConstraintValidator<Integer> validator){
        return new CollectionSizeValidator(validator);
    }
}
