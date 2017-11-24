/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintViolation;


/**
 *
 * @author SuslovAI
 */
public class ConstraintViolationMessage {
    
    private String constraintName;
    
    private String[] constraintParameters;

    public ConstraintViolationMessage(String constraintName, String[] constraintParameters) {
        this.constraintName = constraintName;
        this.constraintParameters = constraintParameters;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public String[] getConstraintParameters() {
        return constraintParameters;
    }
    
    
    
}
