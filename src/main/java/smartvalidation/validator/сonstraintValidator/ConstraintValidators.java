/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import java.util.Collection;
import java.util.regex.Pattern;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

/**
 *
 * @author SuslovAI
 */
public class ConstraintValidators {
    
    public static <T> ConstraintValidator<? extends T> AllOf(Collection<ConstraintValidator<? super T>> validators){
        return AllOfValidator.AllOf(validators);
    }
    
    public static <T> ConstraintValidator<? extends T> AllOf(ConstraintValidator<? super T>... validators){
        return AllOfValidator.AllOf(validators);
    }
    
    public static <T> ConstraintValidator<? extends T> OneOf(Collection<ConstraintValidator<? super T>> validators){
        return OneOfValidator.OneOf(validators);
    }
    
    public static <T> ConstraintValidator<? extends T> OneOf(ConstraintValidator<? super T>... validators){
        return OneOfValidator.OneOf(validators);
    }
    
    public static <T> ConstraintValidator<T> not(ConstraintValidator<T> validator){
        return NotValidator.not(validator);
    }
    
    public static <T> ConstraintValidator<T> isNull(){
        return NullValidator.isNull();
    }
    
    public static <T> ConstraintValidator<T> containsNull(){
        return ContainsNullValidator.containsNull();
    }
    
    public static <T extends Comparable> ConstraintValidator<T> equalTo(T actual){
        return ComparatorValidator.equalTo(actual);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> greaterThan(T actual){
        return ComparatorValidator.greaterThan(actual);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> greaterThanOrEqualTo(T actual){
        return ComparatorValidator.greaterThanOrEqualTo(actual);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> lessThan(T actual){
        return ComparatorValidator.lessThan(actual);
    }
    
    public static <T extends Comparable> ConstraintValidator<T> lessThanOrEqualTo(T actual){
        return ComparatorValidator.lessThanOrEqualTo(actual);
    }
    
    public static ConstraintValidator<String> emptyString(){
        return EmptyStringValidator.emptyString();
    }
    
    public static ConstraintValidator<String> blankString(){
        return BlankStringValidator.blankString();
    }
    
    public static ConstraintValidator<String> stringLength(ConstraintValidator<Integer> validator){
        return StringLengthValidator.stringLength(validator);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(Pattern pattern){
        return StringMatchesRegularExpressionValidator.matchesRegularExpression(pattern);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(Pattern pattern,String constraintName){
        return StringMatchesRegularExpressionValidator.matchesRegularExpression(pattern,constraintName);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(String patternString){
        return StringMatchesRegularExpressionValidator.matchesRegularExpression(patternString);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(String patternString,String constraintName){
        return StringMatchesRegularExpressionValidator.matchesRegularExpression(patternString,constraintName);
    }
}
