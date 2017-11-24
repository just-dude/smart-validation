/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.constraintViolation;
import java.util.*; 

public interface ConstraintViolationMessagesProvider {
    
    public List<ConstraintViolationMessage> getConstraintViolationMessages();
    
    public boolean hasConstraintViolationMessages();
    
}
