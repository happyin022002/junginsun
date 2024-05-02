/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_937Event.java
*@FileTitle : BKG CGO SPE Detail Popup - BB
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_0937 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0937HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0937Event extends EventSupport {
	String bkgNo="";
	
	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	/** ESD_TRS_937Event */
	public EsdTrs0937Event(){}


	/** getEventName */
	public String getEventName() {
		return "EsdTrs0937Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0937Event";
	}

}
