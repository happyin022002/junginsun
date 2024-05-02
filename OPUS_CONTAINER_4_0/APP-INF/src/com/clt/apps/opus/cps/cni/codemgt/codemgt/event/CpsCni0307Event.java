/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0307Event.java
*@FileTitle : R.O.E. (Rate of Exchange) Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0307 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0307HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0307HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0307Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** From Date */
	private String fmDt = "";
	
	/** To Date */
	private String toDt = "";
	
	/** Currency Cd */
	private String currCd = "";

	public CpsCni0307Event(){}
	
	public void setFmDt(String fmDt){
		this. fmDt = fmDt;
	}
	
	public void setToDt(String toDt){
		this. toDt = toDt;
	}
	
	public void setCurrCd(String currCd){
		this. currCd = currCd;
	}

	public String getFmDt(){
		return fmDt;
	}

	public String getToDt(){
		return toDt;
	}

	public String getCurrCd(){
		return currCd;
	}

}