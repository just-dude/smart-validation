package smartvalidation.constraintDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Артем on 19.12.2017.
 */
public class ConstraintDescriptionWithSubConstraintDescriptions extends ConstraintDescription {

    protected List<ConstraintDescription> subConstraintDesciptions;

    public ConstraintDescriptionWithSubConstraintDescriptions(String constraintName, String[] constraintParameters) {
        super(constraintName, constraintParameters);
    }

    public ConstraintDescriptionWithSubConstraintDescriptions(String constraintName) {
        super(constraintName);
    }

    public ConstraintDescriptionWithSubConstraintDescriptions(String constraintName, String[] constraintParameters, List<ConstraintDescription> subConstraintDesciptions) {
        super(constraintName, constraintParameters);
        this.subConstraintDesciptions = subConstraintDesciptions;
    }

    public ConstraintDescriptionWithSubConstraintDescriptions(String constraintName, List<ConstraintDescription> subConstraintDesciptions) {
        super(constraintName);
        this.subConstraintDesciptions = subConstraintDesciptions;
    }

    public List<ConstraintDescription> getSubConstraintDesciptions() {
        return subConstraintDesciptions;
    }

    public void setSubConstraintDesciptions(List<ConstraintDescription> subConstraintDesciptions) {
        this.subConstraintDesciptions = subConstraintDesciptions;
    }

    public void addSubConstraintDesciption(ConstraintDescription subConstraintDesciption) {
        if(this.subConstraintDesciptions==null){
            this.subConstraintDesciptions=new ArrayList<>();
        }
        this.subConstraintDesciptions.add(subConstraintDesciption);
    }

    @Override
    public String toString() {
        return "ConstraintDescriptionWithSubConstraintDescriptions{" +
                "constraintFullName=" + constraintFullName + ", constraintParameters=" +
                Arrays.toString(constraintParameters) +
                "subConstraintDesciptions=" + subConstraintDesciptions +
                '}';
    }
}
