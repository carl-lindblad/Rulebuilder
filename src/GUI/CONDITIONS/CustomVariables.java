package GUI.CONDITIONS;

import java.util.HashMap;
import java.util.Map;

public class CustomVariables {
    Map<String, String> customerVariables = new HashMap<>();
    Map<String, String> engagementVariables = new HashMap<>();
    Map<String, String> sessionVariables = new HashMap<>();


    public Map<String, String> getVariables(String variableType) {
        switch (variableType){
            case "customer":
                populateCustomerVariables();
                return customerVariables;
            case "engagement":
                populateEngagementVariables();
                return engagementVariables;
            case "session":
                populateSessionVariables();
                return sessionVariables;
        }

        return customerVariables;
    }
    private void populateCustomerVariables(){
        this.customerVariables.put("hasAnyBirthCountry('XY',...)", "int");
        this.customerVariables.put("amlStatus", "String");
        this.customerVariables.put("hasAnyAddressCountry('XY',...)", "Boolean");
        this.customerVariables.put("deceased", "Boolean");
        this.customerVariables.put("pep", "Boolean");
        this.customerVariables.put("protectedIdentity", "String");
        this.customerVariables.put("hasCitizenship('','',...)", "String");
        this.customerVariables.put("hasAnyCurrentIdCountryOfIssue('',''...)", "String");
        this.customerVariables.put("hasAnyIdCountryOfIssue('',''...)", "String");
        this.customerVariables.put("getCurrentIdType()", "String");
        this.customerVariables.put("hasIdType('','',...)", "ENUM");
        this.customerVariables.put("getType()", "ENUM");
        this.customerVariables.put("sex", "String");
        this.customerVariables.put("birthPlace", "String");
        this.customerVariables.put("email", "string");
        this.customerVariables.put("homePhone", "string");
        this.customerVariables.put("employee", "Boolean");
        this.customerVariables.put("remoteCustomer", "Boolean");
        this.customerVariables.put("mobilePhone", "String");
        this.customerVariables.put("contractedCustomer", "Boolean");
        this.customerVariables.put("createdToday", "Boolean");
        this.customerVariables.put("RiskClass", "String");
    }
    private void populateEngagementVariables() {
        this.engagementVariables.put("hasFPMCNumber()", "String");
        this.engagementVariables.put("bankCustomer", "Boolean");
        this.engagementVariables.put("customerSessionCounter", "Integer");
        this.engagementVariables.put("aggregatedPKYCstatus", "String");
    }
    private void populateSessionVariables() {
        this.sessionVariables.put("total", "Integer");
        this.sessionVariables.put("total('XYZ')", "Integer");
        this.sessionVariables.put("transactions['WXYZ'].amountLC", "Integer");
        this.sessionVariables.put("transactions['WXYZ'].amount('XYZ')", "Integer");
        this.sessionVariables.put("isOnlyReversalsAndCashTransactions()", "Boolean");
        this.sessionVariables.put("transactions['WXYZ'].exists", "Boolean");
    }

    }
