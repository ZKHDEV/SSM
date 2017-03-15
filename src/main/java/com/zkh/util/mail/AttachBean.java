package com.zkh.util.mail;

import java.io.File;

/**
 * 邮件附件Bean类
 * @author zkh
 *
 */
public class AttachBean {
	private File file;
	private String fileName;
		
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public AttachBean(File file, String fileName) {
		super();
		this.file = file;
		this.fileName = fileName;
	}
}
