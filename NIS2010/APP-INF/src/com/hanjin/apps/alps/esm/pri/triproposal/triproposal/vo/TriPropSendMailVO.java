/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TriPropSendMailVO.java
*@FileTitle : TriPropSendMailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.24 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TriPropSendMailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TriPropSendMailVO> models = new ArrayList<TriPropSendMailVO>();
	
	/* Column Info */
	private String textContent = null;
	/* Column Info */
	private String fromUser = null;
	/* Column Info */
	private String isGw = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String ccUser = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String htmlContent = null;
	/* Column Info */
	private String fromUserNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileKey = null;
	/* Column Info */
	private String batFlg = null;
	/* Column Info */
	private String toUser = null;
	/* Column Info */
	private String bccUser = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TriPropSendMailVO() {}

	public TriPropSendMailVO(String ibflag, String pagerows, String fromUser, String fromUserNm, String ofcCd, String toUser, String ccUser, String bccUser, String subject, String textContent, String htmlContent, String isGw, String fileKey, String batFlg) {
		this.textContent = textContent;
		this.fromUser = fromUser;
		this.isGw = isGw;
		this.subject = subject;
		this.ccUser = ccUser;
		this.pagerows = pagerows;
		this.htmlContent = htmlContent;
		this.fromUserNm = fromUserNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fileKey = fileKey;
		this.batFlg = batFlg;
		this.toUser = toUser;
		this.bccUser = bccUser;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("text_content", getTextContent());
		this.hashColumns.put("from_user", getFromUser());
		this.hashColumns.put("is_gw", getIsGw());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("cc_user", getCcUser());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("html_content", getHtmlContent());
		this.hashColumns.put("from_user_nm", getFromUserNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_key", getFileKey());
		this.hashColumns.put("bat_flg", getBatFlg());
		this.hashColumns.put("to_user", getToUser());
		this.hashColumns.put("bcc_user", getBccUser());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("text_content", "textContent");
		this.hashFields.put("from_user", "fromUser");
		this.hashFields.put("is_gw", "isGw");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("cc_user", "ccUser");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("html_content", "htmlContent");
		this.hashFields.put("from_user_nm", "fromUserNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_key", "fileKey");
		this.hashFields.put("bat_flg", "batFlg");
		this.hashFields.put("to_user", "toUser");
		this.hashFields.put("bcc_user", "bccUser");
		return this.hashFields;
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
	 * @return isGw
	 */
	public String getIsGw() {
		return this.isGw;
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
	 * @return ccUser
	 */
	public String getCcUser() {
		return this.ccUser;
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
	 * @return htmlContent
	 */
	public String getHtmlContent() {
		return this.htmlContent;
	}
	
	/**
	 * Column Info
	 * @return fromUserNm
	 */
	public String getFromUserNm() {
		return this.fromUserNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return fileKey
	 */
	public String getFileKey() {
		return this.fileKey;
	}
	
	/**
	 * Column Info
	 * @return batFlg
	 */
	public String getBatFlg() {
		return this.batFlg;
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
	 * @return bccUser
	 */
	public String getBccUser() {
		return this.bccUser;
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
	 * @param isGw
	 */
	public void setIsGw(String isGw) {
		this.isGw = isGw;
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
	 * @param ccUser
	 */
	public void setCcUser(String ccUser) {
		this.ccUser = ccUser;
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
	 * @param htmlContent
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
	/**
	 * Column Info
	 * @param fromUserNm
	 */
	public void setFromUserNm(String fromUserNm) {
		this.fromUserNm = fromUserNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param fileKey
	 */
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	
	/**
	 * Column Info
	 * @param batFlg
	 */
	public void setBatFlg(String batFlg) {
		this.batFlg = batFlg;
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
	 * @param bccUser
	 */
	public void setBccUser(String bccUser) {
		this.bccUser = bccUser;
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
		setTextContent(JSPUtil.getParameter(request, prefix + "text_content", ""));
		setFromUser(JSPUtil.getParameter(request, prefix + "from_user", ""));
		setIsGw(JSPUtil.getParameter(request, prefix + "is_gw", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setCcUser(JSPUtil.getParameter(request, prefix + "cc_user", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHtmlContent(JSPUtil.getParameter(request, prefix + "html_content", ""));
		setFromUserNm(JSPUtil.getParameter(request, prefix + "from_user_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileKey(JSPUtil.getParameter(request, prefix + "file_key", ""));
		setBatFlg(JSPUtil.getParameter(request, prefix + "bat_flg", ""));
		setToUser(JSPUtil.getParameter(request, prefix + "to_user", ""));
		setBccUser(JSPUtil.getParameter(request, prefix + "bcc_user", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TriPropSendMailVO[]
	 */
	public TriPropSendMailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TriPropSendMailVO[]
	 */
	public TriPropSendMailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TriPropSendMailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] textContent = (JSPUtil.getParameter(request, prefix	+ "text_content", length));
			String[] fromUser = (JSPUtil.getParameter(request, prefix	+ "from_user", length));
			String[] isGw = (JSPUtil.getParameter(request, prefix	+ "is_gw", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] ccUser = (JSPUtil.getParameter(request, prefix	+ "cc_user", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] htmlContent = (JSPUtil.getParameter(request, prefix	+ "html_content", length));
			String[] fromUserNm = (JSPUtil.getParameter(request, prefix	+ "from_user_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileKey = (JSPUtil.getParameter(request, prefix	+ "file_key", length));
			String[] batFlg = (JSPUtil.getParameter(request, prefix	+ "bat_flg", length));
			String[] toUser = (JSPUtil.getParameter(request, prefix	+ "to_user", length));
			String[] bccUser = (JSPUtil.getParameter(request, prefix	+ "bcc_user", length));
			
			for (int i = 0; i < length; i++) {
				model = new TriPropSendMailVO();
				if (textContent[i] != null)
					model.setTextContent(textContent[i]);
				if (fromUser[i] != null)
					model.setFromUser(fromUser[i]);
				if (isGw[i] != null)
					model.setIsGw(isGw[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (ccUser[i] != null)
					model.setCcUser(ccUser[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (htmlContent[i] != null)
					model.setHtmlContent(htmlContent[i]);
				if (fromUserNm[i] != null)
					model.setFromUserNm(fromUserNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileKey[i] != null)
					model.setFileKey(fileKey[i]);
				if (batFlg[i] != null)
					model.setBatFlg(batFlg[i]);
				if (toUser[i] != null)
					model.setToUser(toUser[i]);
				if (bccUser[i] != null)
					model.setBccUser(bccUser[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTriPropSendMailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TriPropSendMailVO[]
	 */
	public TriPropSendMailVO[] getTriPropSendMailVOs(){
		TriPropSendMailVO[] vos = (TriPropSendMailVO[])models.toArray(new TriPropSendMailVO[models.size()]);
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
		this.textContent = this.textContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromUser = this.fromUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isGw = this.isGw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccUser = this.ccUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htmlContent = this.htmlContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromUserNm = this.fromUserNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileKey = this.fileKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batFlg = this.batFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toUser = this.toUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bccUser = this.bccUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
