package smartvalidation.сonstraintValidator;

import org.junit.Before;
import org.junit.Test;
import smartvalidation.constraintDescription.PartsOfWholeSupportedConstraintDescription;
import smartvalidation.validator.сonstraintValidator.ConstraintValidators;
import smartvalidation.validator.сonstraintValidator.StringMatchesRegularExpressionValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Артем on 19.12.2017.
 */
public class SplitStringValidatorTest {

    private final String separator=",";

    private ConstraintValidator<String> validator;

    @Before
    public void setUp(){
        this.validator = ConstraintValidators.split(separator,
                StringMatchesRegularExpressionValidator.matchesRegularExpression("[a-z ]*","isMatchToMyRegularExpression"));
    }

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid("artem,suslov"));
        assertTrue(validator.isValid("artem,suslov "));
        assertFalse(validator.isValid("artem1,suslov"));
        assertFalse(validator.isValid("artem,s2uslov"));
        assertTrue(validator.isValid(""));
        assertTrue(validator.isValid(","));
    }

    @Test
    public void getConstraintDescription() throws Exception {
        validator.isValid("artem,suslov");
        assertEquals("validation.constraintViolation.splitString",validator.getConstraintDescription().getConstraintFullName());
        assertTrue(validator.getConstraintDescription() instanceof PartsOfWholeSupportedConstraintDescription);
        validator.isValid("artem1,suslov");
        assertEquals("validation.constraintViolation.splitString",validator.getConstraintDescription().getConstraintFullName());
        assertEquals(1,((PartsOfWholeSupportedConstraintDescription)validator.getConstraintDescription()).getPartNameToConstraintDesciptionMap().size());
        assertEquals("validation.constraintViolation.isMatchToMyRegularExpression",((PartsOfWholeSupportedConstraintDescription)validator.getConstraintDescription()).getPartNameToConstraintDesciptionMap().values().iterator().next().getConstraintFullName());
    }

}