package com.zihua.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zihua on 17-4-2.
 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(JMSConsumer.USERNAME,
                        JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
        Connection connection=null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;
        try{
            connection=connectionFactory.createConnection();
            connection.start();
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("helloword");
            messageConsumer=session.createConsumer(destination);
            while(true){
                TextMessage textMessage= (TextMessage) messageConsumer.receive();
                if(textMessage!=null){
                    System.out.println("get message :"+textMessage.getText());
                }
            }

        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
