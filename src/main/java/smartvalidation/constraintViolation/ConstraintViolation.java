/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintViolation;

import smartvalidation.constraintDescription.ConstraintDescription;

public abstract class ConstraintViolation<T> {
    
    protected ConstraintDescription constraintDescription;

    public ConstraintViolation(ConstraintDescription constraint) {
        this.constraintDescription = constraint;
    }
    
    public ConstraintDescription getConstraintDescription() {
        return constraintDescription;
    }

    public void setConstraintDescription(ConstraintDescription constraintDescription) {
        this.constraintDescription = constraintDescription;
    }    
    
}
