/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0020EventResponse.java
*@FileTitle : Rail Billing Request Creation Excel 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

import com.clt.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - lass ExpPap0020 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0020EventResponse extends GeneralEventResponse {
	
	private BookingDetail[] bookingDetailList;
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0020EventResponse 객체를 생성
     */
    public ExpPap0020EventResponse() {
    }

    /**
     * EXP_PAP_020 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0020EventResponse 객체를 생성
     * @param bookingDetailList
     * @param successFlag
     */
    public ExpPap0020EventResponse(
    			BookingDetail[] bookingDetailList,
    			String successFlag
    			) {
        this.bookingDetailList = bookingDetailList;
        this.successFlag = successFlag;
    }
    
	/**
	 * @return Returns the bookingDetailList.
	 */
	public BookingDetail[] getBookingDetailList() {
		BookingDetail[] rtnList = null;
		if(this.bookingDetailList != null){
			rtnList = Arrays.copyOf(bookingDetailList, bookingDetailList.length);
		}
		return rtnList;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0020EventResponse)을 반환
     * 
     * @return String ExpPap0020EventResponse
     */
    public String toString() {
        return "ExpPap0020EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0020EventResponse)을 반환
     * 
     * @return String ExpPap0020EventResponse
     */
    public String getEventName() {
        return "ExpPap0020EventResponse";
    }
}