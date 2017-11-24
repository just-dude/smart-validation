/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;


import java.util.Comparator;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;


/**
 *
 * @author SuslovAI
 */
public class ComparatorValidator<T extends Comparable<T>> extends UsesConstraintNameNullSafeValidator<T>{
    
    protected static final int LESS_THAN = -1;
    protected static final int GREATER_THAN = 1;
    protected static final int EQUAL = 0;
    
    private final Comparator comparator;
    private final T expected;
    private final int minCompareValue;
    private final int maxCompareValue;

    public ComparatorValidator(T expected, String constraintName, Comparator comparator, int minCompareValue, int maxCompareValue) {
        super(constraintName);
        if(expected==null){
            throw new ConstraintValidationException("Argument 'expected' is null");
        }
        if(comparator==null){
            throw new ConstraintValidationException("Argument 'comparator' is null");
        }
        this.comparator = comparator;
        this.expected = expected;
        this.minCompareValue = minCompareValue;
        this.maxCompareValue = maxCompareValue;
    }
        
    @Override
    public boolean isNullSafeValid(T actual) {
        try {
            int compare = Integer.signum(comparator.compare(actual, expected));
            return this.minCompareValue <= compare && compare <= this.maxCompareValue;
        } catch (ClassCastException e) {
            return false;
        }
    }
    
    @Override
    public ConstraintDescription getConstraintDescription() {
        return new ConstraintDescription("validation.constraintViolation."+constraintName+"."+expected.getClass().getSimpleName(), new String[]{expected.toString()});
    }
    
    
    
    
    public static <T extends Comparable> ConstraintValidator<T> equalTo(T actual){
        return new ComparatorValidator(actual,"equalTo",NaturalOrderComparator.INSTANCE,ComparatorValidator.EQUAL,ComparatorValidator.EQUAL);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> greaterThan(T actual){
        return new ComparatorValidator(actual,"greaterThan",NaturalOrderComparator.INSTANCE,ComparatorValidator.GREATER_THAN,ComparatorValidator.GREATER_THAN);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> greaterThanOrEqualTo(T actual){
        return new ComparatorValidator(actual,"greaterThanOrEqualTo",NaturalOrderComparator.INSTANCE,ComparatorValidator.EQUAL,ComparatorValidator.GREATER_THAN);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> lessThan(T actual){
        return new ComparatorValidator(actual,"lessThan",NaturalOrderComparator.INSTANCE,ComparatorValidator.LESS_THAN,ComparatorValidator.LESS_THAN);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> lessThanOrEqualTo(T actual){
        return new ComparatorValidator(actual,"lessThanOrEqualTo",NaturalOrderComparator.INSTANCE,ComparatorValidator.LESS_THAN,ComparatorValidator.EQUAL);
    }



    public static class NaturalOrderComparator<T extends Comparable<T>> implements Comparator<T> {

        public static Comparator INSTANCE = new NaturalOrderComparator();

        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }

    }
    
}
