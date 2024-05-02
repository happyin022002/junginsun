/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : IfSchemaVO.java
 *@FileTitle : IfSchemaVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.07
 *@LastModifier : 최종혁
 *@LastVersion : 1.0
 * 2011.10.07 최종혁 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.servicesio.webdo.vo;

import java.io.Serializable;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IfSchemaSppVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private String usrPhnNo = null;
	/* Column Info */
	private String actCustCtyNm = null;
	/* Column Info */
	private String actCustZipCd = null;
	/* Column Info */
	private String actCustN1stAddr = null;
	/* Column Info */
	private String actCustSteNm = null;
	/* Column Info */
	private String doRmk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String ifSysKndCd = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String updUsrId = null;

	public String getUsrPhnNo() {
		return usrPhnNo;
	}

	public void setUsrPhnNo(String usrPhnNo) {
		this.usrPhnNo = usrPhnNo;
	}

	public String getActCustCtyNm() {
		return actCustCtyNm;
	}

	public void setActCustCtyNm(String actCustCtyNm) {
		this.actCustCtyNm = actCustCtyNm;
	}

	public String getActCustZipCd() {
		return actCustZipCd;
	}

	public void setActCustZipCd(String actCustZipCd) {
		this.actCustZipCd = actCustZipCd;
	}

	public String getActCustN1stAddr() {
		return actCustN1stAddr;
	}

	public void setActCustN1stAddr(String actCustN1stAddr) {
		this.actCustN1stAddr = actCustN1stAddr;
	}

	public String getActCustSteNm() {
		return actCustSteNm;
	}

	public void setActCustSteNm(String actCustSteNm) {
		this.actCustSteNm = actCustSteNm;
	}

	public String getDoRmk() {
		return doRmk;
	}

	public void setDoRmk(String doRmk) {
		this.doRmk = doRmk;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCntcPsonPhnNo() {
		return cntcPsonPhnNo;
	}

	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}

	public String getPagerows() {
		return pagerows;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getCntcPsonFaxNo() {
		return cntcPsonFaxNo;
	}

	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getEqNo() {
		return eqNo;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	public String getFctryNm() {
		return fctryNm;
	}

	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}

	public String getCreOfcCd() {
		return creOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public String getCntcPsonNm() {
		return cntcPsonNm;
	}

	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}

	public String getIfSysKndCd() {
		return ifSysKndCd;
	}

	public void setIfSysKndCd(String ifSysKndCd) {
		this.ifSysKndCd = ifSysKndCd;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
}
