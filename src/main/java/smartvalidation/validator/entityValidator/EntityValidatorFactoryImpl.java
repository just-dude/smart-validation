package smartvalidation.validator.entityValidator;

import smartvalidation.entityValidationRule.EntityValidationRule;
import smartvalidation.entityValidationRule.EntityValidationRulesBuilder;
import smartvalidation.exception.EntityValidationException;

import java.util.List;

public class EntityValidatorFactoryImpl<T> implements EntityValidatorFactory<T> {

    protected ValidationContext validationContext;

    public EntityValidatorFactoryImpl(ValidationContext validationContext) {
        this.validationContext=validationContext;
    }

    @Override
    public EntityValidator getValidator(T entity) throws EntityValidationException {
        try {
            EntityValidationRulesBuilder rulesBuilder=new EntityValidationRulesBuilder(validationContext);
            fillValidationRulesBuilder(rulesBuilder,entity);
            return new SimpleEntityValidator(rulesBuilder.build());
        } catch (Exception e) {
            throw new EntityValidationException("Entity validator initialization exception have occured", e);
        }
    }

    protected void fillValidationRulesBuilder(EntityValidationRulesBuilder rulesBuilder, T entity){};

}
