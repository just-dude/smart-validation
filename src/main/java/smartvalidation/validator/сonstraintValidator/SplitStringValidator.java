/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.сonstraintValidator;

import org.apache.commons.lang3.StringUtils;
import smartvalidation.constraintDescription.ConstraintDescription;
import smartvalidation.constraintDescription.PartsOfWholeSupportedConstraintDescription;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;
import smartvalidation.validator.сonstraintValidator.base.UsesConstraintNameNullSafeValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.split;


/**
 *
 * @author SuslovAI
 */
public class SplitStringValidator implements ConstraintValidator<String>{

    private final ConstraintValidator<String> validator;
    private String separator;
    private Map<String,ConstraintDescription> constraintDescriptions;

    public SplitStringValidator(String separator, ConstraintValidator<String> validator) {
        if(validator==null){
            throw new ConstraintValidationException("Argument 'validator' is null");
        }
        this.validator = validator;
        this.separator=separator;
    }
    
    @Override
    public boolean isValid(String actual) throws ConstraintValidationException {
        boolean isValid=true;
        clearConstraintDescription();
        String[] actualStringParts=StringUtils.split(actual,separator);
        if(actualStringParts.length==0){
            return validator.isValid("");
        }
        int i=0;
        for(String part:actualStringParts){
            if(!validator.isValid(part)){
                isValid=false;
                addConstraintDescription("["+i+"]",validator.getConstraintDescription());
            }
            i++;
        }
        return isValid;
    }

    @Override
    public ConstraintDescription getConstraintDescription() {
        return new PartsOfWholeSupportedConstraintDescription(UsesConstraintNameNullSafeValidator.CONSTRAINT_NAME_BASIS+".splitString",
                new String[]{},constraintDescriptions);
    }

    private void addConstraintDescription(String partName,ConstraintDescription cd){
        if(constraintDescriptions==null){
            constraintDescriptions=new HashMap<>();
        }
        constraintDescriptions.put(partName,cd);
    }

    private void clearConstraintDescription(){
        if(constraintDescriptions!=null){
            constraintDescriptions.clear();
        }
    }
    
    
    public static ConstraintValidator<String> splitString(String separator, ConstraintValidator<String> validator){
        return new SplitStringValidator(separator,validator);
    }
    
    
    
}
