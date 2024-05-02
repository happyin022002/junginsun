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
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

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
	private static final long serialVersionUID = 1L;

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