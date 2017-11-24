/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import smartvalidation.exception.ConstraintValidationException;
import static smartvalidation.validator.сonstraintValidator.OneOfValidator.OneOf;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

/**
 *
 * @author SuslovAI
 */
public class OneOfAndIntegerComparatorValidatorTest {
    
    private ConstraintValidator<Integer> validator;
    
    @Before
    public void setUp() {
        this.validator=OneOf(ComparatorValidator.lessThan(2),ComparatorValidator.greaterThan(4));
    }

    @Test
    public void testIsValid() {
        assertFalse(this.validator.isValid(2));
        assertFalse(this.validator.isValid(3));
        assertFalse(this.validator.isValid(4));
        assertTrue(this.validator.isValid(1));
        assertTrue(this.validator.isValid(5));
    }

    @Ignore
    @Test
    public void testGetConstraintViolationMessageWithoutConstraintViolations(){   
        try{
            this.validator.getConstraintDescription();
            fail("Expected smartvalidation.exception with message 'No constraint violations have occured' to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "No constraint violations have occured");
        }
        assertTrue(this.validator.isValid(1));
        try{
            this.validator.getConstraintDescription();
            fail("Expected smartvalidation.exception with message 'No constraint violations have occured' to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "No constraint violations have occured");
        }
        assertFalse(this.validator.isValid(3));
    }
    
    @Ignore
    @Test
    public void testGetConstraintViolationMessageWithGreaterThanConstraintViolation() {   
        assertFalse(this.validator.isValid(2));
        assertEquals(this.validator.getConstraintDescription().getConstraintFullName(), "validation.constraintViolation.lessThan.Integer");
        assertEquals(this.validator.getConstraintDescription().getConstraintParameters()[0], "2");
    }
    @Ignore
    @Test
    public void testGetConstraintViolationMessageWithLessThanConstraintViolation() {   
        assertFalse(this.validator.isValid(4));
        assertEquals(this.validator.getConstraintDescription().getConstraintFullName(), "validation.constraintViolation.greaterThan.Integer");
        assertEquals(this.validator.getConstraintDescription().getConstraintParameters()[0], "4");
    }

}
