/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartvalidation.transformator;

/**
 *
 * @author SuslovAI
 */
public class PathTransformationRule {
    private String pathPrefixForReplace;
    private String replacement;

    public PathTransformationRule(String pathPrefixForReplace, String replacement) {
        this.pathPrefixForReplace = pathPrefixForReplace;
        this.replacement = replacement;
    }

    public String getPathPrefixForReplace() {
        return pathPrefixForReplace;
    }

    public String getReplacement() {
        return replacement;
    }
}
