package com.zkh.util.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.IOException;

/**
 * 邮件类
 * @author zkh
 *
 */
public class Mail {
	private String from;
	private String to;
	private String subject;
	private String content;
	private MimeMultipart multiparts = new MimeMultipart();

	/**
	 * 初始化邮件类
	 * @param from 发送源邮箱
	 * @param to 对方邮箱（多邮箱使用'，'隔开）
	 * @param subject 标题
	 * @param content 内容
	 * @throws MessagingException
	 */
	public Mail(String from, String to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MimeMultipart getMultiparts() {
		return multiparts;
	}
	
	/**
	 * 添加附件
	 * @param attach
	 * @throws IOException
	 * @throws MessagingException
	 */
	public void addAttach(AttachBean attach) throws IOException, MessagingException{
		MimeBodyPart part = new MimeBodyPart();
		part.attachFile(attach.getFile());
		part.setFileName(MimeUtility.encodeText(attach.getFileName()));
		multiparts.addBodyPart(part);
	}
}
