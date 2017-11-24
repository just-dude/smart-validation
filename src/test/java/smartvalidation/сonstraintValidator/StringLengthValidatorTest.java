/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

/**
 *
 * @author SuslovAI
 */
public class StringLengthValidatorTest {
    
    
    private ConstraintValidator<String> validator;
    
    @Before
    public void setUp(){
        this.validator=StringLengthValidator.stringLength(ComparatorValidator.equalTo(2));
    }

    @Test
    public void testIsValid() {
        assertTrue(this.validator.isValid("ab"));
        assertTrue(this.validator.isValid("  "));
        assertFalse(this.validator.isValid("abc"));
        assertFalse(this.validator.isValid(" "));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertEquals(this.validator.getConstraintDescription().getConstraintFullName(), "validation.constraintViolation.equalTo.Integer.length");
        assertEquals(this.validator.getConstraintDescription().getConstraintParameters()[0], "2");
    }
    
}
