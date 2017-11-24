/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintDescription;

import java.util.Arrays;
import java.util.Objects;



public class ConstraintDescription {
    
    private String constraintFullName;
    
    private String[] constraintParameters;

    public ConstraintDescription(String constraintName, String[] constraintParameters) {
        this.constraintFullName = constraintName;
        this.constraintParameters = constraintParameters;
    }
    
    public ConstraintDescription(String constraintName) {
        this(constraintName,new String[]{});
    }

    public void setConstraintFullName(String constraintFullName) {
        this.constraintFullName = constraintFullName;
    }

    public void setConstraintParameters(String[] constraintParameters) {
        this.constraintParameters = constraintParameters;
    }

    public String getConstraintFullName() {
        return constraintFullName;
    }

    public String[] getConstraintParameters() {
        return constraintParameters;
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
        final ConstraintDescription other = (ConstraintDescription) obj;
        if (!Objects.equals(this.constraintFullName, other.constraintFullName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.constraintParameters, other.constraintParameters)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConstraintDescription{" + "constraintFullName=" + constraintFullName + ", constraintParameters=" + Arrays.toString(constraintParameters) + '}';
    }
    
    
    
    
    
}
