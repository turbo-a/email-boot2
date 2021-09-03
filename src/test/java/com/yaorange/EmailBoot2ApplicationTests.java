package com.yaorange;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class EmailBoot2ApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendSimpleMail() {

            //构建一个邮件对象
            SimpleMailMessage message = new SimpleMailMessage();
            //设置邮件主题
            message.setSubject("这是一封测试邮件");
            //设置邮件发送者
            message.setFrom("1145208696@qq.com");
            //设置邮件接收者，可以有多个接收者
            message.setTo("c@qq.com");
            //设置邮件抄送人，可以有多个抄送人
//        message.setCc("37xxxxx37@qq.com");
            //设置隐秘抄送人，可以有多个
//        message.setBcc("14xxxxx098@qq.com");
            //设置邮件发送日期
            message.setSentDate(new Date());
            //设置邮件的正文
            message.setText("这是测试邮件的正文");
            //发送邮件
            javaMailSender.send(message);

    }
    @Test
    public void sendAttachFileMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("crvid-39@gmail.com");
        helper.setTo("1145208696@qq.com");
//        helper.setCc("37xxxxx37@qq.com");
//        helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        helper.addAttachment("meinv.jpg",new File("D:\\Java_Code\\email-boot2\\src\\test\\java\\com\\yaorange\\email\\test.png"));
        javaMailSender.send(mimeMessage);
    }
    @Test
    public void sendImgResMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封乞讨邮件");
        helper.setFrom("crvid-39@gmail.com");
        helper.setTo("1145208696@qq.com");
//        helper.setCc("37xxxxx37@qq.com");
//        helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        helper.setText("<p>hello 你好，我没钱吃饭啦，请美女赏口饭吃</p>" +
                "<p>微信：</p>" +
                "<img src='cid:p1'/ style='width:20px;'>" +
                "<p>支付宝：</p>" +
                "<img src='cid:p2'/>" +
                "<p>下面是一个超链接：</p><a href=\"https://www.google.com\">爱心捐款</a>",true);
        helper.addInline("p1",new FileSystemResource(new File("D:\\Java_Code\\email-boot2\\src\\test\\java\\com\\yaorange\\email\\微信.JPG")));
        helper.addInline("p2",new FileSystemResource(new File("D:\\Java_Code\\email-boot2\\src\\test\\java\\com\\yaorange\\email\\支付宝.JPG")));
        javaMailSender.send(mimeMessage);
    }
    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("crvid39@gmail.com");
        helper.setTo("1145208696@qq.com");
//        helper.setCc("37xxxxx37@qq.com");
//        helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        //import org.thymeleaf.context.Context;
        Context context = new Context();
        context.setVariable("username", "zhangsan");
        context.setVariable("num","000001");
        context.setVariable("salary", "99999");
        String process = templateEngine.process("mail.html", context);
        helper.setText(process,true);
        javaMailSender.send(mimeMessage);
    }

}
