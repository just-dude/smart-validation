/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.entityValidationRule;

import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

/**
 *
 * @author SuslovAI
 */
public class EntityValidationRule {
    
    private String propertyName;
    private Object propertyValue;
    private ConstraintValidator propertyValidator;

    public EntityValidationRule(String propertyName, Object propertyValue, ConstraintValidator propertyValidator) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.propertyValidator = propertyValidator;
    }
    
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
        this.propertyValue = propertyValue;
    }

    public ConstraintValidator getPropertyValidator() {
        return propertyValidator;
    }

    public void setPropertyValidator(ConstraintValidator propertyValidator) {
        this.propertyValidator = propertyValidator;
    }
    
    
}
