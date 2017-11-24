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
import java.util.regex.*;

/**
 *
 * @author SuslovAI
 */
public class StringMatchesRegularExpressionValidatorTest{
    
    private ConstraintValidator<String> validator;

    @Before
    public void setUp(){
        this.validator = StringMatchesRegularExpressionValidator.matchesRegularExpression("[a-z]","isMatchToMyRegularExpression");
    }
    
    @Test
    public void testIsValid() {        
        assertTrue(validator.isValid("a"));
        assertTrue(validator.isValid("b"));
        assertTrue(validator.isValid("z"));
        assertFalse(validator.isValid(" a "));
        assertFalse(validator.isValid("B"));
        assertFalse(validator.isValid("1"));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertThat(validator.getConstraintDescription().getConstraintFullName(),is("validation.constraintViolation.isMatchToMyRegularExpression"));
    }
    
    @Test
    public void testComparatorInvalidPatternStringInitializationValueThrowingException(){
        try{
            validator=StringMatchesRegularExpressionValidator.matchesRegularExpression("\\");
            fail("Expected an ConstraintValidatorException with message \"Invalid pattern string\" to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Invalid pattern string");
        }
    }
    
    @Test
    public void testComparatorNullPatternInitializationValueThrowingException(){
        try{
            validator=StringMatchesRegularExpressionValidator.matchesRegularExpression((Pattern)null);
            fail("Expected an ConstraintValidatorException with message \"Argument 'pattern' is null\"to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Argument 'pattern' is null");
        }
    }
    
    @Test
    public void testComparatorNullStringInitializationValueThrowingException(){
        try{
            validator=StringMatchesRegularExpressionValidator.matchesRegularExpression((String)null);
            fail("Expected an ConstraintValidatorException with message \"Argument 'patternString' is null\"to be thrown");
        } catch(ConstraintValidationException e){
            assertEquals(e.getMessage(), "Argument 'patternString' is null");
        }
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
