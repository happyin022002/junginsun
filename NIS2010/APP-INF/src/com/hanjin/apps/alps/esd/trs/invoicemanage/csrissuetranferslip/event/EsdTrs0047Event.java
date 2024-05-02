/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_047Event.java
*@FileTitle : Invoice List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.HashMap;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0047Event extends EventSupport {


	private HashMap hashParam = new HashMap();
	
	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String costOfcCd = "";
	private String fmEffDt = "";
	private String toEffDt = "";
	private String ifStatus = "";
	private String dtStatus = "";
	private String multCsrNo = "";
	private String csrNo = "";
	private String usrId = "";
	private String invOfcCd = "";
	private String aproTpCd = "";
	private String csrTpCd = "";

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getCostOfcCd() {
		return costOfcCd;
	}

	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}

	public String getFmEffDt() {
		return fmEffDt;
	}

	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}

	public String getToEffDt() {
		return toEffDt;
	}

	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}

	public String getIfStatus() {
		return ifStatus;
	}

	public void setIfStatus(String ifStatus) {
		this.ifStatus = ifStatus;
	}


	public String getDtStatus() {
		return dtStatus;
	}


	public void setDtStatus(String dtStatus) {
		this.dtStatus = dtStatus;
	}


	public String getMultCsrNo() {
		return multCsrNo;
	}


	public void setMultCsrNo(String multCsrNo) {
		this.multCsrNo = multCsrNo;
	}


	public String getInvOfcCd() {
		return invOfcCd;
	}

	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}

	public String getAproTpCd() {
		return aproTpCd;
	}

	public void setAproTpCd(String aproTpCd) {
		this.aproTpCd = aproTpCd;
	}

	/**
	 * @return the csrTpCd
	 */
	public String getCsrTpCd() {
		return csrTpCd;
	}

	/**
	 * @param csrTpCd the csrTpCd to set
	 */
	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
	}

	/** HASHPARAM을 대치할 파라미터 set/get END*/
	
	public EsdTrs0047Event(){}

	
	public HashMap getHashParam(){
		return this.hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public String getEventName() {
		return "EsdTrs0047Event";
	}

	public String toString() {
		return "EsdTrs0047Event";
	}
}