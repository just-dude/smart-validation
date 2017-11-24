/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.сonstraintValidator.integerComparator;

/**
 *
 * @author SuslovAI
 */
public class ValidatorParamsProvider {
    
    public static class ComparatorValidatorIsValidParametersProvider{
        public static Object[] provideIsValidParameters() {
            return new Object[]{
                     new Object[]{ "equalTo", 1, 1, true },
                     new Object[]{ "equalTo", 1, 2, false },
                     new Object[]{ "equalTo", 2, 1, false },
                     new Object[]{ "greaterThan", 1, 1, false },
                     new Object[]{ "greaterThan", 1, 2, true },
                     new Object[]{ "greaterThan", 2, 1, false },
                     new Object[]{ "greaterThanOrEqualTo", 1, 1, true },
                     new Object[]{ "greaterThanOrEqualTo", 1, 2, true },
                     new Object[]{ "greaterThanOrEqualTo", 2, 1, false },
                     new Object[]{ "lessThan", 1, 1, false },
                     new Object[]{ "lessThan", 1, 2, false },
                     new Object[]{ "lessThan", 2, 1, true },
                     new Object[]{ "lessThanOrEqualTo", 1, 1, true },
                     new Object[]{ "lessThanOrEqualTo", 1, 2, false },
                     new Object[]{ "lessThanOrEqualTo", 2, 1, true }
                };
        }       
        
    }
    
    public static class ComparatorValidatorGetConstraintViolationMessageParametersProvider{
        public static Object[] provideGetConstraintViolationMessageParameters() {
            return new Object[]{
                     new Object[]{ "equalTo", 1, "validation.constraintViolation.equalTo.Integer" },
                     new Object[]{ "greaterThan", 1, "validation.constraintViolation.greaterThan.Integer" },
                     new Object[]{ "greaterThanOrEqualTo", 1, "validation.constraintViolation.greaterThanOrEqualTo.Integer" },
                     new Object[]{ "lessThan", 1, "validation.constraintViolation.lessThan.Integer" },
                     new Object[]{ "lessThanOrEqualTo",  1, "validation.constraintViolation.lessThanOrEqualTo.Integer" }
                     
                };
        }
    }
    
    
    
}
