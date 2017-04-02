package com.zihua.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by zihua on 17-4-2.
 */
public class HelloSender {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
        JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");
        template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("jklajslkdfjlkasjdfkljasdklfj;lasdjfklajsdlfkjas;jdf8888888");
            }
        });
        System.out.println("fa song yi tiao xiao xi");
    }
}
