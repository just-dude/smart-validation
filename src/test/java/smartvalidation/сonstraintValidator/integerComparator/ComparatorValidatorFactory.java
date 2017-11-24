/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator.integerComparator;

import smartvalidation.validator.сonstraintValidator.ComparatorValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import java.lang.reflect.*;

public class ComparatorValidatorFactory {
        
    public static <T extends Comparable<T>> ConstraintValidator<T> getComparatorValidatorInstanceByName(String name,Object initArgument) throws RuntimeException{
        ComparatorValidator validator;
        Class c =  ComparatorValidator.class;
        try{
            Method m = c.getMethod(name, Comparable.class);
            validator=(ComparatorValidator<T>)m.invoke(null,initArgument);
        }
        catch(Exception e){
            throw new RuntimeException("Exception has occured",e);
        }
        return validator;
    }
}
