package smartvalidation.constraintDescription;

import java.util.*;

/**
 * Created by Артем on 19.12.2017.
 */
public class PartsOfWholeSupportedConstraintDescription extends ConstraintDescription {

    protected Map<String,ConstraintDescription> partNameToConstraintDesciptionMap;

    public PartsOfWholeSupportedConstraintDescription(String constraintName, String[] constraintParameters) {
        super(constraintName, constraintParameters);
    }

    public PartsOfWholeSupportedConstraintDescription(String constraintName) {
        super(constraintName);
    }

    public PartsOfWholeSupportedConstraintDescription(String constraintName, String[] constraintParameters, Map<String,ConstraintDescription> partNameToConstraintDesciptionMap) {
        super(constraintName, constraintParameters);
        this.partNameToConstraintDesciptionMap = partNameToConstraintDesciptionMap;
    }

    public PartsOfWholeSupportedConstraintDescription(String constraintName, Map<String,ConstraintDescription> partNameToConstraintDesciptionMap) {
        super(constraintName);
        this.partNameToConstraintDesciptionMap = partNameToConstraintDesciptionMap;
    }

    public Map<String,ConstraintDescription> getPartNameToConstraintDesciptionMap() {
        return partNameToConstraintDesciptionMap;
    }

    public void setPartNameToConstraintDesciptionMap(Map<String,ConstraintDescription> partNameToConstraintDesciptionMap) {
        this.partNameToConstraintDesciptionMap = partNameToConstraintDesciptionMap;
    }

    public void addSubConstraintDesciption(String partName,ConstraintDescription subConstraintDesciption) {
        if(this.partNameToConstraintDesciptionMap ==null){
            this.partNameToConstraintDesciptionMap =new HashMap<>();
        }
        this.partNameToConstraintDesciptionMap.put(partName,subConstraintDesciption);
    }

    @Override
    public String toString() {
        return "PartsOfWholeSupportedConstraintDescription{" +
                "constraintFullName=" + constraintFullName + ", constraintParameters=" +
                Arrays.toString(constraintParameters) +
                "partNameToConstraintDesciptionMap=" + partNameToConstraintDesciptionMap +
                '}';
    }
}
