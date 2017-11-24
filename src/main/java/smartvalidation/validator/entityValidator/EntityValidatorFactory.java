/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.validator.entityValidator;

/**
 *
 * @author SuslovAI
 */
public interface EntityValidatorFactory<EntityType> {
    
    public  EntityValidator getValidator(EntityType entity);
    
}
