/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;


import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;


public class StringMatchesRegularExpressionValidator extends UsesConstraintNameNullSafeValidator<String>{
    
    private Pattern pattern;

    public StringMatchesRegularExpressionValidator(Pattern pattern) {
        this(pattern,"isMatchToRegularExpression");
    }
    
    public StringMatchesRegularExpressionValidator(Pattern pattern, String constraintName) {
        super(constraintName);
        if(pattern==null){
            throw new ConstraintValidationException("Argument 'pattern' is null");
        }
        this.pattern = pattern;
    }
    
    public StringMatchesRegularExpressionValidator(String patternString) throws ConstraintValidationException {
        this(patternString,"isMatchToRegularExpression");       
    }
    
    public StringMatchesRegularExpressionValidator(String patternString, String constraintName) throws ConstraintValidationException {
        super(constraintName);
        if(patternString==null){
            throw new ConstraintValidationException("Argument 'patternString' is null");
        }        
        try{         
            this.pattern = Pattern.compile(patternString);
        }
        catch(PatternSyntaxException e){
            throw new ConstraintValidationException("Invalid pattern string",e);
        }        
    }

    @Override
    public boolean isNullSafeValid(String actual) throws ConstraintValidationException {
        Matcher matcher = pattern.matcher(actual);
        return (matcher.matches());
    }    
    
    public static ConstraintValidator<String> matchesRegularExpression(Pattern pattern){
        return new StringMatchesRegularExpressionValidator(pattern);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(Pattern pattern,String constraintName){
        return new StringMatchesRegularExpressionValidator(pattern,constraintName);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(String patternString){
        return new StringMatchesRegularExpressionValidator(patternString);
    }
    
    public static ConstraintValidator<String> matchesRegularExpression(String patternString,String constraintName){
        return new StringMatchesRegularExpressionValidator(patternString,constraintName);
    }
    
}
