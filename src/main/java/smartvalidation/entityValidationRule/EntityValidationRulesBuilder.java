package smartvalidation.entityValidationRule;

import smartvalidation.validator.entityValidator.ValidationContext;
import smartvalidation.validator.сonstraintValidator.base.ConstraintValidator;

import java.util.ArrayList;
import java.util.List;

public class EntityValidationRulesBuilder {

    List<EntityValidationRule> entityValidationRules=new ArrayList<>();

    private ValidationContext validationContext;

    public EntityValidationRulesBuilder(ValidationContext validationContext) {
        this.validationContext = validationContext;
    }

    public void addRule(String propertyName, Object propertyValue, ConstraintValidator propertyValidator){
        entityValidationRules.add(new EntityValidationRule(validationContext.getFullPropertyName(propertyName),propertyValue,propertyValidator));
    }

    public List<EntityValidationRule> build(){
        return entityValidationRules;
    }
}
