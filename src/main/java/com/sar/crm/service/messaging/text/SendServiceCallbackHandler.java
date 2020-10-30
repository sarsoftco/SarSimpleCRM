/**
 * SendServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.sar.crm.service.messaging.text;


/**
 *  SendServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class SendServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public SendServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public SendServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getDelivery method
     * override this method for handling normal response from getDelivery operation
     */
    public void receiveResultgetDelivery(
        SendServiceStub.GetDeliveryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDelivery operation
     */
    public void receiveErrorgetDelivery(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSenderNumbers method
     * override this method for handling normal response from getSenderNumbers operation
     */
    public void receiveResultgetSenderNumbers(
        SendServiceStub.GetSenderNumbersResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSenderNumbers operation
     */
    public void receiveErrorgetSenderNumbers(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDeilvery method
     * override this method for handling normal response from getDeilvery operation
     */
    public void receiveResultgetDeilvery(
        SendServiceStub.GetDeilveryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDeilvery operation
     */
    public void receiveErrorgetDeilvery(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendSmsLikeToLike method
     * override this method for handling normal response from sendSmsLikeToLike operation
     */
    public void receiveResultsendSmsLikeToLike(
        SendServiceStub.SendSmsLikeToLikeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendSmsLikeToLike operation
     */
    public void receiveErrorsendSmsLikeToLike(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendBatchSms method
     * override this method for handling normal response from sendBatchSms operation
     */
    public void receiveResultsendBatchSms(
        SendServiceStub.SendBatchSmsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendBatchSms operation
     */
    public void receiveErrorsendBatchSms(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getMessages method
     * override this method for handling normal response from getMessages operation
     */
    public void receiveResultgetMessages(
        SendServiceStub.GetMessagesResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMessages operation
     */
    public void receiveErrorgetMessages(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getBatchDelivery method
     * override this method for handling normal response from getBatchDelivery operation
     */
    public void receiveResultgetBatchDelivery(
        SendServiceStub.GetBatchDeliveryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getBatchDelivery operation
     */
    public void receiveErrorgetBatchDelivery(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for dummy method
     * override this method for handling normal response from dummy operation
     */
    public void receiveResultdummy(
        SendServiceStub.DummyResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from dummy operation
     */
    public void receiveErrordummy(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for checkSmsContent method
     * override this method for handling normal response from checkSmsContent operation
     */
    public void receiveResultcheckSmsContent(
        SendServiceStub.CheckSmsContentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from checkSmsContent operation
     */
    public void receiveErrorcheckSmsContent(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDeliveryLikeToLike method
     * override this method for handling normal response from getDeliveryLikeToLike operation
     */
    public void receiveResultgetDeliveryLikeToLike(
        SendServiceStub.GetDeliveryLikeToLikeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDeliveryLikeToLike operation
     */
    public void receiveErrorgetDeliveryLikeToLike(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCredit method
     * override this method for handling normal response from getCredit operation
     */
    public void receiveResultgetCredit(
        SendServiceStub.GetCreditResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCredit operation
     */
    public void receiveErrorgetCredit(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for extractTelecomBlacklistNumbers method
     * override this method for handling normal response from extractTelecomBlacklistNumbers operation
     */
    public void receiveResultextractTelecomBlacklistNumbers(
        SendServiceStub.ExtractTelecomBlacklistNumbersResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from extractTelecomBlacklistNumbers operation
     */
    public void receiveErrorextractTelecomBlacklistNumbers(
        Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sendSMS method
     * override this method for handling normal response from sendSMS operation
     */
    public void receiveResultsendSMS(
        SendServiceStub.SendSMSResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sendSMS operation
     */
    public void receiveErrorsendSMS(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getInboxCount method
     * override this method for handling normal response from getInboxCount operation
     */
    public void receiveResultgetInboxCount(
        SendServiceStub.GetInboxCountResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getInboxCount operation
     */
    public void receiveErrorgetInboxCount(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for numberIsInTelecomBlacklist method
     * override this method for handling normal response from numberIsInTelecomBlacklist operation
     */
    public void receiveResultnumberIsInTelecomBlacklist(
        SendServiceStub.NumberIsInTelecomBlacklistResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from numberIsInTelecomBlacklist operation
     */
    public void receiveErrornumberIsInTelecomBlacklist(Exception e) {
    }
}
