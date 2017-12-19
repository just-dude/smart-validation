/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator;

import org.junit.Test;
import smartvalidation.validator.сonstraintValidator.ConstraintValidators;
import smartvalidation.validator.сonstraintValidator.NullValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class CollectionSizeValidatorTest {

    private final ConstraintValidator validator;

    public CollectionSizeValidatorTest() {
        List<Integer> numbers=new ArrayList<>();
        this.validator= ConstraintValidators.collectionSize(ConstraintValidators.lessThan(2));
    }

    @Test
    public void testIsValid() {
        List<Integer> numbers=new ArrayList<>();
        assertTrue(validator.isValid(numbers));
        numbers.add(1);
        assertTrue(validator.isValid(numbers));
        numbers.add(2);
        assertFalse(validator.isValid(numbers));
        numbers.add(3);
        assertFalse(validator.isValid(numbers));
    }

    @Test
    public void testGetConstraintViolationMessage() {
        assertThat(validator.getConstraintDescription().getConstraintFullName(),is("validation.constraintViolation.lessThan.Integer.size"));
    }

    @Test
    public void testIsNull() {
    }
    

    
}
