/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_031Event.java
*@FileTitle : Terminal invoice CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0031Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String costOfcCd = "";
	private String invCfmDt = "";
	private String vndrSeq = "";

	
	public void setCostOfcCd(String costOfcCd){
		this.costOfcCd = costOfcCd;
	}		
	
	public String getCostOfcCd() {
		return costOfcCd;
	}

	public void setInvCfmDt(String invCfmDt){
		this.invCfmDt = invCfmDt;
	}		
	
	public String getInvCfmDt() {
		return invCfmDt;
	}

	public void setVndrSeq(String vndrSeq){
		this.vndrSeq = vndrSeq;
	}		
	
	public String getVndrSeq() {
		return vndrSeq;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get END*/

	public EsdTrs0031Event(){}


	public String getEventName() {
		return "EsdTrs0031Event";
	}

	public String toString() {
		return "EsdTrs0031Event";
	}

}
