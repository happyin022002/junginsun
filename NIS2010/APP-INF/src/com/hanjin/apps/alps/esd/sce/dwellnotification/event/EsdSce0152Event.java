/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdSce0152Event.java
*@FileTitle : Dwell/Delay Notification Sending Status Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.07.25 이수진
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNofifySendStsVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_SCE_0152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_SCE_0152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sujin lee
 * @see HTMLAction 참조
 * @since J2EE 1.6 
 */
public class EsdSce0152Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object Multi Data 처리 */
	private DwellNofifySendStsVO[] dwellNofifySendStsVOs = null;
	
	private String StartDt = null; 
	private String EndDt = null;
	private String ScNo = null;
	private String ScNo2 = null;
	private String CustCd = null;
	
	public EsdSce0152Event(){}
	

	/**
	 * @return the dwellNofifySendStsVOs
	 */
	public DwellNofifySendStsVO[] getDwellNofifySendStsVOs() {
		return dwellNofifySendStsVOs;
	}


	/**
	 * @param dwellNofifySendStsVOs the dwellNofifySendStsVOs to set
	 */
	public void setDwellNofifySendStsVOs(
			DwellNofifySendStsVO[] dwellNofifySendStsVOs) {
		this.dwellNofifySendStsVOs = dwellNofifySendStsVOs;
	}
	
	public String getEventName() {
		return "EsdSce0152Event";
	}
	

	public String toString() {
		return "EsdSce0152Event";
	}
	

	public void setStartDt(String startDt) {
		StartDt = startDt;
	}


	public String getStartDt() {
		return StartDt;
	}


	public void setEndDt(String endDt) {
		EndDt = endDt;
	}


	public String getEndDt() {
		return EndDt;
	}


	public void setScNo(String scNo) {
		ScNo = scNo;
	}


	public String getScNo() {
		return ScNo;
	}


	public void setScNo2(String scNo2) {
		ScNo2 = scNo2;
	}


	public String getScNo2() {
		return ScNo2;
	}
	
	public void setCustCd(String custCd) {
		CustCd = custCd;
	}


	public String getCustCd() {
		return CustCd;
	}




}
