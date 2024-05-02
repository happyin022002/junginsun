/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1074Event.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_1074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1074Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg1074Event(){}
	private String bkgNo = null;
	private String blNo = null;
	
	private String shprCd = null;
	private String shprNm = null;

	private String fwdrCd = null;
	private String fwdrNm = null;

	private String emailTo = null;
	private String emailSubject = null;
	private String emailContents = null;
	
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}
	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	/**
	 * @return the shprCd
	 */
	public String getShprCd() {
		return shprCd;
	}
	/**
	 * @param shprCd the shprCd to set
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	/**
	 * @return the shprNm
	 */
	public String getShprNm() {
		return shprNm;
	}
	/**
	 * @param shprNm the shprNm to set
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	/**
	 * @return the fwdrCd
	 */
	public String getFwdrCd() {
		return fwdrCd;
	}
	/**
	 * @param fwdrCd the fwdrCd to set
	 */
	public void setFwdrCd(String fwdrCd) {
		this.fwdrCd = fwdrCd;
	}
	/**
	 * @return the fwdrNm
	 */
	public String getFwdrNm() {
		return fwdrNm;
	}
	/**
	 * @param fwdrNm the fwdrNm to set
	 */
	public void setFwdrNm(String fwdrNm) {
		this.fwdrNm = fwdrNm;
	}
	/**
	 * @return the emailTo
	 */
	public String getEmailTo() {
		return emailTo;
	}
	/**
	 * @param emailTo the emailTo to set
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	/**
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}
	/**
	 * @param emailSubject the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	/**
	 * @return the emailContents
	 */
	public String getEmailContents() {
		return emailContents;
	}
	/**
	 * @param emailContents the emailContents to set
	 */
	public void setEmailContents(String emailContents) {
		this.emailContents = emailContents;
	}

	

}