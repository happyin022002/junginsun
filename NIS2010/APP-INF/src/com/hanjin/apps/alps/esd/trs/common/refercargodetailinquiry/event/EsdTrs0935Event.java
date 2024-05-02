/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_935Event.java
*@FileTitle : BKG CGO SPE Detail Popup - RF
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.refercargodetailinquiry.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_935 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_935HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0935Event extends EventSupport {
	String bkgNo ="";
	String cntrNo="";
    String uiContiCd="";
    String troSeq="";
    
	/** ESD_TRS_0935Event */
	public EsdTrs0935Event(){}
	
    public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	public String getTroSeq() {
		return troSeq;
	}
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	/** getEventName */
	public String getEventName() {
		return "EsdTrs0935Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0935Event";
	}
	
}
