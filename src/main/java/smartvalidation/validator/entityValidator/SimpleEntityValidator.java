/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.entityValidator;

import java.util.ArrayList;
import java.util.List;

import smartvalidation.constraintViolation.ConstraintViolation;
import smartvalidation.constraintViolation.PropertyConstraintViolation;
import smartvalidation.entityValidationRule.EntityValidationRule;
import smartvalidation.exception.ConstraintValidationException;
import smartvalidation.exception.EntityValidationException;

public class SimpleEntityValidator implements EntityValidator{

    private final List<ConstraintViolation> constraintViolations = new ArrayList();
    private List<EntityValidationRule> entityValidationRules = new ArrayList();

    public SimpleEntityValidator(List<EntityValidationRule> entityValidationEntries) {
        this.entityValidationRules=entityValidationEntries;
    }


    public boolean isValid() throws EntityValidationException {
        try{
            
            for(EntityValidationRule rule: entityValidationRules) {
                if(!rule.getPropertyValidator().isValid(rule.getPropertyValue())){
                    constraintViolations.add(new PropertyConstraintViolation(
                            rule.getPropertyValidator().getConstraintDescription(),
                            rule.getPropertyName(),
                            rule.getPropertyValue()));
                }
            }
        }catch(Exception e){
            throw new EntityValidationException("Constraint smartvalidation.exception have occured",e);
        }
        return constraintViolations.isEmpty();
    }


    public List<ConstraintViolation> getConstraintViolations() throws EntityValidationException{
        if(constraintViolations!=null && !constraintViolations.isEmpty()){
            return constraintViolations;
        }
        else{
            throw new ConstraintValidationException("No constraint violations have occured");
        }            
    }
}
