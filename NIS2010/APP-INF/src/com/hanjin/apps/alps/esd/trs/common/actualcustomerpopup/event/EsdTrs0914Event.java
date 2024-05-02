/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0914Event.java
*@FileTitle : ACTUAL CUSTOMER POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-09
*@LastModifier : eunhee
*@LastVersion : 1.0
* 2009-09-03 eunhee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0914 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0914HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author eunhee
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0914Event  extends EventSupport{
	
	 String dorNodCd=""; //Door Node
	 String actCustCd="";//Customer Code
	 String fctryNm="";//Factory Name
	 String boundCd="";
	 String contiCd="";
	 
	 String actCustCntCd ="";
	 String actCustSeq ="";
	 
	 public String getAct_cust_cnt_cd() {
		return actCustCntCd;
	}

	public void setAct_cust_cnt_cd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	public String getAct_cust_seq() {
		return actCustSeq;
	}

	public void setAct_cust_seq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}

	public String getUsa_trsp_act_cust_no() {
		return usaTrspActCustNo;
	}

	public void setUsa_trsp_act_cust_no(String usaTrspActCustNo) {
		this.usaTrspActCustNo = usaTrspActCustNo;
	}
	String usaTrspActCustNo="";
	 
	 
	/** getEventName */
	public String getEventName() {
		return "EsdTrs0914Event";
	} 
	 
	public String getDor_nod_cd() {
		return dorNodCd;
	}
	public void setDor_nod_cd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	public String getAct_cust_cd() {
		return actCustCd;
	}
	public void setAct_cust_cd(String actCustCd) {
		this.actCustCd = actCustCd;
	}
	public String getFctry_nm() {
		return fctryNm;
	}
	public void setFctry_nm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	public String getBound_cd() {
		return boundCd;
	}
	public void setBound_cd(String boundCd) {
		this.boundCd = boundCd;
	}
	public String getConti_cd() {
		return contiCd;
	}
	public void setConti_cd(String contiCd) {
		this.contiCd = contiCd;
	}
 
}
