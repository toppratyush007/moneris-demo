package hello;

import JavaAPI.CofInfo;
import JavaAPI.HttpsPostRequest;
import JavaAPI.Receipt;
import JavaAPI.ResPreauthCC;

public class PreAuthService {

    public static void preAuth(String datakey, String issuerId)
    {
        java.util.Date createDate = new java.util.Date();
        String order_id = "Test"+createDate.getTime();
        System.out.println("order id is "+order_id);
        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String data_key = datakey;
        String amount = "0.80";
        String cust_id = "customer1"; //if sent will be submitted, otherwise cust_id from profile will be used
        String crypt_type = "1";
        String dynamic_descriptor = "my descriptor";
        String processing_country_code = "CA";
        String expdate = "1712"; //For Temp Token
        boolean status_check = false;

        ResPreauthCC resPreauthCC = new ResPreauthCC();
        resPreauthCC.setData(data_key);
        resPreauthCC.setOrderId(order_id);
        resPreauthCC.setCustId(cust_id);
        resPreauthCC.setAmount(amount);
        resPreauthCC.setCryptType(crypt_type);
        resPreauthCC.setDynamicDescriptor(dynamic_descriptor);
        //resPreauthCC.setExpDate(expdate);  //Temp Tokens only

        CofInfo cof = new CofInfo();
        cof.setPaymentIndicator("U");
        cof.setPaymentInformation("2");
        cof.setIssuerId(issuerId);
        resPreauthCC.setCofInfo(cof);

        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transactions
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(resPreauthCC);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();

        try
        {
            Receipt receipt = mpgReq.getReceipt();

            System.out.println("DataKey = " + receipt.getDataKey());
            System.out.println("ReceiptId = " + receipt.getReceiptId());
            System.out.println("ReferenceNum = " + receipt.getReferenceNum());
            System.out.println("ResponseCode = " + receipt.getResponseCode());
            System.out.println("AuthCode = " + receipt.getAuthCode());
            System.out.println("Message = " + receipt.getMessage());
            System.out.println("TransDate = " + receipt.getTransDate());
            System.out.println("TransTime = " + receipt.getTransTime());
            System.out.println("TransType = " + receipt.getTransType());
            System.out.println("Complete = " + receipt.getComplete());
            System.out.println("TransAmount = " + receipt.getTransAmount());
            System.out.println("CardType = " + receipt.getCardType());
            System.out.println("TxnNumber = " + receipt.getTxnNumber());
            System.out.println("TimedOut = " + receipt.getTimedOut());
            System.out.println("ResSuccess = " + receipt.getResSuccess());
            System.out.println("PaymentType = " + receipt.getPaymentType());
            System.out.println("IsVisaDebit = " + receipt.getIsVisaDebit());
            System.out.println("Cust ID = " + receipt.getResCustId());
            System.out.println("Phone = " + receipt.getResPhone());
            System.out.println("Email = " + receipt.getResEmail());
            System.out.println("Note = " + receipt.getResNote());
            System.out.println("Masked Pan = " + receipt.getResMaskedPan());
            System.out.println("Exp Date = " + receipt.getResExpdate());
            System.out.println("Crypt Type = " + receipt.getResCryptType());
            System.out.println("Avs Street Number = " + receipt.getResAvsStreetNumber());
            System.out.println("Avs Street Name = " + receipt.getResAvsStreetName());
            System.out.println("Avs Zipcode = " + receipt.getResAvsZipcode());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
