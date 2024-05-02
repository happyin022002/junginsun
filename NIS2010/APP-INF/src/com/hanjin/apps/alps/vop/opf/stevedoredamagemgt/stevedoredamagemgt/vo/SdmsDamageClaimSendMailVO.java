/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SdmsDamageClaimSendMailVO.java
*@FileTitle : SdmsDamageClaimSendMailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.12  
* 1.0 Creation
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsDamageClaimSendMailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsDamageClaimSendMailVO> models = new ArrayList<SdmsDamageClaimSendMailVO>();
	
	/* Column Info */
	private String fromUserNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String textContent = null;
	/* Column Info */
	private String fromUser = null;
	/* Column Info */
	private String toUser = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String bccUser = null;
	/* Column Info */
	private String ccUser = null;
	/* Column Info */
	private String htmlContent = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsDamageClaimSendMailVO() {}

	public SdmsDamageClaimSendMailVO(String ibflag, String pagerows, String toUser, String ccUser, String bccUser, String fromUser, String fromUserNm, String subject, String textContent, String htmlContent) {
		this.fromUserNm = fromUserNm;
		this.ibflag = ibflag;
		this.textContent = textContent;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.subject = subject;
		this.bccUser = bccUser;
		this.ccUser = ccUser;
		this.htmlContent = htmlContent;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_user_nm", getFromUserNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("text_content", getTextContent());
		this.hashColumns.put("from_user", getFromUser());
		this.hashColumns.put("to_user", getToUser());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("bcc_user", getBccUser());
		this.hashColumns.put("cc_user", getCcUser());
		this.hashColumns.put("html_content", getHtmlContent());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_user_nm", "fromUserNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("text_content", "textContent");
		this.hashFields.put("from_user", "fromUser");
		this.hashFields.put("to_user", "toUser");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("bcc_user", "bccUser");
		this.hashFields.put("cc_user", "ccUser");
		this.hashFields.put("html_content", "htmlContent");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromUserNm
	 */
	public String getFromUserNm() {
		return this.fromUserNm;
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
	 * @return fromUser
	 */
	public String getFromUser() {
		return this.fromUser;
	}
	
	/**
	 * Column Info
	 * @return toUser
	 */
	public String getToUser() {
		return this.toUser;
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
	 * @return bccUser
	 */
	public String getBccUser() {
		return this.bccUser;
	}
	
	/**
	 * Column Info
	 * @return ccUser
	 */
	public String getCcUser() {
		return this.ccUser;
	}
	
	/**
	 * Column Info
	 * @return htmlContent
	 */
	public String getHtmlContent() {
		return this.htmlContent;
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
	 * @param fromUserNm
	 */
	public void setFromUserNm(String fromUserNm) {
		this.fromUserNm = fromUserNm;
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
	 * @param fromUser
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
	/**
	 * Column Info
	 * @param toUser
	 */
	public void setToUser(String toUser) {
		this.toUser = toUser;
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
	 * @param bccUser
	 */
	public void setBccUser(String bccUser) {
		this.bccUser = bccUser;
	}
	
	/**
	 * Column Info
	 * @param ccUser
	 */
	public void setCcUser(String ccUser) {
		this.ccUser = ccUser;
	}
	
	/**
	 * Column Info
	 * @param htmlContent
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
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
		setFromUserNm(JSPUtil.getParameter(request, prefix + "from_user_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTextContent(JSPUtil.getParameter(request, prefix + "text_content", ""));
		setFromUser(JSPUtil.getParameter(request, prefix + "from_user", ""));
		setToUser(JSPUtil.getParameter(request, prefix + "to_user", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setBccUser(JSPUtil.getParameter(request, prefix + "bcc_user", ""));
		setCcUser(JSPUtil.getParameter(request, prefix + "cc_user", ""));
		setHtmlContent(JSPUtil.getParameter(request, prefix + "html_content", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsDamageClaimSendMailVO[]
	 */
	public SdmsDamageClaimSendMailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsDamageClaimSendMailVO[]
	 */
	public SdmsDamageClaimSendMailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsDamageClaimSendMailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromUserNm = (JSPUtil.getParameter(request, prefix	+ "from_user_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] textContent = (JSPUtil.getParameter(request, prefix	+ "text_content", length));
			String[] fromUser = (JSPUtil.getParameter(request, prefix	+ "from_user", length));
			String[] toUser = (JSPUtil.getParameter(request, prefix	+ "to_user", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] bccUser = (JSPUtil.getParameter(request, prefix	+ "bcc_user", length));
			String[] ccUser = (JSPUtil.getParameter(request, prefix	+ "cc_user", length));
			String[] htmlContent = (JSPUtil.getParameter(request, prefix	+ "html_content", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsDamageClaimSendMailVO();
				if (fromUserNm[i] != null)
					model.setFromUserNm(fromUserNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (textContent[i] != null)
					model.setTextContent(textContent[i]);
				if (fromUser[i] != null)
					model.setFromUser(fromUser[i]);
				if (toUser[i] != null)
					model.setToUser(toUser[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (bccUser[i] != null)
					model.setBccUser(bccUser[i]);
				if (ccUser[i] != null)
					model.setCcUser(ccUser[i]);
				if (htmlContent[i] != null)
					model.setHtmlContent(htmlContent[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsDamageClaimSendMailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsDamageClaimSendMailVO[]
	 */
	public SdmsDamageClaimSendMailVO[] getSdmsDamageClaimSendMailVOs(){
		SdmsDamageClaimSendMailVO[] vos = (SdmsDamageClaimSendMailVO[])models.toArray(new SdmsDamageClaimSendMailVO[models.size()]);
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
		this.fromUserNm = this.fromUserNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.textContent = this.textContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromUser = this.fromUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUser = this.toUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bccUser = this.bccUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccUser = this.ccUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htmlContent = this.htmlContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
