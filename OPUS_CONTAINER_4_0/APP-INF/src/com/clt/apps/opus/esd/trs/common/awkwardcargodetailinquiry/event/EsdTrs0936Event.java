/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_936Event.java
*@FileTitle : BKG CGO SPE Detail Popup - AK
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_936 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_936HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0936Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
    String bkgNo="";
    String troSeq="";
    String cntrNo="";
    String uiContiCd="";
    

	/** ESD_TRS_0936Event */
	public EsdTrs0936Event(){}


	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	public String getTroSeq() {
		return troSeq;
	}


	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}


	public String getCntrNo() {
		return cntrNo;
	}


	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}


	public String getUiContiCd() {
		return uiContiCd;
	}


	public void setUiContiCd(String uiContiCd) {
		this.uiContiCd = uiContiCd;
	}



	/** getEventName */
	public String getEventName() {
		return "EsdTrs0936Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0936Event";
	}

}
