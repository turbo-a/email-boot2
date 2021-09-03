package com.yaorange.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
    	ApplicationContext context =
             new ClassPathXmlApplicationContext("Spring-Mail.xml");

    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("crvid-39@gmail.com",
    		   "1145208696@qq.com",
    		   "Testing123",
    		   "Testing only \n\n Hello Spring Email Sender");

    }
}
