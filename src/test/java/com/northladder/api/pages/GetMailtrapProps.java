package com.northladder.api.pages;




import com.northladder.api.helper.CommonMethods;
import com.northladder.api.utils.APIPathConstants;
import com.northladder.commonutils.PropertyUtils;

import java.util.Properties;

public class GetMailtrapProps extends CommonMethods {
    CommonMethods commonMethods;
    static String inbox_id;

    /***
     * @throws Exception
     * Creates a request Active Asset Attributes
     */
    public GetMailtrapProps(String basePath, String endPoint) throws Exception {
        super(basePath, endPoint);

    }

    /**
     * It call's the getAssetId(modelorSubseries, modelOrstorage, ramOrStorage) to return the id of the asset.
     * @return the id of the asset
     * @throws Exception
     */

    public static Long getMessageID() throws Exception {
        final Properties properties;
        Long message_ID = null;
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        try {
            inbox_id = properties.getProperty("inbox_id");
            new GetMailtrapProps(APIPathConstants.INBOX, "/{inbox_id}/messages");
            CommonMethods.getJSONPathForMailTrap(inbox_id);
            message_ID = CommonMethods.getBrandCharacteristic("id[0]");


        } catch (Exception e) {
            throw new Exception("Not able to get the url with the Inbox id " + inbox_id);
        }


        return message_ID;
    }


    public static String getMessageFromId(Long messageID) throws Exception {
        final Properties properties;
        String htmlBody;
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        try {

            inbox_id = properties.getProperty("inbox_id");
            new GetMailtrapProps(APIPathConstants.INBOX, "/{inbox_id}/messages/{messageID}/body.html");
            htmlBody = CommonMethods.getBrandCharacteristic(inbox_id,messageID);
            return htmlBody;


        } catch (Exception e) {
            throw new Exception("Not able to get the url with the Inbox id " + inbox_id);
        }


    }

}