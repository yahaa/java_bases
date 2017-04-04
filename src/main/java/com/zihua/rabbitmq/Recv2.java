package com.zihua.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zihua on 17-4-4.
 */
public class Recv2 {
    public static void main(final String...args){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:bean2.xml");
//        RabbitTemplate rabbit= ctx.getBean();
//        String msg= (String) rabbit.receiveAndConvert("myQueue");
//        System.out.println(msg);
        Foo f= (Foo) ctx.getBean("foo");

    }
}
