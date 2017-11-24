/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator;

import smartvalidation.validator.сonstraintValidator.NotValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import smartvalidation.сonstraintValidator.stub.*;
/**
 *
 * @author SuslovAI
 */
public class NotValidatorTest {
    
    ConstraintValidator alwaysValidator ;
    ConstraintValidator notValidator;
    ConstraintValidator doubleNotValidator;
    
    @Before
    public void setUp(){
        this.alwaysValidator = AlwaysValidator.always();
        this.notValidator = NotValidator.not(alwaysValidator);
        this.doubleNotValidator= NotValidator.not(notValidator);
    }

    @Test
    public void testIsValid() {
        assertTrue(alwaysValidator.isValid(""));
        assertFalse(notValidator.isValid(""));
        assertTrue(doubleNotValidator.isValid(""));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertEquals(alwaysValidator.getConstraintDescription().getConstraintFullName(),"validation.constraintViolation.always");
        assertEquals(notValidator.getConstraintDescription().getConstraintFullName(),"validation.constraintViolation.not.always");
        assertEquals(doubleNotValidator.getConstraintDescription().getConstraintFullName(),"validation.constraintViolation.always");
    }

}
