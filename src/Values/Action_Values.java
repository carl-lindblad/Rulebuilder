package Values;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Action_Values {

    public static final String ACTION_TYPE = "KYC";
    public static final String COUNTRY_OF_BIRTH = "birthCountry";
    public static final String  ADRESS_FOR_NEW_BANK_CUSTOMER= "AddressForNewBankCustomer";
    public static final String  PLACE_OF_BIRTH= "birthPlace";
    public static final String  EMAIL= "email";
    public static final String  FIRSTNAME= "firstname";
    public static final String  LASTNAME= "lastname";
    public static final String  MOBILEPHONE= "mobilePhone";
    public static final String  SECTOR_CODE= "sectorCode";
    public static final String  TAX_CODE= "taxCode";
    public static final String  DATE_OF_BIRTH= "DateOfBirth";
    public static final String  REMOTE_CUSTOMER= "remoteCustomer";
    public static final String  DECEASED= "Deceased";
    public static final String  COMPANY= "company";



    public static final Map<String, String> PARAMETERS = new HashMap<String, String>() {{
        put("birthCountry", "READ");
        put("citizenship", "READ");
    }};
    public static final Map<String, String>  MESSAGE_PARAMETERS = new HashMap<String, String>() {{
        put("LEVEL", "WARNING");
        put("TEXT", "KYC information required.");
    }};

}











