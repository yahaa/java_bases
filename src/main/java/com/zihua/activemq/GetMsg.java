package com.zihua.activemq;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zihua on 17-4-2.
 */

public class GetMsg {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/bean1.xml");
        MsgHandler msgHandler = (MsgHandler) context.getBean("msgHandler");

    }


}
