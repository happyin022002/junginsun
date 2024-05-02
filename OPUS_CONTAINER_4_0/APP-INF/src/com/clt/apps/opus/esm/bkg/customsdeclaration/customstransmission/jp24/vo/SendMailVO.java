/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SendMailVO.java
*@FileTitle : SendMailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier :
*@LastVersion : 1.0
* 2014.11.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendMailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SendMailVO> models = new ArrayList<SendMailVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String textContent = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String ccRcvrEml = null;
	/* Column Info */
	private String fromEmail = null;
	/* Column Info */
	private String fromName = null;
	/* Column Info */
	private String recipient = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public SendMailVO() {}

	public SendMailVO(String ibflag, String pagerows, String fromEmail, String fromName, String subject, String recipient, String ccRcvrEml, String textContent) {
		this.ibflag = ibflag;
		this.textContent = textContent;
		this.subject = subject;
		this.ccRcvrEml = ccRcvrEml;
		this.fromEmail = fromEmail;
		this.fromName = fromName;
		this.recipient = recipient;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("text_content", getTextContent());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("cc_rcvr_eml", getCcRcvrEml());
		this.hashColumns.put("from_email", getFromEmail());
		this.hashColumns.put("from_name", getFromName());
		this.hashColumns.put("recipient", getRecipient());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("text_content", "textContent");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("cc_rcvr_eml", "ccRcvrEml");
		this.hashFields.put("from_email", "fromEmail");
		this.hashFields.put("from_name", "fromName");
		this.hashFields.put("recipient", "recipient");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return textContent
	 */
	public String getTextContent() {
		return this.textContent;
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
	 * @return ccRcvrEml
	 */
	public String getCcRcvrEml() {
		return this.ccRcvrEml;
	}

	/**
	 * Column Info
	 * @return fromEmail
	 */
	public String getFromEmail() {
		return this.fromEmail;
	}

	/**
	 * Column Info
	 * @return fromName
	 */
	public String getFromName() {
		return this.fromName;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param textContent
	 */
	public void setTextContent(String textContent) {
		this.textContent = textContent;
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
	 * @param ccRcvrEml
	 */
	public void setCcRcvrEml(String ccRcvrEml) {
		this.ccRcvrEml = ccRcvrEml;
	}

	/**
	 * Column Info
	 * @param fromEmail
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	/**
	 * Column Info
	 * @param fromName
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTextContent(JSPUtil.getParameter(request, prefix + "text_content", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setCcRcvrEml(JSPUtil.getParameter(request, prefix + "cc_rcvr_eml", ""));
		setFromEmail(JSPUtil.getParameter(request, prefix + "from_email", ""));
		setFromName(JSPUtil.getParameter(request, prefix + "from_name", ""));
		setRecipient(JSPUtil.getParameter(request, prefix + "recipient", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendMailVO[]
	 */
	public SendMailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendMailVO[]
	 */
	public SendMailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendMailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] textContent = (JSPUtil.getParameter(request, prefix	+ "text_content", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] ccRcvrEml = (JSPUtil.getParameter(request, prefix	+ "cc_rcvr_eml", length));
			String[] fromEmail = (JSPUtil.getParameter(request, prefix	+ "from_email", length));
			String[] fromName = (JSPUtil.getParameter(request, prefix	+ "from_name", length));
			String[] recipient = (JSPUtil.getParameter(request, prefix	+ "recipient", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SendMailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (textContent[i] != null)
					model.setTextContent(textContent[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (ccRcvrEml[i] != null)
					model.setCcRcvrEml(ccRcvrEml[i]);
				if (fromEmail[i] != null)
					model.setFromEmail(fromEmail[i]);
				if (fromName[i] != null)
					model.setFromName(fromName[i]);
				if (recipient[i] != null)
					model.setRecipient(recipient[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendMailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendMailVO[]
	 */
	public SendMailVO[] getSendMailVOs(){
		SendMailVO[] vos = (SendMailVO[])models.toArray(new SendMailVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textContent = this.textContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccRcvrEml = this.ccRcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEmail = this.fromEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromName = this.fromName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipient = this.recipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
