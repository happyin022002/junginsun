/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0010EventResponse.java
*@FileTitle : Rail Billing Request Creation 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import org.apache.commons.lang.StringEscapeUtils;

import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_010 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0010EventResponse extends GeneralEventResponse {
	
	private String bkgVrfyRstCd = "";
	private String bkgVrfyErrCd = "";
	private String bkgVrfyErrLangTpCd = "";
	private String bkgVrfyErrMsg = "";
	private BookingSummary  bookingSummary;
	private BookingDetail[] bookingDetailList;
	private RailRampLocation railRampLocationInfo;
	
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0010EventResponse 객체를 생성
     */
    public ExpPap0010EventResponse() {
    }

    /**
     * EXP_PAP_010 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0010EventResponse 객체를 생성
     * @param bkgVrfyRstCd
     * @param bkgVrfyErrCd
     * @param bkgVrfyErrLangTpCd
     * @param bkgVrfyErrMsg
     * @param bookingSummary
     * @param bookingDetailList
     * @param railRampLocationInfo
     * @param successFlag
     */
    public ExpPap0010EventResponse(String bkgVrfyRstCd,
									String bkgVrfyErrCd,
									String bkgVrfyErrLangTpCd,
									String bkgVrfyErrMsg,
    								BookingSummary  bookingSummary, 
    								BookingDetail[] bookingDetailList,
    								RailRampLocation railRampLocationInfo,
    		                        String successFlag) {
    	this.bkgVrfyRstCd = bkgVrfyRstCd;
    	this.bkgVrfyErrCd = bkgVrfyErrCd;
    	this.bkgVrfyErrLangTpCd = bkgVrfyErrLangTpCd;
    	this.bkgVrfyErrMsg = StringEscapeUtils.escapeXml(bkgVrfyErrMsg);
    	this.bookingSummary = bookingSummary;
    	this.bookingDetailList = bookingDetailList;
    	this.railRampLocationInfo = railRampLocationInfo;
        this.successFlag=successFlag;
    }
    
    /**
	 * @return Returns the bkgVrfyErrCd.
	 */
	public String getBkgVrfyErrCd() {
		return bkgVrfyErrCd;
	}

	/**
	 * @return Returns the bkgVrfyErrLangTpCd.
	 */
	public String getBkgVrfyErrLangTpCd() {
		return bkgVrfyErrLangTpCd;
	}

	/**
	 * @return Returns the bkgVrfyErrMsg.
	 */
	public String getBkgVrfyErrMsg() {
		return bkgVrfyErrMsg;
	}

	/**
	 * @return Returns the bkgVrfyRstCd.
	 */
	public String getBkgVrfyRstCd() {
		return bkgVrfyRstCd;
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
	public BookingSummary getBookingSummary() {
		return bookingSummary;
	}
    /**
     * 
     * @return
     */
	public RailRampLocation getRailRampLocationInfo() {
		return railRampLocationInfo;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0010EventResponse)을 반환
     * 
     * @return String ExpPap0010EventResponse
     */
    public String toString() {
        return "ExpPap0010EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0010EventResponse)을 반환
     * 
     * @return String ExpPap0010EventResponse
     */
    public String getEventName() {
        return "ExpPap0010EventResponse";
    }
}