package com.test.api.tests;

import com.test.api.pages.GetMailtrapProps;
import com.test.commonutils.Emailparser;


public class GetMailtrapPropsTest {
    public static Long messageID = null;
    public static String emailBody = null;
    public static String readOTP = null;


    public static void getMessageIDForOTP() throws Exception {
     messageID =  GetMailtrapProps.getMessageID();

      }


    public static void getEmailMessageFromMsgId() throws Exception {
        emailBody = GetMailtrapProps.getMessageFromId(messageID);

    }


    public static String getOTPfromMsgBody() throws Exception {
        getMessageIDForOTP();
        getEmailMessageFromMsgId();
        return String.valueOf(Emailparser.parseHTML(emailBody,"body > div > div:nth-child(2) > p:nth-child(3)"));

    }



}
