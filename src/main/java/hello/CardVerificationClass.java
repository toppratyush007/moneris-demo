package hello;

import JavaAPI.*;

import java.io.IOException;

public class CardVerificationClass {

    public static String cardVerify(String key) {
        System.out.println("key is"+key);
        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String data_key = key;
        java.util.Date createDate = new java.util.Date();
        String order_id = "Test" + createDate.getTime();
        String crypt_type = "7";

        String processing_country_code = "CA";
        boolean status_check = false;
/********************** Efraud Variables ************************/
/*********************** Transaction Object *******************************/
        ResCardVerificationCC resCardVerificationCC = new ResCardVerificationCC();
        resCardVerificationCC.setDataKey(data_key);
        resCardVerificationCC.setOrderId(order_id);
        resCardVerificationCC.setCryptType(crypt_type);
        //resCardVerificationCC.setAvsInfo(avs);
        //resCardVerificationCC.setCvdInfo(cvd); //resCardVerificationCC.setExpdate("1412"); //For Temp Tokens only
//Mandatory - Credential on File details
        CofInfo cof = new CofInfo();
        cof.setPaymentIndicator("U");
        cof.setPaymentInformation("2");
        //cof.setIssuerId("139X3130ASCXAS9");

        resCardVerificationCC.setCofInfo(cof);
        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transactions
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(resCardVerificationCC);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();
/************************ Receipt Object ******************************/
        try {
            Receipt resreceipt = mpgReq.getReceipt();
            System.out.println("DataKey = " + resreceipt.getDataKey());
            System.out.println("ReceiptId = " + resreceipt.getReceiptId());
            System.out.println("ReferenceNum = " + resreceipt.getReferenceNum());
            System.out.println("ResponseCode = " + resreceipt.getResponseCode());
            System.out.println("AuthCode = " + resreceipt.getAuthCode());
            System.out.println("ISO = " + resreceipt.getISO());
            System.out.println("Message = " + resreceipt.getMessage());
            System.out.println("TransDate = " + resreceipt.getTransDate());
            System.out.println("TransTime = " + resreceipt.getTransTime());
            System.out.println("TransType = " + resreceipt.getTransType());
            System.out.println("Complete = " + resreceipt.getComplete());
            System.out.println("TransAmount = " + resreceipt.getTransAmount());
            System.out.println("CardType = " + resreceipt.getCardType());
            System.out.println("TxnNumber = " + resreceipt.getTxnNumber());
            System.out.println("TimedOut = " + resreceipt.getTimedOut());
            System.out.println("ResSuccess = " + resreceipt.getResSuccess());
            System.out.println("PaymentType = " + resreceipt.getPaymentType() + "\n");
            System.out.println("IssuerId = " + resreceipt.getIssuerId());
//Contents of ResolveData
            System.out.println("Cust ID = " + resreceipt.getResCustId());
            System.out.println("Phone = " + resreceipt.getResPhone());
            return resreceipt.getIssuerId();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
