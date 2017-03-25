package com.zihua.testThread;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSystem {
    private Properties props;
    private String username;
    private String password;

    public EmailSystem(String username, String password) {
        this.username = username;
        this.password = password;
        this.props = getProps(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean sendMail(Message msg) {
        try {
            Session session = Session.getDefaultInstance(props);
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"),
                    props.getProperty("username"), props.getProperty("password"));
            transport.sendMessage(msg, msg.getAllRecipients());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Message createMsg(String to, String subject, String content) {
        Message msg = null;
        try {
            Session mailSession = Session.getDefaultInstance(props);
            msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(username));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setContent(content, "text/html;charset=UTF-8");
            msg.saveChanges();
        } catch (Exception e) {

        } finally {
            return msg;
        }

    }


    public Message createMsg2(String to, String subject, String content, String fileName) {
        Message msg = null;
        try {
            Session mailSession = Session.getDefaultInstance(props);
            msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(username));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);


            Multipart multipart = new MimeMultipart();
            BodyPart msgbp = new MimeBodyPart();

            DataSource source = new FileDataSource(fileName);

            msgbp.setDataHandler(new DataHandler(source));
            msgbp.setFileName("ttt.txt");
            multipart.addBodyPart(msgbp);
            msg.setContent(multipart);
            msg.saveChanges();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(898989);

        } finally {
            return msg;
        }

    }

    public Properties getProps(String username, String password) {
        Properties props = new Properties();
        props.put("username", username);
        props.put("password", password);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        return props;
    }

    public void setProps(String username, String password) {
        this.username = username;
        this.password = password;
        this.props.put("username", username);
        this.props.put("password", password);

    }

    public static void main(String[] args) {
        String username = "********";
        String password = "********";
        EmailSystem system = new EmailSystem(username, password);
        Message msg = system.createMsg2("zihuayuan68@qq.com", "fuck you", "fuck fuck fuck", "ttt.txt");
        system.sendMail(msg);
    }

}
