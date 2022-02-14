package soBadWithNames.customType;

import io.cucumber.java.ParameterType;
import soBadWithNames.domainObjects.product;

public class customParameterType {

    @ParameterType(".*")
    public product product(String name){
        return new product(name.replace("\"",""));
    }
}
