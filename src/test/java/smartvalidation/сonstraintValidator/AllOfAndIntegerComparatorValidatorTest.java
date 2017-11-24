/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import smartvalidation.exception.ConstraintValidationException;
import static smartvalidation.validator.сonstraintValidator.AllOfValidator.AllOf;

import smartvalidation.validator.сonstraintValidator.ComparatorValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

/**
 *
 * @author SuslovAI
 */
public class AllOfAndIntegerComparatorValidatorTest {
    
    private ConstraintValidator<Integer> validator;
    
    @Before
    public void setUp() {
        this.validator=AllOf(ComparatorValidator.greaterThan(2),ComparatorValidator.lessThan(4));
    }

    @Test
    public void testIsValid() {
        assertTrue(this.validator.isValid(3));
        assertFalse(this.validator.isValid(1));
        assertFalse(this.validator.isValid(5));
    }

    @Test
    public void testGetConstraintViolationMessageWithoutConstraintViolations(){   
        try{
            this.validator.getConstraintDescription();
            fail("Expected smartvalidation.exception with message 'No constraint violations have occured' to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "No constraint violations have occured");
        }
        assertTrue(this.validator.isValid(3));
        try{
            this.validator.getConstraintDescription();
            fail("Expected smartvalidation.exception with message 'No constraint violations have occured' to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "No constraint violations have occured");
        }
    }
    
    @Test
    public void testGetConstraintViolationMessageWithGreaterThanConstraintViolation() {   
        assertFalse(this.validator.isValid(1));
        assertEquals(this.validator.getConstraintDescription().getConstraintFullName(), "validation.constraintViolation.greaterThan.Integer");
        assertEquals(this.validator.getConstraintDescription().getConstraintParameters()[0], "2");
    }
    
    @Test
    public void testGetConstraintViolationMessageWithLessThanConstraintViolation() {   
        assertFalse(this.validator.isValid(5));
        assertEquals(this.validator.getConstraintDescription().getConstraintFullName(), "validation.constraintViolation.lessThan.Integer");
        assertEquals(this.validator.getConstraintDescription().getConstraintParameters()[0], "4");
    }

}
