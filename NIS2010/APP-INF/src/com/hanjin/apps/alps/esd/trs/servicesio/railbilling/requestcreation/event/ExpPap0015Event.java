/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0015Event.java
*@FileTitle : Rail Billing Request Creation 처리 (Full)
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
 * EXP_PAP_015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0015Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;
	private String bkgVrfyRstCd = null;
	private String bkgVrfyErrCd = null;
	private String bkgVrfyErrLangTpCd = null;
	private VndrUserDetail vndrUserDetailInfo;
	private BookingSummary  bookingSummary;
	private BookingDetail[] bookingDetailList = null;
	private RailRampLocation railRampLocation = null;
	

    /**
     * ExpPap0015Event 객체를 생성
     */
    public ExpPap0015Event(){}

    /**
     * ExpPap0015Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param bkg_no
     * @param bkg_vrfy_rst_cd
     * @param bkg_vrfy_err_cd
     * @param bkg_vrfy_err_lang_tp_cd
     * @param vndrUserDetailInfo
     * @param bookingSummary
     * @param bookingDetailList
     * @param railRampLocation
     */
    public ExpPap0015Event(String user_id,
    						String vender_cd,
    						String bkg_no,
    						String bkg_vrfy_rst_cd,
    						String bkg_vrfy_err_cd,
    						String bkg_vrfy_err_lang_tp_cd,
    						VndrUserDetail vndrUserDetailInfo,
    						BookingSummary  bookingSummary,
    						BookingDetail[] bookingDetailList,
    						RailRampLocation railRampLocation ) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.bkgNo	= bkg_no;
    	this.bkgVrfyRstCd	= bkg_vrfy_rst_cd;
    	this.bkgVrfyErrCd	= bkg_vrfy_err_cd;
    	this.bkgVrfyErrLangTpCd	= bkg_vrfy_err_lang_tp_cd;
    	this.vndrUserDetailInfo	= vndrUserDetailInfo;
    	this.bookingSummary	= bookingSummary;
    	this.bookingDetailList	= bookingDetailList;
    	this.railRampLocation	= railRampLocation;
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
     * 
     * @return
     */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
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
	 * @return Returns the vndrUserDetailInfo.
	 */
	public VndrUserDetail getVndrUserDetailInfo() {
		return vndrUserDetailInfo;
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
	public BookingSummary getBookingSummary() {
		return bookingSummary;
	}
    /**
     * 
     * @return
     */
	public void setBookingSummary(BookingSummary bookingSummary) {
		this.bookingSummary = bookingSummary;
	}
    /**
     * 
     * @return
     */
	public RailRampLocation getRailRampLocation() {
		return railRampLocation;
	}
    /**
     * 
     * @return
     */
	public void setRailRampLocation(RailRampLocation railRampLocation) {
		this.railRampLocation = railRampLocation;
	}
	/**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0015Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0015Event";
    }
}