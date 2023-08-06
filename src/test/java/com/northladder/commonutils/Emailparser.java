package com.northladder.commonutils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.mail.*;
import java.util.Properties;


public class Emailparser {


    public static StringBuilder parseHTML(String emailBody, String cssPath) throws Exception {
        StringBuilder completeText = new StringBuilder();
        String singletextValue = "";
        Document document;
        try {
            document = Jsoup.parse(emailBody);
            Elements elements = document.select(cssPath);
            for (Element element : elements) {
                singletextValue = element.text();
                completeText.append(singletextValue);

            }
            System.out.println("Reverse Appraisal Request Number from Gmail: " + completeText);

        } catch (Exception e) {
            throw new Exception("Failed to get the element value in the email due to --->  ", e);
        }

        return completeText;
    }

    public static String readEmailFromMicrosoft() throws MessagingException {
        String body = null;
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imap");
        props.setProperty("mail.imap.ssl.enable", "true");
        props.setProperty("mail.imaps.partialfetch", "false");
        props.put("mail.mime.base64.ignoreerrors", "true");

        Session mailSession = Session.getInstance(props);
        mailSession.setDebug(true);
        Store store = mailSession.getStore("imap");
        store.connect("outlook.office365.com", "shaurya.singh@northladder.com", "Shivi!!579");

        try {
            // Access the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Read the emails
            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                // Perform any desired automation tasks with the email data
                String subject = message.getSubject();
                Address[] from = message.getFrom();
                body = (String) message.getContent();
                // ...

                // Example: Print email subject and sender
                System.out.println("Subject: " + subject);
                System.out.println("From: " + from[0]);

                // You can further process the email content based on your requirements

                // Mark email as read
                message.setFlag(Flags.Flag.SEEN, true);
            }

            // Close the connection
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return body;

    }

    public static void main(String[] args) throws MessagingException {
        readEmailFromMicrosoft();
    }
}
