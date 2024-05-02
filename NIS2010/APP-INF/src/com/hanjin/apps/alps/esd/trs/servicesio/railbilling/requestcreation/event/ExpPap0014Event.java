/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0014Event.java
*@FileTitle : Rail Billing Request Creation Verify 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0014Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;
	private String bkgVrfyRstCd = null;
	private String bkgVrfyErrCd = null;
	private String bkgVrfyErrLangTpCd = null;
	private String orgYdCd = null;
	private String destYdCd = null;
	private BookingDetail[] bookingDetailList = null;
	

    /**
     * ExpPap0014Event 객체를 생성
     */
    public ExpPap0014Event(){}

    /**
     * ExpPap0014Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param bkg_no
     * @param bkg_vrfy_rst_cd
     * @param bkg_vrfy_err_cd
     * @param bkg_vrfy_err_lang_tp_cd
     * @param org_yd_cd
     * @param dest_yd_cd
     * @param bookingDetailList
     */
    public ExpPap0014Event(
    		String user_id,
    		String vender_cd,
    		String bkg_no,
    		String bkg_vrfy_rst_cd,
    		String bkg_vrfy_err_cd,
    		String bkg_vrfy_err_lang_tp_cd,
    		String org_yd_cd,
    		String dest_yd_cd,
    		BookingDetail[] bookingDetailList
    		) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.bkgNo	= bkg_no;
    	this.bkgVrfyRstCd	= bkg_vrfy_rst_cd;
    	this.bkgVrfyErrCd	= bkg_vrfy_err_cd;
    	this.bkgVrfyErrLangTpCd	= bkg_vrfy_err_lang_tp_cd;
    	this.orgYdCd	= org_yd_cd;
    	this.destYdCd	= dest_yd_cd;
    	this.bookingDetailList	= bookingDetailList;
    }
    
    /**
     * 
     * @return
     */
	public String getUser_id() {
		return userId;
	}
    /**
     * 
     * @return
     */
	public String getVender_cd() {
		return venderCd;
	}
    /**
     * 
     * @return
     */
	public String getBkg_no() {
		return bkgNo;
	}
	
    /**
	 * @return Returns the bkg_vrfy_rst_cd.
	 */
	public String getBkg_vrfy_rst_cd() {
		return bkgVrfyRstCd;
	}
	
	/**
	 * @return Returns the bkg_vrfy_err_cd.
	 */
	public String getBkg_vrfy_err_cd() {
		return bkgVrfyErrCd;
	}

	/**
	 * @return Returns the bkg_vrfy_err_lang_tp_cd.
	 */
	public String getBkg_vrfy_err_lang_tp_cd() {
		return bkgVrfyErrLangTpCd;
	}

	/**
	 * @return Returns the org_yd_cd.
	 */
	public String getOrg_yd_cd() {
		return orgYdCd;
	}
	
	/**
	 * @return Returns the dest_yd_cd.
	 */
	public String getDest_yd_cd() {
		return destYdCd;
	}

	/**
     * 
     * @return
     */
	public BookingDetail[] getBookingDetailList() {
		return bookingDetailList;
	}
    /**
     * 
     * @return
     */
	public void setBookingDetailList(BookingDetail[] bookingDetailList) {
		this.bookingDetailList = bookingDetailList;
	}
    /**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0014Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0014Event";
    }
}