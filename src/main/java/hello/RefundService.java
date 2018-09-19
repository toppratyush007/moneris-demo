package hello;

import JavaAPI.HttpsPostRequest;
import JavaAPI.Receipt;
import JavaAPI.Refund;
import JavaAPI.ResIndRefundCC;

public class RefundService {

    public static void indRefund(String datakey){
        java.util.Date createDate = new java.util.Date();
        String order_id = "Test"+createDate.getTime();
        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String data_key = datakey;
        String amount = "1.00";
        String cust_id = "customer1";
        String crypt_type = "1";
        String processing_country_code = "CA";
        boolean status_check = false;
        ResIndRefundCC resIndRefundCC = new ResIndRefundCC();
        resIndRefundCC.setOrderId(order_id);
        resIndRefundCC.setCustId(cust_id);
        resIndRefundCC.setAmount(amount);
        resIndRefundCC.setCryptType(crypt_type);
        resIndRefundCC.setData(data_key);
        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transactions
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(resIndRefundCC);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();
        try
        {
            Receipt receipt = mpgReq.getReceipt();
            System.out.println("DataKey = " + receipt.getDataKey());
            System.out.println("ReceiptId = " + receipt.getReceiptId()); System.out.println("ReferenceNum = " + receipt.getReferenceNum()); System.out.println("ResponseCode = " + receipt.getResponseCode()); System.out.println("AuthCode = " + receipt.getAuthCode()); System.out.println("Message = " + receipt.getMessage()); System.out.println("TransDate = " + receipt.getTransDate()); System.out.println("TransTime = " + receipt.getTransTime()); System.out.println("TransType = " + receipt.getTransType()); System.out.println("Complete = " + receipt.getComplete()); System.out.println("TransAmount = " + receipt.getTransAmount()); System.out.println("CardType = " + receipt.getCardType()); System.out.println("TxnNumber = " + receipt.getTxnNumber()); System.out.println("TimedOut = " + receipt.getTimedOut()); System.out.println("ResSuccess = " + receipt.getResSuccess()); System.out.println("PaymentType = " + receipt.getPaymentType()); System.out.println("IsVisaDebit = " + receipt.getIsVisaDebit()); System.out.println("Cust ID = " + receipt.getResCustId()); System.out.println("Phone = " + receipt.getResPhone()); System.out.println("Email = " + receipt.getResEmail()); System.out.println("Note = " + receipt.getResNote()); System.out.println("Masked Pan = " + receipt.getResMaskedPan()); System.out.println("Exp Date = " + receipt.getResExpdate()); System.out.println("Crypt Type = " + receipt.getResCryptType()); System.out.println("Avs Street Number = " + receipt.getResAvsStreetNumber()); System.out.println("Avs Street Name = " + receipt.getResAvsStreetName()); System.out.println("Avs Zipcode = " + receipt.getResAvsZipcode());
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public static void completionRefund(String datakey,
                                 String order_id,
                                 String amount){

        java.util.Date createDate = new java.util.Date();
        //String order_id = "Test"+createDate.getTime();
        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String data_key = datakey;
        String cust_id = "customer1";
        String crypt_type = "1";
        String processing_country_code = "CA";
        boolean status_check = false;
        ResIndRefundCC resIndRefundCC = new ResIndRefundCC();
        resIndRefundCC.setOrderId(order_id);
        resIndRefundCC.setCustId(cust_id);
        resIndRefundCC.setAmount(amount);
        resIndRefundCC.setCryptType(crypt_type);
        resIndRefundCC.setData(data_key);
        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transaction
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(resIndRefundCC);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();
        try
        {
            Receipt receipt = mpgReq.getReceipt();
            System.out.println("DataKey = " + receipt.getDataKey());
            System.out.println("ReceiptId = " + receipt.getReceiptId()); System.out.println("ReferenceNum = " + receipt.getReferenceNum()); System.out.println("ResponseCode = " + receipt.getResponseCode()); System.out.println("AuthCode = " + receipt.getAuthCode()); System.out.println("Message = " + receipt.getMessage()); System.out.println("TransDate = " + receipt.getTransDate()); System.out.println("TransTime = " + receipt.getTransTime()); System.out.println("TransType = " + receipt.getTransType()); System.out.println("Complete = " + receipt.getComplete()); System.out.println("TransAmount = " + receipt.getTransAmount()); System.out.println("CardType = " + receipt.getCardType()); System.out.println("TxnNumber = " + receipt.getTxnNumber()); System.out.println("TimedOut = " + receipt.getTimedOut()); System.out.println("ResSuccess = " + receipt.getResSuccess()); System.out.println("PaymentType = " + receipt.getPaymentType()); System.out.println("IsVisaDebit = " + receipt.getIsVisaDebit()); System.out.println("Cust ID = " + receipt.getResCustId()); System.out.println("Phone = " + receipt.getResPhone()); System.out.println("Email = " + receipt.getResEmail()); System.out.println("Note = " + receipt.getResNote()); System.out.println("Masked Pan = " + receipt.getResMaskedPan()); System.out.println("Exp Date = " + receipt.getResExpdate()); System.out.println("Crypt Type = " + receipt.getResCryptType()); System.out.println("Avs Street Number = " + receipt.getResAvsStreetNumber()); System.out.println("Avs Street Name = " + receipt.getResAvsStreetName()); System.out.println("Avs Zipcode = " + receipt.getResAvsZipcode());
        }
        catch (Exception e) { e.printStackTrace(); }

    }


    public static void newCompletionRefund(String datakey,
                                        String txn,
                                        String order_id,
                                        String amount){

        String store_id = "monca02906";
        String api_token = "RmPG4uHRJL7Eo7aVxZcd";
        String crypt = "7";
        String dynamic_descriptor = "123456";
        String custid = "mycust9";
        String processing_country_code = "CA";
        boolean status_check = false;
        Refund refund = new Refund();
        refund.setTxnNumber(txn);
        refund.setOrderId(order_id);
        refund.setAmount(amount);
        refund.setCryptType(crypt);
        refund.setCustId(custid);
        refund.setDynamicDescriptor(dynamic_descriptor);
        HttpsPostRequest mpgReq = new HttpsPostRequest();
        mpgReq.setProcCountryCode(processing_country_code);
        mpgReq.setTestMode(true); //false or comment out this line for production transactions
        mpgReq.setStoreId(store_id);
        mpgReq.setApiToken(api_token);
        mpgReq.setTransaction(refund);
        mpgReq.setStatusCheck(status_check);
        mpgReq.send();
        try
        {
            Receipt receipt = mpgReq.getReceipt();
            System.out.println("CardType = " + receipt.getCardType()); System.out.println("TransAmount = " + receipt.getTransAmount()); System.out.println("TxnNumber = " + receipt.getTxnNumber()); System.out.println("ReceiptId = " + receipt.getReceiptId()); System.out.println("TransType = " + receipt.getTransType()); System.out.println("ReferenceNum = " + receipt.getReferenceNum()); System.out.println("ResponseCode = " + receipt.getResponseCode()); System.out.println("ISO = " + receipt.getISO());
            System.out.println("BankTotals = " + receipt.getBankTotals()); System.out.println("Message = " + receipt.getMessage());
            System.out.println("AuthCode = " + receipt.getAuthCode()); System.out.println("Complete = " + receipt.getComplete()); System.out.println("TransDate = " + receipt.getTransDate()); System.out.println("TransTime = " + receipt.getTransTime()); System.out.println("Ticket = " + receipt.getTicket());
            System.out.println("TimedOut = " + receipt.getTimedOut());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}


