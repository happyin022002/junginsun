/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmailSendInfoVO.java
*@FileTitle : EmailSendInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.20 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
	
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmailSendInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmailSendInfoVO> models = new ArrayList<EmailSendInfoVO>();
	
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String blindcarboncopy = null;
	/* Column Info */
	private String textcontent = null;
	/* Column Info */
	private String argument = null;
	/* Column Info */
	private String template = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String carboncopy = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String filekey = null;
	/* Column Info */
	private String recipient = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String recipientNm = null;
	/* Column Info */
	private String senderOfcCd = null;
	/* Column Info */
	private String senderNm = null;
	/* Column Info */
	private String senderOfcNm = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmailSendInfoVO() {}

	public EmailSendInfoVO(String ibflag, String pagerows, String template, String argument, String textcontent, String blindcarboncopy, String carboncopy, String subject, String filekey, String recipient, String sender, String recipientNm, String senderOfcCd, String senderNm, String senderOfcNm) {
		this.sender = sender;
		this.blindcarboncopy = blindcarboncopy;
		this.textcontent = textcontent;
		this.argument = argument;
		this.template = template;
		this.ibflag = ibflag;
		this.carboncopy = carboncopy;
		this.subject = subject;
		this.filekey = filekey;
		this.recipient = recipient;
		this.pagerows = pagerows;
		this.recipientNm = recipientNm;
		this.senderOfcCd = senderOfcCd;
		this.senderNm = senderNm;
		this.senderOfcNm = senderOfcNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("blindcarboncopy", getBlindcarboncopy());
		this.hashColumns.put("textcontent", getTextContent());
		this.hashColumns.put("argument", getArgument());
		this.hashColumns.put("template", getTemplate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("carboncopy", getCarboncopy());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("filekey", getFilekey());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("recipient_nm", getRecipientNm());
		this.hashColumns.put("sender_ofc_cd", getSenderOfcCd());
		this.hashColumns.put("sender_nm", getSenderNm());
		this.hashColumns.put("sender_ofc_nm", getSenderOfcNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sender", "sender");
		this.hashFields.put("blindcarboncopy", "blindcarboncopy");
		this.hashFields.put("textcontent", "textcontent");
		this.hashFields.put("argument", "argument");
		this.hashFields.put("template", "template");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("carboncopy", "carboncopy");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("filekey", "filekey");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("recipient_nm", "recipientNm");
		this.hashFields.put("sender_ofc_cd", "senderOfcCd");
		this.hashFields.put("sender_nm", "senderNm");
		this.hashFields.put("sender_ofc_nm", "senderOfcNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Column Info
	 * @return blindcarboncopy
	 */
	public String getBlindcarboncopy() {
		return this.blindcarboncopy;
	}
	
	/**
	 * Column Info
	 * @return textcontent
	 */
	public String getTextContent() {
		return this.textcontent;
	}	
		
	/**
	 * Column Info
	 * @return argument
	 */
	public String getArgument() {
		return this.argument;
	}
	
	/**
	 * Column Info
	 * @return template
	 */
	public String getTemplate() {
		return this.template;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return carboncopy
	 */
	public String getCarboncopy() {
		return this.carboncopy;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return filekey
	 */
	public String getFilekey() {
		return this.filekey;
	}
	
	/**
	 * Column Info
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return recipientNm
	 */
	public String getRecipientNm() {
		return this.recipientNm;
	}
	
	/**
	 * Column Info
	 * @return senderOfcCd
	 */
	public String getSenderOfcCd() {
		return this.senderOfcCd;
	}
	
	/**
	 * Column Info
	 * @return senderNm
	 */
	public String getSenderNm() {
		return this.senderNm;
	}

	/**
	 * Column Info
	 * @return senderOfcNm
	 */
	public String getSenderOfcNm() {
		return this.senderOfcNm;
	}

	/**
	 * Column Info
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Column Info
	 * @param blindcarboncopy
	 */
	public void setBlindcarboncopy(String blindcarboncopy) {
		this.blindcarboncopy = blindcarboncopy;
	}
	
	/**
	 * Column Info
	 * @param textcontent
	 */
	public void setTextContent(String textcontent) {
		this.textcontent = textcontent;
	}
	
	/**
	 * Column Info
	 * @param argument
	 */
	public void setArgument(String argument) {
		this.argument = argument;
	}
	
	/**
	 * Column Info
	 * @param template
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param carboncopy
	 */
	public void setCarboncopy(String carboncopy) {
		this.carboncopy = carboncopy;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param filekey
	 */
	public void setFilekey(String filekey) {
		this.filekey = filekey;
	}
	
	/**
	 * Column Info
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param recipientNm
	 */
	public void setRecipientNm(String recipientNm) {
		this.recipientNm = recipientNm;
	}
	
	/**
	 * Column Info
	 * @param senderOfcCd
	 */
	public void setSenderOfcCd(String senderOfcCd) {
		this.senderOfcCd = senderOfcCd;
	}
	
	/**
	 * Column Info
	 * @param senderNm
	 */
	public void setSenderNm(String senderNm) {
		this.senderNm = senderNm;
	}
	
	/**
	 * Column Info
	 * @param senderOfcNm
	 */
	public void setSenderOfcNm(String senderOfcNm) {
		this.senderOfcNm = senderOfcNm;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSender(JSPUtil.getParameter(request, prefix + "sender", ""));
		setBlindcarboncopy(JSPUtil.getParameter(request, prefix + "blindcarboncopy", ""));
		setTextContent(JSPUtil.getParameter(request, prefix + "textcontent", ""));
		setArgument(JSPUtil.getParameter(request, prefix + "argument", ""));
		setTemplate(JSPUtil.getParameter(request, prefix + "template", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCarboncopy(JSPUtil.getParameter(request, prefix + "carboncopy", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setFilekey(JSPUtil.getParameter(request, prefix + "filekey", ""));
		setRecipient(JSPUtil.getParameter(request, prefix + "recipient", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRecipientNm(JSPUtil.getParameter(request, prefix + "recipient_nm", ""));
		setSenderOfcCd(JSPUtil.getParameter(request, prefix + "sender_ofc_cd", ""));
		setSenderNm(JSPUtil.getParameter(request, prefix + "sender_nm", ""));
		setSenderOfcNm(JSPUtil.getParameter(request, prefix + "sender_ofc_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmailSendInfoVO[]
	 */
	public EmailSendInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmailSendInfoVO[]
	 */
	public EmailSendInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmailSendInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] blindcarboncopy = (JSPUtil.getParameter(request, prefix	+ "blindcarboncopy", length));
			String[] textcontent = (JSPUtil.getParameter(request, prefix	+ "textcontent", length));
			String[] argument = (JSPUtil.getParameter(request, prefix	+ "argument", length));
			String[] template = (JSPUtil.getParameter(request, prefix	+ "template", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] carboncopy = (JSPUtil.getParameter(request, prefix	+ "carboncopy", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] filekey = (JSPUtil.getParameter(request, prefix	+ "filekey", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] recipientNm = (JSPUtil.getParameter(request, prefix	+ "recipient_nm", length));
			String[] senderOfcCd = (JSPUtil.getParameter(request, prefix	+ "sender_ofc_cd", length));
			String[] senderNm = (JSPUtil.getParameter(request, prefix	+ "sender_nm", length));
			String[] senderOfcNm = (JSPUtil.getParameter(request, prefix	+ "sender_ofc_Nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmailSendInfoVO();
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (blindcarboncopy[i] != null)
					model.setBlindcarboncopy(blindcarboncopy[i]);
				if (textcontent[i] != null)
					model.setTextContent(textcontent[i]);
				if (argument[i] != null)
					model.setArgument(argument[i]);
				if (template[i] != null)
					model.setTemplate(template[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (carboncopy[i] != null)
					model.setCarboncopy(carboncopy[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (filekey[i] != null)
					model.setFilekey(filekey[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (recipientNm[i] != null)
					model.setRecipientNm(recipientNm[i]);
				if (senderOfcCd[i] != null)
					model.setSenderOfcCd(senderOfcCd[i]);
				if (senderNm[i] != null)
					model.setSenderNm(senderNm[i]);
				if (senderOfcNm[i] != null)
					model.setSenderOfcNm(senderOfcNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmailSendInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmailSendInfoVO[]
	 */
	public EmailSendInfoVO[] getEmailSendInfoVOs(){
		EmailSendInfoVO[] vos = (EmailSendInfoVO[])models.toArray(new EmailSendInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blindcarboncopy = this.blindcarboncopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textcontent = this.textcontent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.argument = this.argument .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.template = this.template .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carboncopy = this.carboncopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filekey = this.filekey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipientNm = this.recipientNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderOfcCd = this.senderOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderNm = this.senderNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderOfcNm = this.senderOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
