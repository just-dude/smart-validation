/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintViolation;

import smartvalidation.constraintDescription.ConstraintDescription;

/**
 *
 * @author SuslovAI
 */
public class EntityConstraintViolation<T> extends ConstraintViolation<T>{
    
    protected String  entityName;

    public EntityConstraintViolation(ConstraintDescription constraint, String entityName) {
        super(constraint);
        this.entityName=entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    

    @Override
    public String toString() {
        return "EntityConstraintViolation{" + "entityName=" + entityName + ", smartvalidation.constraintDescription=" + constraintDescription + '}';
    }
    
    
    
}
