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
public class ValidationContext {
    private String propertiesPrefix;

    public ValidationContext(String propertiesPrefix) {
        this.propertiesPrefix = propertiesPrefix;
    }

    public String getPropertiesPrefix() {
        return propertiesPrefix;
    }    
}
