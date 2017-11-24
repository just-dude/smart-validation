/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.NullValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import static org.hamcrest.CoreMatchers.*;
import smartvalidation.exception.ConstraintValidationException;


public class NullValidatorTest{

    private final ConstraintValidator validator;
    
    public NullValidatorTest() {
        this.validator=NullValidator.isNull();
    }

    @Test
    public void testIsValid() {
        Object nullReference = null;
        Object notNullReference=new Object();
        assertTrue(validator.isValid(nullReference));
        assertFalse(validator.isValid(notNullReference));
        assertFalse(validator.isValid(3));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertThat(validator.getConstraintDescription().getConstraintFullName(),is("validation.constraintViolation.isNull"));
    }

    @Test
    public void testIsNull() {
    }
    

    
}
