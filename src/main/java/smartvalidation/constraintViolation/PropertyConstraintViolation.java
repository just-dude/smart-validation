/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintViolation;

import java.util.Objects;
import smartvalidation.constraintDescription.ConstraintDescription;

/**
 *
 * @author SuslovAI
 */
public class PropertyConstraintViolation<T> extends ConstraintViolation<T>{
    
    protected String  propertyPath;
    protected T invalidValue;

    public PropertyConstraintViolation(ConstraintDescription constraint, String propertyPath, T invalidValue) {
        super(constraint);
        this.propertyPath = propertyPath;
        this.invalidValue = invalidValue;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    public T getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(T invalidValue) {
        this.invalidValue = invalidValue;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PropertyConstraintViolation<?> other = (PropertyConstraintViolation<?>) obj;
        if (!Objects.equals(this.propertyPath, other.propertyPath)) {
            return false;
        }
        if (!Objects.equals(this.invalidValue, other.invalidValue)) {
            return false;
        }
        if (!Objects.equals(this.constraintDescription, other.constraintDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PropertyConstraintViolation{" + "propertyPath=" + propertyPath + ", invalidValue=" + invalidValue + ", smartvalidation.constraintDescription=" + constraintDescription + '}';
    }
    
    
    
}
