package hello;

import JavaAPI.*;

public class NewTokenisationService {
    public static void tokenise(String datakey, String issuerId){
        System.out.println("key is"+datakey);
        System.out.println("issuer id "+issuerId);
        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String data_key = datakey;
        String expdate = "2001";
        String phone = "0000000000";
        String email = "bob@smith.com";
        String note = "my note";
        String cust_id = "customer1";

        String crypt_type = "7";
        String data_key_format = "0";
        String processing_country_code = "CA";
        boolean status_check = false;

//Credential on File details
        CofInfo cof = new CofInfo();
        cof.setIssuerId(issuerId);
        ResAddToken resAddToken = new ResAddToken();
        resAddToken.setDataKey(data_key);
        resAddToken.setCryptType(crypt_type);
        //resAddToken.setExpdate(expdate);
        resAddToken.setCustId(cust_id);
        resAddToken.setPhone(phone);
        resAddToken.setEmail(email);
        resAddToken.setNote(note);
        resAddToken.setCofInfo(cof);
//resAddToken.setDataKeyFormat(data_key_format); //optional
        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transactions mpgReq.setStoreId(store_id);
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(resAddToken);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();
        try
        {
            Receipt receipt = mpgReq.getReceipt();
            System.out.println("DataKey = " + receipt.getDataKey()); System.out.println("ResponseCode = " + receipt.getResponseCode()); System.out.println("Message = " + receipt.getMessage()); System.out.println("TransDate = " + receipt.getTransDate()); System.out.println("TransTime = " + receipt.getTransTime()); System.out.println("Complete = " + receipt.getComplete()); System.out.println("TimedOut = " + receipt.getTimedOut()); System.out.println("ResSuccess = " + receipt.getResSuccess()); System.out.println("PaymentType = " + receipt.getPaymentType()); System.out.println("Cust ID = " + receipt.getResCustId()); System.out.println("Phone = " + receipt.getResPhone()); System.out.println("Email = " + receipt.getResEmail()); System.out.println("Note = " + receipt.getResNote()); System.out.println("MaskedPan = " + receipt.getResMaskedPan()); System.out.println("Exp Date = " + receipt.getResExpdate()); System.out.println("Crypt Type = " + receipt.getResCryptType()); System.out.println("Avs Street Number = " + receipt.getResAvsStreetNumber()); System.out.println("Avs Street Name = " + receipt.getResAvsStreetName()); System.out.println("Avs Zipcode = " + receipt.getResAvsZipcode());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
