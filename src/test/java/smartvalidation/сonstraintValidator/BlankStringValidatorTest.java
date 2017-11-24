/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import static org.hamcrest.CoreMatchers.is;
import smartvalidation.exception.ConstraintValidationException;

/**
 *
 * @author SuslovAI
 */
public class BlankStringValidatorTest{
    
    private ConstraintValidator<String> validator;

    @Before
    public void setUp(){
        this.validator = BlankStringValidator.blankString();
    }
    
    @Test
    public void testIsValid() {        
        assertTrue(validator.isValid(""));
        assertTrue(validator.isValid(" "));
        assertTrue(validator.isValid("              "));
        assertFalse(validator.isValid("1"));
        assertFalse(validator.isValid(" 1 "));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertThat(validator.getConstraintDescription().getConstraintFullName(),is("validation.constraintViolation.blankString"));
    }
    
    @Test
    public void testValidatingNullValueThrowingxception(){
        try{
            validator.isValid(null);
            fail("Expected an ConstraintValidatorException with message \"Validating value is null\"to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Validating value is null");
        }
    }
    
}
