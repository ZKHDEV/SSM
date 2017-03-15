package com.zkh.util.mail;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * 邮箱工具类
 * @author zkh
 *
 */
public class MailUtils {
	
	/**
	 * 获取Session
	 * @param host 服务器名
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public static Session createSession(String host, final String username, final String password){
		Properties props = new Properties();
		props.setProperty("mail.host", host);
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		
		return Session.getInstance(props, auth);
	}
	
	/**
	 * 发送邮件
	 * @param session
	 * @param mail
	 * @throws MessagingException
	 */
	public static void send(Session session, Mail mail) throws MessagingException{
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mail.getFrom()));
		
		String toList[] = mail.getTo().split(",");
		
		for(String to : toList){
			msg.addRecipients(RecipientType.TO, to);
		}
		
		msg.setSubject(mail.getSubject());
		
		MimeMultipart multiparts = mail.getMultiparts();
		MimeBodyPart part = new MimeBodyPart();
		part.setContent(mail.getContent(), "text/html;charset=utf-8");
		multiparts.addBodyPart(part);

		msg.setContent(multiparts);
		Transport.send(msg);
	}
}
