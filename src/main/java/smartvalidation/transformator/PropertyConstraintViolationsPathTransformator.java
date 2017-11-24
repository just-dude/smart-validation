/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.transformator;

import java.util.List;
import smartvalidation.constraintViolation.PropertyConstraintViolation;

/**
 *
 * @author SuslovAI
 */
public class PropertyConstraintViolationsPathTransformator {
    
    private List<PathTransformationRule>  transformationRules;
    
    public PropertyConstraintViolationsPathTransformator(List<PathTransformationRule>  transformationRules) {
        this.transformationRules = transformationRules;
    }
    
    public void transform(List<PropertyConstraintViolation> violations){
        for(PropertyConstraintViolation violation : violations){
            for(PathTransformationRule rule: transformationRules){
                if(violation.getPropertyPath().startsWith(rule.getPathPrefixForReplace())){
                    violation.setPropertyPath(
                            violation.getPropertyPath().replaceFirst(rule.getPathPrefixForReplace(), rule.getReplacement())
                    );
                    break;
                }
            }   
        }
    }
    
    
    
}
