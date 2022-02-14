package soBadWithNames.customType;

import io.cucumber.java.DataTableType;
import soBadWithNames.domainObjects.billingDetails;

import java.util.Map;

public class customDataTableType {

    @DataTableType
    public billingDetails billingDetailsEntry(Map<String, String> entry){
        return new billingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
