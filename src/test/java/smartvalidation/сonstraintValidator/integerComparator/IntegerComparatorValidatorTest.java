/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator.integerComparator;

import smartvalidation.validator.сonstraintValidator.ComparatorValidator;
import smartvalidation.exception.ConstraintValidationException;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.constraintDescription.ConstraintDescription;
import static org.junit.Assert.*;
import org.hamcrest.collection.*;
import junitparams.Parameters;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IntegerComparatorValidatorTest { 
    
               
    @Test
    @Parameters(source = ValidatorParamsProvider.ComparatorValidatorIsValidParametersProvider.class)
    public void testComparatorIsValid(String validatorName,Integer firstValue, Integer secondValue, Boolean expectedIsValidResult) {
        ConstraintValidator<Integer> validator = ComparatorValidatorFactory.getComparatorValidatorInstanceByName(validatorName, firstValue);        
        assertEquals(validator.isValid(secondValue), expectedIsValidResult);
    }
    
    @Test
    @Parameters(source = ValidatorParamsProvider.ComparatorValidatorGetConstraintViolationMessageParametersProvider.class)
    public void testComparatorGetConstraintViolationMessage(String validatorName, Integer validatorInitParam, String constraintName) {
        ConstraintValidator<Integer> validator = ComparatorValidatorFactory.getComparatorValidatorInstanceByName(validatorName, validatorInitParam);    
        ConstraintDescription msg = validator.getConstraintDescription();
        assertEquals(msg.getConstraintFullName(), constraintName);
        assertThat(msg.getConstraintParameters(), IsArrayWithSize.arrayWithSize(1));
        assertEquals(msg.getConstraintParameters()[0], validatorInitParam.toString());
    }
 
    @Test
    public void testComparatorNullValueInitializationThrowingException(){
        try{
            ComparatorValidator.equalTo(null);
            fail("Expected an ConstraintValidatorException with message \"Argument 'expected' is null\"to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Argument 'expected' is null");
        }
    }
    
    @Test
    public void testComparatorValidatingNullValueThrowingxception(){
        try{
            ConstraintValidator<Integer> validator = (ConstraintValidator<Integer>)ComparatorValidator.equalTo(1);
            validator.isValid(null);
            fail("Expected an ConstraintValidatorException with message \"Validating value is null\"to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Validating value is null");
        }
    }
        
    
    
}
