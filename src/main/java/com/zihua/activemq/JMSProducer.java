package com.zihua.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zihua on 17-4-2.
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME,
                JMSProducer.PASSWORD, JMSProducer.BROKEURL);
        Connection connection = null;
        Session session;
        Queue destination;
        MessageProducer messageProducer;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("helloword");
            messageProducer = session.createProducer(destination);
            sendMessage(session, messageProducer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void sendMessage(Session session, MessageProducer messageProducer) {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage message = null;
            try {
                message = session.createTextMessage("ActiveMQ 发送消息 66666 aaaaaaaaaaabbbbbb" + i);
                System.out.println("发送消息 " + i);
                messageProducer.send(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
