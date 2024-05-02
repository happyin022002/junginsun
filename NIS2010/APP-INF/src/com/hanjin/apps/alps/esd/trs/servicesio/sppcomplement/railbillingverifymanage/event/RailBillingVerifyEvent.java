/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyEvent.java
*@FileTitle : Rail Billing Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0 
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class RailBillingVerifyEvent extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	private String userID = "";	
	private String bkgNo		= null;
	private String fmYdCd		= null;
	private String bzcSts		= null;
	private String cgoTpCd	= null;
	private	String errMsgCd   = null;	// 에러 코드
	private	String langTpCd   = null; // ENG	
	private String toYdCd     = null; // 2007.05.18  추가.	
	private RailBillingVerifyList[] railBillingVerifyList = null;

	/**
	 * @return Returns the bkgNo.
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * @param bkgNo The bkgNo to set.
	 */
	public void setBkg_no(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return Returns the fmYdCd.
	 */
	public String getFm_yd_cd() {
		return fmYdCd;
	}

	/**
	 * @param bzcSts The bzcSts to set.
	 */
	public void setFm_yd_cd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * @return Returns the bzcSts.
	 */
	public String getBzc_sts() {
		return bzcSts;
	}

	/**
	 * @param bzcSts The bzcSts to set.
	 */
	public void setBzc_sts(String bzcSts) {
		this.bzcSts = bzcSts;
	}	
	
	/**
	 * @return Returns cgoTpCd.
	 */
	public String getCgo_tp_cd() {
		return cgoTpCd;
	}

	/**
	 * @param cgoTpCd 
	 */
	public void setCgo_tp_cd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * @return Returns errMsgCd.
	 */
	public String getErr_msg_cd() {
		return errMsgCd;
	}
	
	/**
	 * @param errMsgCd 
	 */
	public void setErr_msg_cd(String errMsgCd) {
		this.errMsgCd = errMsgCd;
	}
	
	/**
	 * @return Returns langTpCd.
	 */
	public String getLang_tp_cd() {
		return langTpCd;
	}

	/**
	 * @param langTpCd 
	 */
	public void setLang_tp_cd(String langTpCd) {
		this.langTpCd = langTpCd;
	}
	
	
	/**
	 * @return Returns toYdCd.
	 */
	public String getTo_yd_cd() {
		return toYdCd;
	}

	/**
	 * @param toYdCd 
	 */
	public void setTo_yd_cd(String toYdCd) {
		this.toYdCd = toYdCd;
	}
	
	/**
	 * @return Returns the userID.
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID The userID to set.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEventName() {
        return "RailBillingVerifyEvent";
    }

    public String toString() {
        return "RailBillingVerifyEvent";
    }	

	/**
	 * 
	 * @param userID
	 * @param cgoTpCd
	 * @param bkgNo
	 * @param fmYdCd
	 * @param bzcSts
	 * @param errMsgCd
	 * @param langTpCd
	 * @param toYdCd
	 * @param railBillingVerifyList
	 */
	public RailBillingVerifyEvent(
			String userID,
			String cgoTpCd,
			String bkgNo,
			String fmYdCd,
			String bzcSts,
			String errMsgCd,
			String langTpCd,
			String toYdCd,
			RailBillingVerifyList[] railBillingVerifyList 
    ) {
		this.userID			= userID;		
		this.cgoTpCd	  	= cgoTpCd;
		this.bkgNo 		= bkgNo;
		this.fmYdCd		= fmYdCd;
		this.bzcSts		= bzcSts;
		this.errMsgCd		= errMsgCd;
		this.langTpCd     = langTpCd;
		this.toYdCd       = toYdCd;
		this.railBillingVerifyList = railBillingVerifyList;		  
	}
		
	public RailBillingVerifyList[] getRailBillingVerifyList() {	
		return railBillingVerifyList;	
	}
		
	public void setRailBillingVerifyList(RailBillingVerifyList[] railBillingVerifyList) {
		this.railBillingVerifyList = railBillingVerifyList;    
	}
			


}
