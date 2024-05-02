/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NYCEmlVO.java
*@FileTitle : NYCEmlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* --------------------------------------------------------
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NYCEmlVO {

	private static final long serialVersionUID = 1L;
		
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String stampType = null;
	/* Column Info */
	private String sendFlag = null;
	/* Column Info */
	private String mailType = null;
	/* Column Info */
	private String bkgNos = null;	
	/* Column Info */
	private String edtToEml = null;
	/* Column Info */
	private String edtCcEml = null;
	/* Column Info */
	private String edtFromEml = null;
	/* Column Info */
	private String edtSubject = null;
	/* Column Info */
	private String edtContents = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NYCEmlVO() {}

	public NYCEmlVO( String arOfcCd, String stampType, String sendFlag, String mailType, String bkgNos, String edtToEml, String edtCcEml, String edtFromEml, String edtSubject, String edtContents ) {
		this.arOfcCd = arOfcCd;
		this.stampType = stampType;
		this.sendFlag = sendFlag;
		this.mailType = mailType;
		this.bkgNos = bkgNos;
		this.edtToEml = edtToEml;
		this.edtCcEml = edtCcEml;
		this.edtFromEml = edtFromEml;
		this.edtSubject = edtSubject;
		this.edtContents = edtContents;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("arOfcCd", getArOfcCd());
		this.hashColumns.put("stampType", getStampType());
		this.hashColumns.put("sendFlag", getSendFlag());
		this.hashColumns.put("mailType", getMailType());
		this.hashColumns.put("bkgNos", getBkgNos());
		this.hashColumns.put("edtToEml", getEdtToEml());
		this.hashColumns.put("edtCcEml", getEdtCcEml());
		this.hashColumns.put("edtFromEml", getEdtFromEml());
		this.hashColumns.put("edtSubject", getEdtSubject());
		this.hashColumns.put("edtContents", getEdtContents());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("stamp_type", "stampType");
		this.hashFields.put("send_flag", "sendFlag");
		this.hashFields.put("mail_type", "mailType");
		this.hashFields.put("bkg_nos", "bkgNos");
		this.hashFields.put("edt_to_eml", "edtToEml");
		this.hashFields.put("edt_cc_eml", "edtCcEml");
		this.hashFields.put("edt_from_eml", "edtFromEml");
		this.hashFields.put("edt_subject", "edtSubject");
		this.hashFields.put("edt_contents", "edtContents");
		return this.hashFields;
	}
	
	
	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the stampType
	 */
	public String getStampType() {
		return stampType;
	}

	/**
	 * @param stampType the stampType to set
	 */
	public void setStampType(String stampType) {
		this.stampType = stampType;
	}

	/**
	 * @return the sendFlag
	 */
	public String getSendFlag() {
		return sendFlag;
	}

	/**
	 * @param sendFlag the sendFlag to set
	 */
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	/**
	 * @return the mailType
	 */
	public String getMailType() {
		return mailType;
	}

	/**
	 * @param mailType the mailType to set
	 */
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}


	/**
	 * @return the bkgNos
	 */
	public String getBkgNos() {
		return bkgNos;
	}

	/**
	 * @param mailType the mailType to set
	 */
	public void setBkgNos(String bkgNos) {
		this.bkgNos = bkgNos;
	}

	
	public String getEdtToEml() {
		return edtToEml;
	}

	public void setEdtToEml(String edtToEml) {
		this.edtToEml = edtToEml;
	}

	public String getEdtCcEml() {
		return edtCcEml;
	}

	public void setEdtCcEml(String edtCcEml) {
		this.edtCcEml = edtCcEml;
	}

	public String getEdtFromEml() {
		return edtFromEml;
	}

	public void setEdtFromEml(String edtFromEml) {
		this.edtFromEml = edtFromEml;
	}

	public String getEdtSubject() {
		return edtSubject;
	}

	public void setEdtSubject(String edtSubject) {
		this.edtSubject = edtSubject;
	}

	public String getEdtContents() {
		return edtContents;
	}

	public void setEdtContents(String edtContents) {
		this.edtContents = edtContents;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
		setStampType(JSPUtil.getParameter(request, "stamp_type", ""));
		setSendFlag(JSPUtil.getParameter(request, "send_flag", ""));
		setMailType(JSPUtil.getParameter(request, "mail_type", ""));
		setBkgNos(JSPUtil.getParameter(request, "bkg_nos", ""));
		setEdtToEml(JSPUtil.getParameter(request, "edt_to_eml", ""));
		setEdtCcEml(JSPUtil.getParameter(request, "edt_cc_eml", ""));
		setEdtFromEml(JSPUtil.getParameter(request, "edt_from_eml", ""));
		setEdtSubject(JSPUtil.getParameter(request, "edt_subject", ""));
		setEdtContents(JSPUtil.getParameter(request, "edt_contents", ""));
	}
	
	
	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stampType = this.stampType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag = this.sendFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mailType = this.mailType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNos = this.bkgNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtToEml = this.edtToEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtCcEml = this.edtCcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtFromEml = this.edtFromEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtSubject = this.edtSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtContents = this.edtContents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
