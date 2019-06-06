package com.example.quartz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "email.config")
@PropertySource("classpath:email.properties")
public class EmailProperties {

		private String sendmailHost;
		private String sendmailUser;
		private String sendmailPassword;
		
		private String sendmailFrom;
		private String sendmailRecipientsto;
		private String sendmailRecipientscc;
		private String sendmailRecipientsbcc;
		private String sendmailSubject;
		private String sendmailContent;

		private String readmailHost;
		private String readmailUser;
		private String readmailPassword;
		private String readmailFilter;
		public String getSendmailHost() {
			return sendmailHost;
		}
		public void setSendmailHost(String sendmailHost) {
			this.sendmailHost = sendmailHost;
		}
		public String getSendmailUser() {
			return sendmailUser;
		}
		public void setSendmailUser(String sendmailUser) {
			this.sendmailUser = sendmailUser;
		}
		public String getSendmailPassword() {
			return sendmailPassword;
		}
		public void setSendmailPassword(String sendmailPassword) {
			this.sendmailPassword = sendmailPassword;
		}
		public String getSendmailFrom() {
			return sendmailFrom;
		}
		public void setSendmailFrom(String sendmailFrom) {
			this.sendmailFrom = sendmailFrom;
		}
		public String getSendmailRecipientsto() {
			return sendmailRecipientsto;
		}
		public void setSendmailRecipientsto(String sendmailRecipientsto) {
			this.sendmailRecipientsto = sendmailRecipientsto;
		}
		public String getSendmailRecipientscc() {
			return sendmailRecipientscc;
		}
		public void setSendmailRecipientscc(String sendmailRecipientscc) {
			this.sendmailRecipientscc = sendmailRecipientscc;
		}
		public String getSendmailRecipientsbcc() {
			return sendmailRecipientsbcc;
		}
		public void setSendmailRecipientsbcc(String sendmailRecipientsbcc) {
			this.sendmailRecipientsbcc = sendmailRecipientsbcc;
		}
		public String getSendmailSubject() {
			return sendmailSubject;
		}
		public void setSendmailSubject(String sendmailSubject) {
			this.sendmailSubject = sendmailSubject;
		}
		public String getSendmailContent() {
			return sendmailContent;
		}
		public void setSendmailContent(String sendmailContent) {
			this.sendmailContent = sendmailContent;
		}
		public String getReadmailHost() {
			return readmailHost;
		}
		public void setReadmailHost(String readmailHost) {
			this.readmailHost = readmailHost;
		}
		public String getReadmailUser() {
			return readmailUser;
		}
		public void setReadmailUser(String readmailUser) {
			this.readmailUser = readmailUser;
		}
		public String getReadmailPassword() {
			return readmailPassword;
		}
		public void setReadmailPassword(String readmailPassword) {
			this.readmailPassword = readmailPassword;
		}
		public String getReadmailFilter() {
			return readmailFilter;
		}
		public void setReadmailFilter(String readmailFilter) {
			this.readmailFilter = readmailFilter;
		}
		
	
}
